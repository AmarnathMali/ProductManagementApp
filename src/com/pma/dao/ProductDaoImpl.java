package com.pma.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pma.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> getAllProducts() {

		Session currentSession = sessionFactory.getCurrentSession();
		Query<Product> query = currentSession.createQuery("from Product order by pname", Product.class);
		List<Product> listOfProducts = query.getResultList();
		return listOfProducts;
	}

	@Override
	public Product getProductById(int pid) {
		Session currentSession = sessionFactory.getCurrentSession();
		Product product = currentSession.get(Product.class, pid);
		return product;
	}

	@Override
	public void insertProduct(Product Product) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(Product);
	}

	@Override
	public void deleteProduct(int pid) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Product where id=:pid");
		theQuery.setParameter("pid", pid);		
		theQuery.executeUpdate();	

	

	}

}
