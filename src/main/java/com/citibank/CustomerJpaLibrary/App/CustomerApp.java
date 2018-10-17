package com.citibank.CustomerJpaLibrary.App;

import java.util.List;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import com.citibank.CustomerJpaLibrary.Entity.Customer;
import com.citibank.CustomerJpaLibrary.Entity.OrderLineItems;
import com.citibank.CustomerJpaLibrary.Entity.Orders;
import com.citibank.CustomerJpaLibrary.dao.CustomerDao;
import com.citibank.CustomerJpaLibrary.dao.CustomerDaoImpl;
import com.citibank.CustomerJpaLibrary.dao.OrdersDao;
import com.citibank.CustomerJpaLibrary.dao.OrdersDaoImpl;

public class CustomerApp {

	CustomerDao customerDao = new CustomerDaoImpl();
	OrdersDao ordersDao = new OrdersDaoImpl();
	public static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		CustomerApp app = new CustomerApp();
		OperationEnum operation = null;
		
		do {
			operation = app.readUserSelection();
			app.processUserOperation(operation);
			
		} while (operation != OperationEnum.UNKNOWN);
	}
	
	private void processUserOperation(OperationEnum operation) {
		switch (operation) {
		case ADDCUSTOMER:
			saveCustomer();
			break;

		case DELETECUSTOMER:
			deleteCustomer();
			break;

		case UPDATECUSTOMER:
			updateCustomer();
			break;
			
		case DISPLAYCUSTOMER:
			displayCustomer();
			break;
			
		case ADDORDERS:
			addOrders();
			break;
			
		case DELETEORDERS:
			deleteOrders();
			break;
			
		case UPDATEORDERS:
			updateOrders();
			break;
			
		case VIEWORDERS:
			getOrders();
			break;
			
		default:
			System.out.println("Invalid Operation");
		}
	}
	
	
	private void getOrders() {
		System.out.println("Enter the Customer Number to Update:");
		int customerNumber = in.nextInt();
		List<Orders> order = ordersDao.getFullOrders((long) customerNumber);
		for(int i=0;i<order.size();i++) {
			System.out.print(order.get(i).getOrderNumber()+"\t");
			System.out.print(order.get(i).getStatus()+"\t");
			System.out.println(order.get(i).getComments());
		}
		getOrderListByOrderNumber();
	}

	private void getOrderListByOrderNumber() {
		System.out.println("Enter the Order Number to Update:");
		int customerNumber = in.nextInt();
		List<OrderLineItems> order1 = ordersDao.getOrderItemList((long) customerNumber);
		for(int i=0;i<order1.size();i++) {
			System.out.print(order1.get(i).getProductNumber()+"\t");
			System.out.print(order1.get(i).getQuantity()+"\t");
			System.out.println(order1.get(i).getPrice());
		}
	}
	
	private void updateOrders() {
		System.out.println("Enter the Customer Number to Update:");
		int customerNumber = in.nextInt();
		Orders order1 = ordersDao.getOrders((long) customerNumber);
		if(order1.getVersion()!=null) {
			order1.setStatus("In Progress");
			ordersDao.updateOrder(order1);
			}
			else {
				System.out.println("Order Number doesnot exist in the database!");
			}
		}
	
	private void deleteOrders() {
		System.out.println("Enter Customer Number:");
		int option = in.nextInt();
		Orders order1 = ordersDao.getOrders((long) option);
		ordersDao.deleteOrder(order1.getOrderNumber());
	}

	private void addOrders() {
		System.out.println("Enter the Customer Number:");
		int customerNumber = in.nextInt();
		Customer customer = customerDao.loadCustomer((long) customerNumber);
		Orders orders1 = new Orders(LocalDate.now(),LocalDate.now(),LocalDate.now(),"shipped","Comments");
		orders1.setCustomer(customer);
		Set<Orders> orderDetails = new HashSet<>();
		orderDetails.add(orders1);
		customer.setOrders(orderDetails);
		OrderLineItems orderLineItems1 = new OrderLineItems(101,15f,3);
		OrderLineItems orderLineItems2 = new OrderLineItems(102,25f,3);
		OrderLineItems orderLineItems3 = new OrderLineItems(103,35f,3);
		orderLineItems1.setOrders(orders1);
		orderLineItems2.setOrders(orders1);
		orderLineItems3.setOrders(orders1);
		Set<OrderLineItems> orderLineItems = new HashSet<>();
		orderLineItems.add(orderLineItems1);
		orderLineItems.add(orderLineItems2);
		orderLineItems.add(orderLineItems3);
		orders1.setOrderLineItems(orderLineItems);
		
		ordersDao.saveOrder(orders1);
	}

	private void saveCustomer() {
		//Customer customerInstance = CustomerUtil.readCustomer();
		Customer customerInstance = new Customer(null, "Naresh", "pinal", "Dev", "345-564-3345", "8825 PebbleCreek", "North Plaza", "Austin","Texas","78753","USA",1,500f);
		customerDao.saveCustomer(customerInstance);
	}
	
	private void deleteCustomer() {
		int option = in.nextInt();
		customerDao.deleteCustomer((long) option);
	}
	
	private void updateCustomer() {
		//Customer customerInstance = CustomerUtil.readCustomer();
		//Customer customerInstance = new Customer(null, "Krishna", "pinal", "Dev", "345-564-3345", "8825 PebbleCreek", "North Plaza", "Austin","Texas","78753","USA",1,500f);
		System.out.println("Enter the Customer Number to Update:");
		int option = in.nextInt();
		Customer customerInstance = customerDao.loadCustomer((long) option);
		customerInstance.setCustomerName("Krishna");
		System.out.println();
		if(customerInstance.getVersion()!=null) {
		customerDao.updateCustomer(customerInstance);}
		else {
			System.out.println("Customer doesnot exist in the database!");
		}
	}
	
	private void displayCustomer() {
		System.out.println("Enter Customer Number to display");
		int option = in.nextInt();
		Customer customer = customerDao.loadCustomer((long) option);
		System.out.println(customer.toString());
	}
	
	private OperationEnum readUserSelection() {
		System.out.println("1. Add Customer \n 2. Display Customer \n 3. Update Customer \n 4. Delete Customer \n 5. Add Orders \n 6. View Orders \n 7. Update Orders \n 8. Delete Orders \n 9. Payments \n 10. Exit");
		int option = in.nextInt();
		if(option == 10)
			in.close();
		return OperationEnum.getMatchingOperation(option);
	}
}
