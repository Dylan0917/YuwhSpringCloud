package org.yuwh.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/2/23 14:55
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced//开启负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


}
