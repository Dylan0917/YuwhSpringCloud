package org.yuwh.hystrixorder.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yuwh.hystrixorder.service.PaymentHystrixService;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/2/25 15:14
 */
@RestController
@RequestMapping("/consumer")
public class OrderHystrixController {
    @Autowired
    private PaymentHystrixService paymentHystrixService;

    /**
     * 正常访问
     * http://localhost/consumer/payment/hystrix/ok/1
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_OK(id);
    }


//    @HystrixCommand
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
//        int age = 10 / 0;
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }
    private String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "消费者80，对方支付系统繁忙，或自己运行出错请检查自己，请10秒后再试。";
    }
}
