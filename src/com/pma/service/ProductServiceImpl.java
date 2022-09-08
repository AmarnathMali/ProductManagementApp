package com.pma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pma.dao.ProductDao;
import com.pma.model.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;

	@Override
	@Transactional
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDao.getAllProducts();
	}

	@Override
	@Transactional
	public Product getProductById(int pid) {
		// TODO Auto-generated method stub
		return productDao.getProductById(pid);
	}

	@Override
	@Transactional
	public void insertProduct(Product Product) {
		// TODO Auto-generated method stub
		productDao.insertProduct(Product);
	}

	@Override
	@Transactional
	public void deleteProduct(int pid) {
		// TODO Auto-generated method stub
		productDao.deleteProduct(pid);
	}
	
	
	
}
