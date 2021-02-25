package org.yuwh.hystrixpayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/2/25 14:38
 */
@SpringBootApplication
@EnableCircuitBreaker //开启断路器
public class HystrixPay8001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixPay8001.class,args);

    }
}
