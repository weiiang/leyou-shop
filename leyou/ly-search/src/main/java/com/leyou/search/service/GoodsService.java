package com.leyou.search.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leyou.common.vo.ResponseResult;
import com.leyou.pojo.Spu;
import com.leyou.search.api.ItemApi;
import com.leyou.search.pojo.Goods;
import com.leyou.search.repository.GoodsRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;


/**
 * @ClassName GoodsService
 * @Description 商品搜索
 * @Author wq
 * @Date 2018/12/27 10:02
 * @Version 1.0.0
 */
@Service
public class GoodsService {
    @Autowired
    private ItemApi itemApi;

    @Autowired
    private GoodsRepository goodsRepository;

    private Logger logger = LoggerFactory.getLogger(GoodsService.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 同步索引库
     * @return
     * @throws IOException
     */
    public ResponseResult syncDataToIndex() throws IOException {
        long start= System.currentTimeMillis();
        logger.info("开始查询封装数据:"+start);
        List<Goods> goodsList = new ArrayList<>();
        ResponseResult responseResult = itemApi.findAllSpu().getBody();
        List<Map> spuList = (List<Map>) responseResult.getData();
        for (Map spu: spuList) {
            Goods goods = new Goods();
            goods.setId(((Integer) spu.get("id")).longValue());
            goods.setSubTitle((String) spu.get("subTitle"));
            goods.setBrandId(((Integer)spu.get("brandId")).longValue());
            goods.setCid1(((Integer) spu.get("cid1")).longValue());
            goods.setCid2(((Integer) spu.get("cid2")).longValue());
            goods.setCid3(((Integer) spu.get("cid3")).longValue());
            goods.setCreateTime(Long.parseLong( spu.get("createTime")+""));

            // 标题+品牌+分类
            List<Long> cids = Arrays.asList(((Integer) spu.get("cid1")).longValue()
                    , ((Integer) spu.get("cid2")).longValue()
                    , ((Integer) spu.get("cid3")).longValue());
            List<Map> cidList = (List<Map>) itemApi.selectCategoryListByIdList(cids).getBody().getData();
            String abcName = "";
            List<String> nameList = new ArrayList<String>(){{
                cidList.forEach(m -> {{
                    add((String) m.get("name"));
                }
                });
            }};
            //分类名称
            abcName = StringUtils.join(nameList, "/");
            String title = (String) spu.get("title");
            Map responseResult1 = (Map) itemApi.selectBrandById(((Integer) spu.get("brandId")).longValue()).getBody().getData();
            Map brand = (Map) responseResult1.get("brand");
            String name = (String) brand.get("name");
            goods.setAll(abcName+" "+ brand+" "+ title);
            //价格数组
            List<Map> skuList = (List<Map>) itemApi.findSkuListBySpuId(((Integer) spu.get("id")).longValue()).getBody().getData();
            List<Long> prices = new ArrayList<Long>(){{
                skuList.forEach(m -> {{
                    add(((Integer) m.get("price")).longValue());
                }
                });
            }};
            goods.setPrice(prices);

            //封装sku
            List<Map> skus = new ArrayList<>();
            skuList.forEach(s -> {
                Map m = new HashMap(4);
                m.put("id", s.get("id"));
                m.put("subTitle", s.get("title"));
                m.put("price", s.get("price"));
                m.put("image", StringUtils.isNotBlank(s.get("images")+"") ? StringUtils.substringBefore(s.get("images").toString(), ",") : "");
                skus.add(m);
            });
            goods.setSkus(objectMapper.writeValueAsString(skus));

            //封装规格参数
            Map spuDetails = (Map) itemApi.findSpuDetailsBySpuId(((Integer)spu.get("id")).longValue()).getBody().getData();
            // 1.查询可以用来搜索的规格参数
            List<Map> specParamList = (List<Map>) itemApi.findSpecByParam(((Integer) spu.get("cid3")).longValue(), true).getBody().getData();

            // 2.获取SPU详情的通用规格参数和特有规格参数
            // spuDetails.get("genericSpec");拿到的是String, 不能强转为Map
            String genericSpecString = (String) spuDetails.get("genericSpec");
            Map genericSpec = objectMapper.readValue(genericSpecString, new TypeReference<Map<String, Object>>() {});
            String specialSpecString = (String) spuDetails.get("specialSpec");
            Map specialSpec = objectMapper.readValue(specialSpecString, new TypeReference<Map<String, Object>>() {});

            //格式封装
            Map<String, Object> specMap = new HashMap<>();
            specParamList.forEach(param -> {
                String key = (String) param.get("name"), value = "";
                boolean isGeneric = (boolean) param.get("generic");
                boolean isNumeric = (boolean) param.get("numeric");
                if (isGeneric){
                    value =  genericSpec.get(param.get("id").toString())+"";
                    if (isNumeric){
                        value = chooseSegment(value, param);
                    }
                    specMap.put(key, (StringUtils.isNotBlank(value) ? value : "其他"));
                }else {
                    value = specialSpec.get(param.get("id").toString()).toString();
                    specMap.put(key, (StringUtils.isNotBlank(value) ? value : "其他"));
                }
            });
            goods.setSpecs(specMap);
            goodsList.add(goods);
        }
        long end= System.currentTimeMillis();
        logger.info("数据查询封装完成:"+end);
        logger.info("查询并封装数据耗时:"+ (end - start)+"ms");
        return ResponseResult.successWithData(goodsList, HttpStatus.OK);
    }

    /**
     * 将商品的价格改为价格所在范围,方便过滤
     * @param value
     * @param p
     * @return
     */
    private String chooseSegment(String value, Map p) {
        double val = Double.parseDouble(value);
        String result = "其它";
        // 保存数值段
        for (String segment : p.get("segments").toString().split(",")) {
            String[] segs = segment.split("-");
            // 获取数值范围
            double begin = Double.parseDouble(segs[0]);
            double end = Double.MAX_VALUE;
            if(segs.length == 2){
                end = Double.parseDouble(segs[1]);
            }
            // 判断是否在范围内
            if(val >= begin && val < end){
                if(segs.length == 1){
                    result = segs[0] + p.get("unit") + "以上";
                }else if(begin == 0){
                    result = segs[1] + p.get("unit") + "以下";
                }else{
                    result = segment + p.get("unit");
                }
                break;
            }
        }
        return result;
    }
}
