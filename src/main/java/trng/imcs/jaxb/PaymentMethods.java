package trng.imcs.jaxb;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethods {
	private String cardNumber, cardName; 
	private Date dateFrom;
	private String dateType;
	private CARDTYPE cardType;
}
