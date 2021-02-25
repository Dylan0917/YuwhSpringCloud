package org.yuwh.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.yuwh.order.lb.LoadBalancer;
import org.yuwh.springcloud.entities.CommonResult;
import org.yuwh.springcloud.entities.Payment;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

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
    @Autowired
    private LoadBalancer loadBalancer;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create",payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class, id);
    }
    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPaymentById2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        log.info(forEntity.getHeaders().toString());
        if (forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }else {
            return new CommonResult<>(444,"操作失败！");
        }
    }
    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }

        ServiceInstance serviceInstance = loadBalancer.instance(instances);
        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }




}
