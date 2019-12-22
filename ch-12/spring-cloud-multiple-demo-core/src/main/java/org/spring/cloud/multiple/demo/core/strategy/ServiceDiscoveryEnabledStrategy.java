package org.spring.cloud.multiple.demo.core.strategy;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.nepxion.discovery.plugin.framework.adapter.PluginAdapter;
import com.nepxion.discovery.plugin.strategy.adapter.DiscoveryEnabledStrategy;
import com.nepxion.discovery.plugin.strategy.service.context.ServiceStrategyContextHolder;
import com.netflix.loadbalancer.Server;

public class ServiceDiscoveryEnabledStrategy implements DiscoveryEnabledStrategy {
    private static final Logger LOG = LoggerFactory.getLogger(ServiceDiscoveryEnabledStrategy.class);

    @Autowired
    private ServiceStrategyContextHolder serviceStrategyContextHolder;

    @Autowired
    private GrayInfo grayInfo;
    
    @Autowired
	protected PluginAdapter pluginAdapter;
	  
    @Override
    public boolean apply(Server server) {
        return applyFromHeader(server);
    }

    private boolean applyFromHeader(Server server) {
    	Map<String, String> metadata = pluginAdapter.getServerMetadata(server);
        ServletRequestAttributes attributes = serviceStrategyContextHolder.getRestAttributes();
        if (attributes == null) {
            return true;
        }
        HttpServletRequest request = attributes.getRequest();
        // 有version和address 表示是灰度请求，直接放行，使用框架的灰度发布逻辑
        if (StringUtils.isNotBlank(request.getHeader("n-d-version")) || StringUtils.isNotBlank(request.getHeader("n-d-address"))) {
            return true;
        }
        
        String serviceId = server.getMetaInfo().getAppName().toLowerCase();
        
        // 版本号灰度
        Map<String, List<String>> versions = grayInfo.getGrayVersions();
        if (versions != null) {
            List<String> versionList = versions.get(serviceId);
            if (versionList != null && versionList.size() > 0) {
                String serverVersion = metadata.get("version");
                if (versionList.contains(serverVersion)) {
                    LOG.info("过滤条件：{}:{}在灰度发布版本列表中，不能被Ribbon负载均衡到，版本号：{}", serviceId, server.toString(), serverVersion);
                    return false;
                }
            }
        }
        
        // IP+PORT 灰度
        Map<String, List<String>> ips = grayInfo.getGrayIps();
        if (ips != null) {
            List<String> ipList = ips.get(serviceId);
            if (ipList != null && ipList.size() > 0) {
                String hostPort = server.getHostPort();
                if (ipList.contains(hostPort)) {
                    LOG.info("过滤条件：{}:{}在灰度发布IP列表中，不能被Ribbon负载均衡到", serviceId, server.toString());
                    return false;
                }
            }
        }
        return true;
    }
}