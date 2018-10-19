package com.org.batchprocess.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

import com.org.batchprocess.entity.Customer;

public class IntoDb {

	public Customer save(Customer customer) throws SQLException {
		try (Connection connection = createConnection();) {
			String sql = "insert into Customer (CustomerId, CustomerName, CustomerCity,CustomerFileNumber) values (?, ?, ?, ?) ";
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, customer.getCustomerId());
			ps.setString(2, customer.getCustomerName());
			ps.setString(3, customer.getCustomerCity());
			ps.setString(4, customer.getCustomerFileNumber());

			int rowsUpdated = ps.executeUpdate();
			if (rowsUpdated >= 1) {
				try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						customer.setId(generatedKeys.getInt(1));
						System.out.println("Entered Successfully!");
					} else {
						throw new SQLException("Creating user failed, no ID obtained.");
					}
				}
			}
		}
		return customer;
	}

	private Connection createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return null;
		}

		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;

		try {
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/imcs23", "root", "1234");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
		}

		return connection;
	}
}
