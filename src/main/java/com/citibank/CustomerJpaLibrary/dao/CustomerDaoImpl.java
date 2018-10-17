package com.citibank.CustomerJpaLibrary.dao;



import javax.persistence.EntityManager;



import com.citibank.CustomerJpaLibrary.Entity.Customer;
import com.citibank.CustomerJpaLibrary.Utility.JPAUtil;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public Customer loadCustomer(Long id) {
		EntityManager entityManager = getEntityManager();
		try {
			Customer customer = entityManager.find(Customer.class, id);
			return customer;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		EntityManager entityManager = getEntityManager();

		try {
			entityManager.getTransaction().begin();
			entityManager.persist(customer);

			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(customer);
		entityManager.getTransaction().commit();
		return customer;
	}

	@Override
	public boolean deleteCustomer(Long id) {
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			Customer std = entityManager.find(Customer.class, id);
			entityManager.remove(std);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
		return true;
	}

	@Override
	public Customer loadCustomerWithOrders(Long id) {
		
		return null;
	}
	
	private EntityManager getEntityManager() {
		return JPAUtil.getEntityManagerFactory().createEntityManager();
	}

}
