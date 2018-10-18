package com.org.bankcustomers.Json;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.jar.JarException;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import trng.imcs.jaxb.Address;
import trng.imcs.jaxb.CARDTYPE;
import trng.imcs.jaxb.Customer;
import trng.imcs.jaxb.PaymentMethods;
 
public class JacksonObjectMapperExample {
 
	private static String FILE_PATH = "C:\\Users\\nares\\eclipse-workspace\\Json\\src\\main\\resources\\customer.json";
	
    public static void main(String[] args) throws IOException {
    	//serialize();
    	deserialize();
    }
    

	@SuppressWarnings("unused")
	private static void serialize() throws JsonGenerationException, JarException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        //convert Object to json string
        Customer customer = createCustomer();
        
        //configure Object mapper for pretty print
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
         
        //writing to console, can write to any output stream such as file
        objectMapper.writeValue(System.out, customer);
        objectMapper.writeValue(new PrintWriter("C:\\Users\\nares\\eclipse-workspace\\Json\\src\\main\\resources\\customer.json"), customer);
	}

	public static void deserialize() throws IOException {
         
        //read json file data to String
        byte[] jsonData = Files.readAllBytes(Paths.get(FILE_PATH));
         
        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
         
        //convert json string to object
        Customer customer = objectMapper.readValue(jsonData, Customer.class);
         
        System.out.println("Employee Object\n"+customer);
    }


	@SuppressWarnings("deprecation")
	private static Customer createCustomer() {
		Customer customer = new Customer();
		customer.setCustomerId(101);
		customer.setName("Krishna");
		customer.setAnualSalary(250f);
		customer.setDataOfBirth(new Date(2014,10,10));
 
        List<Address> addresses = new ArrayList<>();
        Address address = new Address();
        address.setCity("Bangalore");
        address.setCountry("Usa");
        address.setState("TX");
        address.setZipcode(52525);
        addresses.add(address);
        customer.setAddress(addresses);
 
        List<PaymentMethods> paymentMethods = new ArrayList<PaymentMethods>();
        paymentMethods.add(new PaymentMethods("25252","sdsd",new Date(2014,10,10),"Expiry",CARDTYPE.CREDITCARD));
        customer.setPaymentMethods(paymentMethods);
 
       
        return customer;
    }
	
	
	}