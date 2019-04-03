package com.leyou.apigateway;

import com.netflix.client.http.HttpRequest;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @ClassName PreZuulFilter
 * @Description TODO
 * @Author wq
 * @Date 2019/4/3 10:37
 * @Version 1.0.0
 */
@Component
public class PreZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 6;
    }

    /**
     * 执行该过滤方法的条件
     * @return
     */
    @Override
    public boolean shouldFilter() {
//        RequestContext context = RequestContext.getCurrentContext();
//        return context.getRequest().getParameter("service") != null;

        return true;
    }

    /**
     * 可以修改请求的Hearder和请求参数
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {

        RequestContext context = RequestContext.getCurrentContext();

        HttpServletRequest request = context.getRequest();

        request.setAttribute("token", UUID.randomUUID());

        context.setRequest(request);

        System.out.println(context.toString());

        return null;
    }
}
