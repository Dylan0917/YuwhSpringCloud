package org.yuwh.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.yuwh.springcloud.entities.CommonResult;
import org.yuwh.springcloud.entities.Payment;

import javax.annotation.Resource;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/2/23 14:46
 */
@RestController
@Slf4j
public class OrderController {
//    private final static String PAYMENT_URL = "http://localhost:8001";//不集群
        private final static String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";//集群
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create",payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class, id);
    }




}
