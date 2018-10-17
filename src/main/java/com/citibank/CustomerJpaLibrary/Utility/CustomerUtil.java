package com.citibank.CustomerJpaLibrary.Utility;

import com.citibank.CustomerJpaLibrary.App.CustomerApp;
import com.citibank.CustomerJpaLibrary.Entity.Customer;
public class CustomerUtil {

public static Customer readCustomer() {
		
		System.out.println("Enter Customer Name");
		String customerName = CustomerApp.in.next();
		
		System.out.println("Enter Contact Last Name");
		String contactLastName = CustomerApp.in.next();
		
		System.out.println("Enter Contact First Name");
		String contactFirstName = CustomerApp.in.next();

		System.out.println("Enter Customer Phone Number");
		String employeePhone = CustomerApp.in.next();
		
		System.out.println("Enter Address Line 1");
		String addressLine1 = CustomerApp.in.next();
		
		System.out.println("Enter Address Line 2");
		String addressLine2 = CustomerApp.in.next();
		
		System.out.println("Enter City");
		String city = CustomerApp.in.next();

		System.out.println("Enter State");
		String state = CustomerApp.in.next();
		
		System.out.println("Enter PostalCode");
		String postalCode = CustomerApp.in.next();

		System.out.println("Enter Country");
		String country = CustomerApp.in.next();
		
		System.out.println("Enter Sales Rep Employee Number");
		int salesRepNum = CustomerApp.in.nextInt();
		
		System.out.println("Enter Credit Limit Amount");
		float creditLimit = CustomerApp.in.nextFloat();
		
		return new Customer(customerName,contactLastName,contactFirstName,employeePhone,addressLine1,addressLine2,city,state,postalCode,country,salesRepNum,creditLimit);
		
		
	}
}
