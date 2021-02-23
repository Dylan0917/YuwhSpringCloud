package org.yuwh.payment02.service.impl;

import org.springframework.stereotype.Service;
import org.yuwh.payment02.dao.PaymentDao;
import org.yuwh.payment02.service.PaymentService;
import org.yuwh.springcloud.entities.Payment;

import javax.annotation.Resource;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/2/23 12:00
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
