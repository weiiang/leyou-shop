package com.leyou.search.controller;

import com.leyou.common.vo.ResponseResult;
import com.leyou.search.pojo.test.Item;
import com.leyou.search.repository.ItemRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ItemRepository
 * @Description 测试索引库对数据的增删查改
 * @Author wq
 * @Date 2019/1/7 14:25
 * @Version 1.0.0
 */
@Api
@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @PostMapping
    @ApiOperation("插入数据")
    public ResponseEntity<ResponseResult> insert(){
        Item item = new Item(1L, "小米手机7", " 手机",
                "小米", 3499.00, "http://image.leyou.com/13123.jpg");
        Item save = itemRepository.save(item);
        return ResponseEntity.status(200).body(ResponseResult.successWithDataAndMsg(save,"新增数据成功",  HttpStatus.OK));
    }

    @PostMapping("/batch")
    @ApiOperation("批量插入数据")
    public ResponseEntity<ResponseResult> batchInsert(){
        List<Item> list = new ArrayList<>();
        list.add(new Item(1L, "小米手机7", "手机", "小米", 3299.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(2L, "坚果手机R1", "手机", "锤子", 3699.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(3L, "华为META10", "手机", "华为", 4499.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(4L, "小米Mix2S", "手机", "小米", 4299.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(5L, "荣耀V10", "手机", "华为", 2799.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(6L, "坚果手机R2", " 手机", "锤子", 3699.00, "http://image.leyou.com/123.jpg"));
        list.add(new Item(7L, "华为META11", " 手机", "华为", 4499.00, "http://image.leyou.com/3.jpg"));
        // 接收对象集合，实现批量新增
        List<Item> items = (List<Item>) itemRepository.saveAll(list);
        return ResponseEntity.status(200).body(ResponseResult.successWithDataAndMsg(items,"新增数据成功",  HttpStatus.OK));
    }

    @PutMapping
    @ApiOperation("修改数据")
    public ResponseEntity<ResponseResult> update(){
        Item item = new Item(1L, "小米手机8", " 手机",
                "小米", 3489.00, "http://image.leyou.com/13123.jpg");
        Item save = itemRepository.save(item);
        return ResponseEntity.status(200).body(ResponseResult.successWithDataAndMsg(save,"修改数据成功",  HttpStatus.OK));
    }

    @GetMapping("/all")
    @ApiOperation("查询全部")
    public ResponseEntity<ResponseResult> listAll(){
        //查询全部并按照价格降序排序
        Iterable<Item> items = itemRepository.findAll(Sort.by(Sort.Direction.DESC,"price"));
        return ResponseEntity.status(200).body(ResponseResult.successWithDataAndMsg(items,"查询数据成功",  HttpStatus.OK));
    }

    @GetMapping("/price")
    @ApiOperation("查询全部")
    public ResponseEntity<ResponseResult> listAllByPrice(@RequestParam double price1,@RequestParam  double price2){
        //按价格查询全部并按照价格降序排序
        Iterable<Item> items = itemRepository.findByPriceBetween(price1, price2);
        return ResponseEntity.status(200).body(ResponseResult.successWithDataAndMsg(items,"查询数据成功",  HttpStatus.OK));
    }


    //-------------------------------------------------------------------------------高级查询-------------------------------------------------------------------------------------------------

    @GetMapping("/entry")
    @ApiOperation("词条查询")
    public ResponseEntity<ResponseResult> listByEntry(@RequestParam String entry,@RequestParam  Object value){
        //按价格查询全部并按照价格降序排序
        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("title",value);
        Iterable<Item> search = itemRepository.search(queryBuilder);
        return ResponseEntity.status(200).body(ResponseResult.successWithDataAndMsg(search,"查询数据成功",  HttpStatus.OK));
    }

    @GetMapping("/custom")
    @ApiOperation("自定义查询")
    public ResponseEntity<ResponseResult> listByCustom(){
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本的分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery("title", "小米"));
        // 执行搜索，获取结果
        Page<Item> items = this.itemRepository.search(queryBuilder.build());
        return ResponseEntity.status(200).body(ResponseResult.successWithDataAndMsg(items,"查询数据成功",  HttpStatus.OK));
    }

    @GetMapping("/page")
    @ApiOperation("分页查询")
    public ResponseEntity<ResponseResult> pageList(@RequestParam(required = false, defaultValue = "1") int page,
                                                   @RequestParam(required = false, defaultValue = "5") int size){
        //1.创建NativeSearchQueryBuilder用做搜索
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        //2.拼接查询条件
        queryBuilder.withQuery(QueryBuilders.matchQuery("title", "小米"));
        //3.分页
        queryBuilder.withPageable(PageRequest.of(page, size));
        //4.排序
        queryBuilder.withSort(SortBuilders.fieldSort("price").order(SortOrder.DESC));
        //5.查询
        Page<Item> items = itemRepository.search(queryBuilder.build());
        return ResponseEntity.status(200).body(ResponseResult.successWithDataAndMsg(items,"分页查询数据成功",  HttpStatus.OK));
    }

    @GetMapping("/agg")
    @ApiOperation("按照品牌聚合为桶")
    public ResponseEntity<ResponseResult> aggre(){
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 过滤掉查询结果
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{""}, null));
        //创建聚合查询条件
        TermsAggregationBuilder field = AggregationBuilders.terms("brands").field("brand");
        //添加在queryBuilder
        queryBuilder.addAggregation(field);
        // 2、查询,
        AggregatedPage<Item> search = (AggregatedPage<Item>) itemRepository.search(queryBuilder.build());
        //需要把结果强转为AggregatedPage类型
        StringTerms terms = (StringTerms) search.getAggregation("brands");
        // 4、从结果中取出名为brands的那个聚合，
        List<StringTerms.Bucket> buckets = terms.getBuckets();
        // 因为是利用String类型字段来进行的term聚合，所以结果要强转为StringTerm类型
        // 5、获取桶
        List<Map> returnList = new ArrayList<>();
        for (StringTerms.Bucket b: buckets) {
            Map map = new HashMap();
            map.put(b.getKeyAsString(), b.getDocCount());
            returnList.add(map);
        }
        return ResponseEntity.status(200).body(ResponseResult.successWithDataAndMsg(returnList,"按品牌查询数据成功",  HttpStatus.OK));
    }

    @GetMapping("/aggAndAvg")
    @ApiOperation("按照品牌聚合为桶再进行嵌套聚合求桶内平均值")
    public ResponseEntity<ResponseResult> aggreAndAvg(){
        //创建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        //过滤查询字段
        queryBuilder.withSourceFilter(new FetchSourceFilter(null, null));
        //添加聚合条件
        queryBuilder.addAggregation(AggregationBuilders.terms("brands").field("brand")
            //子聚合条件
            .subAggregation(AggregationBuilders.avg("priceAvg").field("price")));
        //查询
        Page<Item> search = itemRepository.search(queryBuilder.build());
        //强转
        AggregatedPage<Item> aggPage = (AggregatedPage<Item>) search;
        //获取Aggregation并再强转为StringTerms
        StringTerms terms = (StringTerms) aggPage.getAggregation("brands");
        //获取桶
        List<StringTerms.Bucket> buckets = terms.getBuckets();
        //构造返回结果
        List<Map> returnList = new ArrayList<>();
        for (StringTerms.Bucket b: buckets) {
            Map<String, HashMap> map = new HashMap<>();
            map.put(b.getKeyAsString(), new HashMap(){{put("count", b.getDocCount());
                //获取平均值
                put("avg", b.getAggregations().asMap().get("priceAvg"));}});
            returnList.add(map);
        }
        return ResponseEntity.status(200).body(ResponseResult.successWithDataAndMsg(returnList,"嵌套聚合数据成功",  HttpStatus.OK));
    }
}
