package comm.example.dao;

import java.util.List;

import comm.example.model.Customer;

public interface CustomerDAO {
	
	public List<Customer> getAllCustomer();
	public void createCustomer(Customer details);
	public void deleteCustomer(Customer customer);
	public Customer getCustomerById(int id);
	public void editCustomer(Customer customer);
	public List<Customer> searchCustomer(String search);
}
