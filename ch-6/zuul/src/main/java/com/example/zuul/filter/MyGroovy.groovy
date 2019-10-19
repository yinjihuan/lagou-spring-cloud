import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import com.netflix.zuul.exception.ZuulException
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants
 
class GroovyFilter extends ZuulFilter {
	
    @Override
    String filterType() {
        return FilterConstants.PRE_TYPE
    }
 
    @Override
    int filterOrder() {
        return 1
    }
 
    @Override
    boolean shouldFilter() {
        return true
    }
 
    @Override
    Object run() throws ZuulException {
        println("Groovy Filter run ....")
        return null
    }
}