package com.org.batchprocess.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.org.batchprocess.Impl.IntoDb;
import com.org.batchprocess.entity.Customer;

public class CustomerInfoLoaderService extends Thread implements Runnable {
	   private String filename;
	   private Thread t;
	   public CustomerInfoLoaderService(String name) {
	      filename = name;
	      System.out.println("Creating " +  filename );
	   }
	static List<Customer> validFilerecords = new ArrayList<>();
	static List<Customer> inValidFilerecords = new ArrayList<>();

	public void readValidateData(String file) throws NumberFormatException, ParseException {
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
        String contentLine = br.readLine();
        while (contentLine != null) {
        	Customer customer = parsePropertyData(contentLine);
        	
        	if(CustomerInfoLoaderServiceValidator.validateRecord(customer))
        	{
        		
				validFilerecords.add(customer);
        	}
        	else
        	{
        		inValidFilerecords.add(customer);
        	}
        	contentLine = br.readLine();
        }
    }
	    catch(IOException e) {
	 	   System.out.println(e);
	    }
	}

	private Customer parsePropertyData(String contentLine) {
		String[] arrOfStr = contentLine.split(",");
		return new Customer(Integer.parseInt(arrOfStr[0]),arrOfStr[1],arrOfStr[2],arrOfStr[3]);
	}
	
	public static void SaveRecordsToDb() throws IOException, SQLException {
		
		IntoDb intoDb = new IntoDb();
			for(Customer customer : validFilerecords) {
				intoDb.save(customer);
			}
		}
	
	
	public static void SendEmail() {
					System.out.println("Email Sent");
	}
	
	public void start () {
	      System.out.println("Starting " +  filename );
	      if (t == null) {
	         t = new Thread (this, filename);
	         t.start ();
	      }
	}

	@Override
	public void run() {
		
		try {
			sleep(1000 * 1);
			readValidateData(filename);
			SaveRecordsToDb();
			SendEmail();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
