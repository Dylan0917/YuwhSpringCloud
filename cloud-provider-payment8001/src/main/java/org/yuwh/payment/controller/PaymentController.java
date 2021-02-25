package org.yuwh.payment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.yuwh.payment.service.PaymentService;
import org.yuwh.springcloud.entities.CommonResult;
import org.yuwh.springcloud.entities.Payment;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/2/23 12:28
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    PaymentService paymentService;
    @Value("${server.port}")
    private String SERVER_PORT;

    @Resource
    private DiscoveryClient discoveryClient;//服务发现

//    @RequestBody是用来修饰入参的, 表示将请求正文以参数的形式传入到方法中
    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入数据的ID:\t" + payment.getId());
        log.info("插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功,serverport:" + SERVER_PORT, result);
        } else {
            return new CommonResult(444, "插入数据失败", null);
        }
    }
    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("***查询结果：" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询数据成功,serverport:" + SERVER_PORT, payment);
        } else {
            return new CommonResult(444, "没有对应记录", null);
        }
    }

    @GetMapping("/discovery")
    public Object discovery(){
        final List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("****element:"+service);
        }
        final List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }
    @GetMapping("/lb")
    public String getPaymentLB() {
        return SERVER_PORT;
    }

}
