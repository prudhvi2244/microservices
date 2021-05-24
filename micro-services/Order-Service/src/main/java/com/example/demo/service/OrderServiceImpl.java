package com.example.demo.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.common.Payment;
import com.example.demo.common.TransactionRequest;
import com.example.demo.common.TransactionResponse;
import com.example.demo.entity.Order;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private RestTemplate rtemplate;

	private static final String URL = "http://localhost:9999/payment/makePayment";

	@Override
	public TransactionResponse placeOrder(TransactionRequest trequest) {
		Order order = trequest.getOrder();
		order.setOrder_id(new Random().nextInt(2552525));
		order.setAmount(order.getQuantity()*order.getAmount());
		
		Payment payment = trequest.getPayment();
		payment.setAmount(order.getAmount());
		
		Payment paymentResponse = rtemplate.postForObject(URL, payment, Payment.class);

		return new TransactionResponse(order, paymentResponse);
	}
}
