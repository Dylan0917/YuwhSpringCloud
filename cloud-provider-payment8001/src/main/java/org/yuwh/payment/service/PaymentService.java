package org.yuwh.payment.service;


import org.yuwh.springcloud.entities.Payment;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/2/23 11:59
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
