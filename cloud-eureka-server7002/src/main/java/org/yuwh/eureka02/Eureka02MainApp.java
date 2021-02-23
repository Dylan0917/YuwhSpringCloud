package org.yuwh.eureka02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/2/23 19:32
 */
@SpringBootApplication
@EnableEurekaServer
public class Eureka02MainApp {
    public static void main(String[] args) {
    SpringApplication.run(Eureka02MainApp.class,args);
}

}
