package com.citibank.CustomerJpaLibrary.dao;

import java.util.List;

import com.citibank.CustomerJpaLibrary.Entity.OrderLineItems;
import com.citibank.CustomerJpaLibrary.Entity.Orders;

public interface OrdersDao {

	Orders loadOrder(Long id);

	Orders saveOrder(Orders orders);

	Orders updateOrder(Orders orders);

	boolean deleteOrder(Long id);
	
	Orders getOrders(Long id);
	
	List<Orders> getFullOrders(Long id);
	
	List<OrderLineItems> getOrderItemList(Long id);
}
