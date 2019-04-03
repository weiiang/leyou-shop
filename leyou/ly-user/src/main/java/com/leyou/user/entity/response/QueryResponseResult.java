package com.leyou.user.entity.response;


public class QueryResponseResult<T> extends ResponseResult {

    QueryResult<T> queryResult;

    public QueryResponseResult(ResultCode resultCode,QueryResult queryResult){
        super(resultCode);
       this.queryResult = queryResult;
    }

    public QueryResult<T> getQueryResult() {
        return queryResult;
    }

    public void setQueryResult(QueryResult<T> queryResult) {
        this.queryResult = queryResult;
    }

    @Override
    public String toString() {
        return "QueryResponseResult{" +
                "queryResult=" + queryResult +
                '}';
    }
}
