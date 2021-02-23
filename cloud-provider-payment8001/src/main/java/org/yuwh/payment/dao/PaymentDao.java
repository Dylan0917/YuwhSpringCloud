package org.yuwh.payment.dao;

import org.apache.ibatis.annotations.Mapper;
import org.yuwh.springcloud.entities.Payment;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/2/23 11:39
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);
    public  Payment getPaymentById(Long id);
}
