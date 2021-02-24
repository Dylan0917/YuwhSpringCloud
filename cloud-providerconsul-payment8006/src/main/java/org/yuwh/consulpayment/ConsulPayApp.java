package org.yuwh.consulpayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/2/24 11:03
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulPayApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsulPayApp.class,args);
    }
}
