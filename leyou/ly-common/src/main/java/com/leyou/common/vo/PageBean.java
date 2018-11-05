package com.leyou.common.vo;

import java.util.List;

/**
 * @ClassName PageBean
 * @Description 分页显示结果
 * @Author wq
 * @Date 2018/11/2 9:42
 * @Version 1.0.0
 */
public class PageBean<T> {

    private Long total;
    private Long totalPage;
    private List<T> records;

    public PageBean(Long total, Long totalPage, List<T> records) {
        this.total = total;
        this.totalPage = totalPage;
        this.records = records;
    }

    public PageBean(Long total, List<T> records) {
        this.total = total;
        this.records = records;
    }

    public PageBean() {}

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
