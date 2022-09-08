package com.pma.dao;

import java.util.List;

import com.pma.model.Product;

public interface ProductDao {

	public List<Product> getAllProducts();

	public Product getProductById(int pid);

	public void insertProduct(Product Product);

	public void deleteProduct(int pid);

}
