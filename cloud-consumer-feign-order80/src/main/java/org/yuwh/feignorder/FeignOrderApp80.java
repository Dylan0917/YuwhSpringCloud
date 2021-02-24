package org.yuwh.feignorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName FeignOrderApp80.java
 * @Description TODO
 * @createTime 2021年02月24日 22:28:00
 */
@SpringBootApplication
@EnableFeignClients
public class FeignOrderApp80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignOrderApp80.class,args);
    }
}
