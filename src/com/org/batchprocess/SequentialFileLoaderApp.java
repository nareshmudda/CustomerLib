package com.org.batchprocess;

import java.io.IOException;
import java.sql.SQLException;

import com.org.batchprocess.Util.CustomerInfoLoaderService;

public class SequentialFileLoaderApp {

	public static void main(String[] args) throws IOException, SQLException {
		long startTime = System.nanoTime();
		  CustomerInfoLoaderService R1 = new CustomerInfoLoaderService( "C:\\Users\\nares\\eclipse-workspace\\BatchApplication\\src\\resources\\text1.csv");
	      R1.start();
	      
	      CustomerInfoLoaderService R2 = new CustomerInfoLoaderService( "C:\\Users\\nares\\eclipse-workspace\\BatchApplication\\src\\resources\\text2.csv");
	      R2.start();
	      
	      CustomerInfoLoaderService R3 = new CustomerInfoLoaderService( "C:\\Users\\nares\\eclipse-workspace\\BatchApplication\\src\\resources\\text3.csv");
	      R3.start();
	      
	      CustomerInfoLoaderService R4 = new CustomerInfoLoaderService( "C:\\Users\\nares\\eclipse-workspace\\BatchApplication\\src\\resources\\text4.csv");
	      R4.start();
	      
	      CustomerInfoLoaderService R5 = new CustomerInfoLoaderService( "C:\\Users\\nares\\eclipse-workspace\\BatchApplication\\src\\resources\\text5.csv");
	      R5.start();
	      long endTime = System.nanoTime();
			
			long duration = (endTime - startTime);
			System.out.println("Total time: " + duration);
		
	}
	
	
}
