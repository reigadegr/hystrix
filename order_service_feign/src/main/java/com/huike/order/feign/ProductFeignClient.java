package com.huike.order.feign;

import com.huike.order.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="service-product")
public interface ProductFeignClient {
    /**
     * 配置需要调用的微服务接口
     */
    @RequestMapping(value="/product/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable("id") Long id);
}
