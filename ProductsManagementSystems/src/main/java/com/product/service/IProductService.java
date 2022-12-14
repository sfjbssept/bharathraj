package com.product.service;

import java.util.List;
import java.util.Optional;

import com.product.entity.Product;

public interface IProductService {
	
	public Integer addProduct(Product product);

	public List<Product> getAllProducts();

	public Optional<Product> getProduct(Integer id);

	public Product updateProduct(Product product, Integer id);

	public void deleteProduct(Integer id);

	public void deleteAllProduct(); 

}
