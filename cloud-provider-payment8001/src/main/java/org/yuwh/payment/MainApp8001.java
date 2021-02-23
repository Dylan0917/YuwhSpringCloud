package org.yuwh.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/2/23 10:09
 */
@SpringBootApplication
@EnableEurekaClient
public class MainApp8001 {
    public static void main(String[] args) {
        SpringApplication.run(MainApp8001.class,args);
    }
}
