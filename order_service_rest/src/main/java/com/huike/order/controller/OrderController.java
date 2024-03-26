package com.huike.order.controller;

import com.huike.order.entity.Product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
/**
 * @DefaultProperties : 指定此接口中公共的熔断设置
 *      如果过在@DefaultProperties指定了公共的降级方法
 *      在@HystrixCommand不需要单独指定了
 */
//@DefaultProperties(defaultFallback = "defaultFallBack")
public class OrderController {

	@Autowired
	private RestTemplate restTemplate;


	/**
	 * 使用注解配置熔断保护
	 *     fallbackmethod : 配置熔断之后的降级方法
	 */

	@RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
	public Product findById(@PathVariable Long id) {
	/*	if(id != 1) {
			throw  new  RuntimeException("服务器异常");
		}*/
		return restTemplate.getForObject("http://service-product/product/2",Product.class);
	}


}
