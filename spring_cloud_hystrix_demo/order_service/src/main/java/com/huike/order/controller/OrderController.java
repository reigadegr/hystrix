package com.huike.order.controller;

import com.huike.order.command.OrderCommand;
import com.huike.order.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private RestTemplate restTemplate;


//	@RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
//	public Product findById(@PathVariable Long id) {
//		Product product = null;
//		product = restTemplate.getForObject("http://127.0.0.1:9011/product/1",Product.class);
//		return product;
//	}
	/**
	 * 使用OrderCommand调用远程服务
	 */
	@RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
	public Product findById(@PathVariable Long id) {
		return new OrderCommand(restTemplate,id).execute();
	}


	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public String findOrder(@PathVariable Long id) {
		System.out.println(Thread.currentThread().getName());
		return "根据id查询订单";
	}
}
