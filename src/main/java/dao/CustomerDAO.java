package dao;

import model.Customer;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private static final String INSERT_CUSTOMER = "INSERT INTO customers (name, code, school_class, address, birth_date) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_CUSTOMERS = "SELECT * FROM customers";
    private static final String SELECT_CUSTOMER_BY_ID = "SELECT * FROM customers WHERE id = ?";
    private static final String UPDATE_CUSTOMER = "UPDATE customers SET name = ?, code = ?, school_class = ?, address = ?, birth_date = ? WHERE id = ?";
    private static final String DELETE_CUSTOMER = "DELETE FROM customers WHERE id = ?";

    public void insertCustomer(Customer customer) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER)) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getCode());
            preparedStatement.setString(3, customer.getSchoolClass());
            preparedStatement.setString(4, customer.getAddress());
            preparedStatement.setString(5, customer.getBirthDate());
            preparedStatement.executeUpdate();
        }
    }

    public List<Customer> selectAllCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                customers.add(new Customer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("code"),
                        rs.getString("school_class"),
                        rs.getString("address"),
                        rs.getString("birth_date")
                ));
            }
        }
        return customers;
    }

    public Customer selectCustomer(int id) throws SQLException {
        Customer customer = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                customer = new Customer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("code"),
                        rs.getString("school_class"),
                        rs.getString("address"),
                        rs.getString("birth_date")
                );
            }
        }
        return customer;
    }

    public boolean updateCustomer(Customer customer) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER)) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getCode());
            preparedStatement.setString(3, customer.getSchoolClass());
            preparedStatement.setString(4, customer.getAddress());
            preparedStatement.setString(5, customer.getBirthDate());
            preparedStatement.setInt(6, customer.getId());
            return preparedStatement.executeUpdate() > 0;
        }
    }

    public boolean deleteCustomer(int id) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        }
    }
}
