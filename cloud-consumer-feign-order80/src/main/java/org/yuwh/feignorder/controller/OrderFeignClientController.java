package org.yuwh.feignorder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yuwh.feignorder.service.PaymentFeignService;
import org.yuwh.springcloud.entities.CommonResult;
import org.yuwh.springcloud.entities.Payment;

import javax.annotation.Resource;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OrderFeignClientController.java
 * @Description TODO
 * @createTime 2021年02月24日 22:37:00
 */
@RestController
@RequestMapping("/consumer")
public class OrderFeignClientController {
    @Resource
    PaymentFeignService paymentFeignService;

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }
    /**
     * 模拟feign超时
     *There was an unexpected error (type=Internal Server Error, status=500).
     * connect timed out executing GET http://CLOUD-PAYMENT-SERVICE/payment/feign/timeout
     * @return
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        // openfeign-ribbon, 客户端一般默认等待1秒钟
        return paymentFeignService.paymentFeignTimeout();
    }
}
