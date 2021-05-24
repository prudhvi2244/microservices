package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.common.Order;
import com.example.demo.common.Payment;
import com.example.demo.common.TransactionRequest;
import com.example.demo.common.TransactionResponse;
import com.example.demo.entity.Cart;

@RestController
@RequestMapping(value = "/flipkart")
public class ShoppingController {

	@Autowired
	private RestTemplate rtemplate;

	private static final String URL = "http://localhost:9001/order/placeOrder";

	/*
	 * http://localhost:8080/flipkart/shop
	 */

	@PostMapping(value = "/shop")
	public ResponseEntity<String> shop(@RequestBody Cart cart) {
		
		TransactionRequest trequest=new TransactionRequest();
		Order order=new Order();
		Payment payment=new Payment();
		order.setOrder_name(cart.getProduct_name());
		order.setAmount(cart.getAmount());
		order.setQuantity(cart.getQuantity());
		trequest.setOrder(order);
		trequest.setPayment(payment);

		TransactionResponse tresponse=rtemplate.postForObject(URL,trequest, TransactionResponse.class);
		String msg = "oooh ,Payment Done ! ,Dear ,Raj,Order With ID "+tresponse.getOrder().getOrder_id()+":Placed Successfully";
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

}
