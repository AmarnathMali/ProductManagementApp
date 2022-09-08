package com.pma.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pma.model.Product;
import com.pma.service.ProductService;

@RestController
public class ProductRestController {

	@Autowired
	private ProductService productService;

	@GetMapping("/products/getAllProducts")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/products/getProductsById/{pid}")
	public Product getProductById(@PathVariable int pid) {
		Product product = productService.getProductById(pid);
		if (product == null) {
			throw new ProductNotFoundException("product with pid not found " + pid);
		}
		return productService.getProductById(pid);

	}

	@PostMapping("/products/addProduct")
	public Product insertProduct(@RequestBody Product product) {
		product.setPid(0);
		productService.insertProduct(product);
		return product;

	}

	@PutMapping("/products/updateProduct")
	public Product updateProduct(@RequestBody Product product) {
		productService.insertProduct(product);
		return product;

	}

	@DeleteMapping("/products/deleteProduct/{pid}")
	public String deleteProduct(@PathVariable int pid) {
		productService.deleteProduct(pid);
		return "deleted product Id: " + pid;
	}
}



//	http://localhost:2022/ProductManagementApplication/products/getAllProducts
//	http://localhost:2022/ProductManagementApplication/products/getProductsById/1
//	http://localhost:2022/ProductManagementApplication/products/addProduct
//	http://localhost:2022/ProductManagementApplication/products/updateProduct
//	http://localhost:2022/ProductManagementApplication/products/deleteProduct/1