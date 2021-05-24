package com.example.demo.service;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Payment;
@Service
public class PaymentServiceImpl implements IPaymentService{
	
	@Override
	public Payment makePayment(Payment payment) {
		payment.setPayment_id(new Random().nextInt(54444424));
		payment.setTransaction_id(UUID.randomUUID().toString());
		payment.setPayment_date_time(new Date());
		return payment;
	}

}
