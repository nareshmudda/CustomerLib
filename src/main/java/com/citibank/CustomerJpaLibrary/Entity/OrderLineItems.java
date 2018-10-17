package com.citibank.CustomerJpaLibrary.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "orderlineitems")
@Setter
@Getter
public class OrderLineItems {

	@Id
	private int productNumber;
	private float price;
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "orderNumber", nullable=false)
	private Orders orders;

	public OrderLineItems(int productNumber, float price, int quantity) {
		super();
		this.productNumber = productNumber;
		this.price = price;
		this.quantity = quantity;
	}

	public OrderLineItems() {
		super();
	}
	
}
