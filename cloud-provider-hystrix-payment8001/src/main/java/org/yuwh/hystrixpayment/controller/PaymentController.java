package org.yuwh.hystrixpayment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yuwh.hystrixpayment.service.PaymentService;

import javax.annotation.Resource;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/2/25 14:45
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String SERVER_PORT;

    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    @GetMapping("/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        final String result = paymentService.paymentInfo_OK(id);
        log.info("***result:" + result);
        return result;
    }

    /**
     * 非正常访问
     *
     * @param id
     * @return
     */
    @GetMapping("/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        final String result = paymentService.paymentInfo_TimeOut(id);
        log.info("***result:" + result);
        return result;
    }

}
