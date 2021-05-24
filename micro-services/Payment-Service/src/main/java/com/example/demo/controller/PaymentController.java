package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Payment;
import com.example.demo.service.IPaymentService;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {
	
	@Autowired
	private IPaymentService pservice;
	/*
	 * http://localhost:9002/payment/makePayment
	 */
	@PostMapping(value = "/makePayment")
	public ResponseEntity<Payment> makePayment(@RequestBody Payment payment)
	{
		Payment p=pservice.makePayment(payment);
		return new ResponseEntity<Payment>(p,HttpStatus.CREATED);
	}
	

}
