package service;

import dao.CustomerDAO;
import model.Customer;

import java.sql.SQLException;
import java.util.List;

public class CustomerService {
    private CustomerDAO customerDAO;

    public CustomerService() {
        customerDAO = new CustomerDAO();
    }

    public List<Customer> getAllCustomers() throws SQLException {
        return customerDAO.selectAllCustomers();
    }

    public Customer getCustomerById(int id) throws SQLException {
        return customerDAO.selectCustomer(id);
    }

    public void addCustomer(Customer customer) throws SQLException {
        customerDAO.insertCustomer(customer);
    }

    public void updateCustomer(Customer customer) throws SQLException {
        customerDAO.updateCustomer(customer);
    }

    public void deleteCustomer(int id) throws SQLException {
        customerDAO.deleteCustomer(id);
    }
}
