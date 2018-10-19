package com.org.batchprocess.Util;

import com.org.batchprocess.entity.Customer;

public class CustomerInfoLoaderServiceValidator {
	
	public static boolean validateRecord(Customer customer)
	{
		if(customer.getCustomerCity().equals("florida"))
		{
			return true;
		}
		return false;
	}

}
