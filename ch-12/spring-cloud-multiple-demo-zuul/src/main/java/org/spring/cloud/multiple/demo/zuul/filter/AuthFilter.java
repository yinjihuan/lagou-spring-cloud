package org.spring.cloud.multiple.demo.zuul.filter;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.spring.cloud.multiple.demo.common.base.Response;
import org.spring.cloud.multiple.demo.common.base.ResponseCode;
import org.spring.cloud.multiple.demo.common.utils.JWTUtils;
import org.spring.cloud.multiple.demo.common.utils.JWTUtils.JWTResult;
import org.spring.cloud.multiple.demo.common.utils.JsonUtils;
import org.springframework.stereotype.Component;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CreateCache;
import com.ctrip.framework.apollo.spring.annotation.ApolloJsonValue;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuthFilter extends ZuulFilter {

	@ApolloJsonValue("${whiteapis}")
	private List<String> whiteApis = Arrays.asList("/spring-cloud-multiple-demo-user-provider/login");
	
	@CreateCache(name="logoutCache:", expire = 1000)
	private Cache<String, Long> logoutCache;
	
    public AuthFilter() {
        super();
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public Object run() {
    	log.info("请求进来了");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String uri = request.getRequestURI();
        String token = request.getHeader("token");
        // API白名单内直接放行
        if (whiteApis.contains(uri)) {
        	return null;
        }
        
        // 不在白名单中则进行Token验证
    	if (StringUtils.isBlank(token)) {
    		ctx.setSendZuulResponse(false);
            ctx.set("isSuccess", false);
            ctx.setResponseBody(JsonUtils.toJson(Response.fail("非法请求【缺少token】", ResponseCode.NO_AUTH_CODE)));
            ctx.getResponse().setContentType("application/json; charset=utf-8");
            return null;
    	}
    
    	// 验证Token是否有效
    	JWTResult jwResult = JWTUtils.getInstance().checkToken(token);
    	if (!jwResult.isStatus()) {
    		ctx.setSendZuulResponse(false);
            ctx.set("isSuccess", false);
            ctx.setResponseBody(JsonUtils.toJson(Response.fail(jwResult.getMsg(), jwResult.getCode())));
            ctx.getResponse().setContentType("application/json; charset=utf-8");
            return null;
    	}
    	
    	// 此token已经注销
    	Long cacheResult = logoutCache.get(token);
    	if (cacheResult != null) {
    		ctx.setSendZuulResponse(false);
            ctx.set("isSuccess", false);
            ctx.setResponseBody(JsonUtils.toJson(Response.fail("非法请求", ResponseCode.NO_AUTH_CODE)));
            ctx.getResponse().setContentType("application/json; charset=utf-8");
            return null;
    	}
    	ctx.addZuulRequestHeader("uid", jwResult.getUid());
        return null;
    }
    
}
