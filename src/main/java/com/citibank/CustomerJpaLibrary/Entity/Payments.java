package com.citibank.CustomerJpaLibrary.Entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "payments")
@Setter
@Getter
public class Payments extends BaseEntity  {

	@Id
	private String checkNumber;
	private LocalDate paymentDate;
	private float amount;
	
	@OneToOne
	@JoinColumn(name = "customerNumber", nullable=false)
	private Customer customer;
	
	public Payments(String checkNumber, LocalDate paymentDate, float amount) {
		super();
		this.checkNumber = checkNumber;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}
	public Payments() {
		super();
	}
}
