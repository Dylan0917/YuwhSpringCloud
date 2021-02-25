package org.yuwh.order.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/2/24 18:58
 */
public interface LoadBalancer {
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
