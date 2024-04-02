package com.huike.order.feign;

import com.huike.order.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductFeignClientCallBack implements ProductFeignClient{
    @Override
    public Product findById(Long id) {
        Product product = new Product();
        product.setProductName("feign调用触发降级方法");
        return product;
    }
}
