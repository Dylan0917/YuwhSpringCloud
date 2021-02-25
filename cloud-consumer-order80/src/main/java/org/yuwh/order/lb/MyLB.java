package org.yuwh.order.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/2/24 18:59
 */
@Component
public class MyLB implements LoadBalancer{
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private final int getAndIncrement() {
        int current;
        int next;

        //CAS自旋锁
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!atomicInteger.compareAndSet(current, next));
        System.out.println("第几次访问,次数next:" + next);
        return next;
    }
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
