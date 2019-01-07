package com.leyou.search.service;

import com.leyou.common.vo.ResponseResult;
import com.leyou.pojo.Spu;
import com.leyou.search.api.ItemApi;
import com.leyou.search.pojo.Goods;
import com.leyou.search.repository.GoodsRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


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

    public ResponseResult syncDataToIndex() {

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
            List<Long> cids = new ArrayList<Long>(){{
                add(((Integer) spu.get("cid1")).longValue());
                add(((Integer) spu.get("cid2")).longValue());
                add(((Integer) spu.get("cid3")).longValue());
            }};

            List<Map> cidList = (List<Map>) itemApi.selectCategoryListByIdList(cids).getBody().getData();
            String abcName = "";
            List<String> nameList = new ArrayList<String>(){{
                cidList.forEach(m -> {{
                    add((String) m.get("name"));
                }
                });
            }};
            abcName = StringUtils.join(nameList, "/");
            goods.setAll(abcName);
            //价格数组
            List<Map> skuList = (List<Map>) itemApi.findSkuListBySpuId(((Integer) spu.get("id")).longValue()).getBody().getData();
            List<Long> prices = new ArrayList<Long>(){{
                skuList.forEach(m -> {{
                    add(((Integer) m.get("price")).longValue());
                }
                });
            }};
            goods.setPrice(prices);
            goods.setSkus(skuList.toString());
            goods.setSpecs(null);
            goodsList.add(goods);
        }
        return ResponseResult.successWithData(goodsList, HttpStatus.OK);
    }
}
