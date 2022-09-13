package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	IProductRepository productRepository;

	@Override
	public Integer addProduct(Product product) {
		Product savedProduct = productRepository.save(product);
		return savedProduct.getId();
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getProduct(Integer id) {
		Optional<Product> product = productRepository.findById(id);
//		if(product.isPresent()) {
//			return product.get();
//		}
		return product;
	}

}
