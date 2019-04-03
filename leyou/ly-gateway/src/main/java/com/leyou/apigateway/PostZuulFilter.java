package com.leyou.apigateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

/**
 * @ClassName PostZuulFilter
 * @Description TODO
 * @Author wq
 * @Date 2019/4/3 10:37
 * @Version 1.0.0
 */
@Component
public class PostZuulFilter  extends ZuulFilter {
    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 999;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("post");
        RequestContext context = RequestContext.getCurrentContext();

        System.out.println(context.toString());

        return null;
    }
}
