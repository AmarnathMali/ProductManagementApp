package com.pma.service;

import java.util.List;

import com.pma.model.Product;

public interface ProductService {

	public List<Product> getAllProducts();

	public Product getProductById(int pid);

	public void insertProduct(Product Product);

	public void deleteProduct(int pid);

}
