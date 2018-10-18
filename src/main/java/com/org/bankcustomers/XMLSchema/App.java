package com.org.bankcustomers.XMLSchema;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import trng.imcs.jaxb.Customer;


public class App {

	public static void main(String[] args) {
		//unMarshall();
		marshall();
	}

	static void marshall() {
		try {
			Customer book = unMarshall();
			File file = new File("src\\main\\resources\\xml\\Customer1.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(book, file);
			jaxbMarshaller.marshal(book, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	static Customer unMarshall() {
		try {

			File file = new File("src\\main\\resources\\xml\\Customer.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Customer book = (Customer) jaxbUnmarshaller.unmarshal(file);
			System.out.println(book);
			return book;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
