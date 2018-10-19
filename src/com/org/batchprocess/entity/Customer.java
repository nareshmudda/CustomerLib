package com.org.batchprocess.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class Customer {

	private int Id;
	private int customerId;
	private String customerName;
	private String customerCity;
	private String customerFileNumber;
	public Customer(int customerId, String customerName, String customerCity, String customerFileNumber) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerCity = customerCity;
		this.customerFileNumber = customerFileNumber;
	}
	
	
}
