package org.yuwh.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author yu.wenhua
 * @desc server端
 * @date 2021/2/23 18:53
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMainApp {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMainApp.class,args);
    }
}
