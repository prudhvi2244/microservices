package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

	@GetMapping(value = "/paymentFallBack")
	public String handlePaymentFallBack()
	{
		String msg="oops, Payment Service is taking too long time than expected,please try again";
		return msg;
	}
	
	
	@GetMapping(value = "/orderFallBack")
	public String handleOrderFallBack()
	{
		String msg="oops, Order Service taking too long time than expected,please try again";
		return msg;
	}
	
}
