package org.yuwh.feignorder.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
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
}
