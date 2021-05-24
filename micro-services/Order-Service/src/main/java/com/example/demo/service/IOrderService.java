package com.example.demo.service;

import com.example.demo.common.TransactionRequest;
import com.example.demo.common.TransactionResponse;

public interface IOrderService {

	public TransactionResponse placeOrder(TransactionRequest trequest);
	
}
