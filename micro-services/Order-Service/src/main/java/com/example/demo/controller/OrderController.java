package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.TransactionRequest;
import com.example.demo.common.TransactionResponse;
import com.example.demo.service.IOrderService;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
	
	@Autowired
	private IOrderService orderService;
	
	/*
	 * http://localhost:9001/order/PlaceOrder
	 */
	
	@PostMapping(value = "/placeOrder")
	public ResponseEntity<TransactionResponse> placeOrder(@RequestBody TransactionRequest trequest)
	{
		TransactionResponse tresponse=orderService.placeOrder(trequest);
		return new ResponseEntity<TransactionResponse>(tresponse,HttpStatus.CREATED);
	}

}
