package com.example.demo.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

	private Integer payment_id;
	private Double amount;
	private Date payment_date_time;
	private String transaction_id;
	
}
