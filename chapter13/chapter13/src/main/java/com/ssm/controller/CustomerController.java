package com.ssm.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.po.Customer;
@Controller
public class CustomerController {
	/*
	 * 接收页面请求的JSON数据，并返回JSON格式结果
	 */
	@RequestMapping("/testJson")
	@ResponseBody
	public Customer testJson(@RequestBody Customer customer){
		//打印接收到的JSON格式数据
		System.out.println(customer);
		return customer;
	}
	/*
	 * 接收RESTful风格的请求，其接收方式为GET
	 */
	@RequestMapping(value="/customer/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Customer selectCustomer(@PathVariable("id") Integer id){
		//查看接收数据
		System.out.println(id);
		Customer customer=new Customer();
		//模拟根据id查询出客户对象数据
		if(id==10){
			customer.setLoginname("wujit");
		}
		//返回JSON格式的数据
		return customer;
	}

}
