package trng.imcs.jaxb;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	private String name;
	private int customerId; 
	private Date dataOfBirth;
	private float anualSalary;
	private List<Address> address;
	private List<PaymentMethods> paymentMethods;
}

