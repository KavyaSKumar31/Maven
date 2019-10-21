package comm.example.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import comm.example.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {
	private SessionFactory factory = null;
	private Session session;

	{
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
				.buildSessionFactory();
		
	}

	public void deleteCustomer(Customer customer) {
		try {session = factory.openSession();
		session.getTransaction().begin();
		session.remove(customer);
		session.getTransaction().commit();}
		finally {
			session.close();
		}
		
	}
	public void editCustomer(Customer customer) {
		try {session = factory.openSession();
		session.getTransaction().begin();
		session.update(customer);
		session.getTransaction().commit();}
		finally {
			session.close();
		}
		
	}
	public Customer getCustomerById(int id) {
		session = factory.openSession();
		session.getTransaction().begin();
		Customer c= session.get(Customer.class,id);
		return c;
	}
	public void createCustomer(Customer details) {
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			session.persist(details);
			session.getTransaction().commit();
		} finally {
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		session = factory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("from Customer", Customer.class);
		List<Customer> list = query.getResultList();
		session.getTransaction().commit();
		return list;
	}
	public List<Customer> searchCustomer(String search) {
		session = factory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("from Customer c where c.firstName like:name OR c.lastName like :name OR c.email like :name");
		query.setParameter("name", "%"+search+"%");
		List<Customer> list = query.getResultList();
		session.getTransaction().commit();
		return list;
		
	}

}
