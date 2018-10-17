package com.citibank.CustomerJpaLibrary.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.citibank.CustomerJpaLibrary.Entity.OrderLineItems;
import com.citibank.CustomerJpaLibrary.Entity.Orders;
import com.citibank.CustomerJpaLibrary.Utility.JPAUtil;

public class OrdersDaoImpl implements OrdersDao {

	@Override
	public Orders loadOrder(Long id) {
		EntityManager entityManager = getEntityManager();
		try {
			Orders orders = entityManager.find(Orders.class, id);
			return orders;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Orders saveOrder(Orders orders) {
		EntityManager entityManager = getEntityManager();

		try {
			entityManager.getTransaction().begin();
			entityManager.persist(orders);

			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
		return orders;
	}

	@Override
	public Orders updateOrder(Orders orders) {
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(orders);
		entityManager.getTransaction().commit();
		return orders;
	}

	@Override
	public boolean deleteOrder(Long id) {
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			Orders std = entityManager.find(Orders.class, id);
			entityManager.remove(std);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
		return true;
	}
	
	private EntityManager getEntityManager() {
		return JPAUtil.getEntityManagerFactory().createEntityManager();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> getFullOrders(Long id) {
		Query query = getEntityManager().createQuery("from Orders where customerNumber = "+id);
		if (query.getResultList().size() > 0) {
			//return (Orders) query.getSingleResult();
			return query.getResultList();
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderLineItems> getOrderItemList(Long id) {
		Query query = getEntityManager().createQuery("from OrderLineItems where orderNumber = "+id);
		return query.getResultList();
	}

	@Override
	public Orders getOrders(Long id) {
		Query query = getEntityManager().createQuery("from Orders where customerNumber = "+id);
		if (query.getResultList().size() > 0) {
			return (Orders) query.getSingleResult();
	}
		else {
			return null;
		}

}
}
