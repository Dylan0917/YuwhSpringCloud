package org.yuwh.consulorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/2/24 11:17
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulOrderApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsulOrderApp.class,args);
    }
}
