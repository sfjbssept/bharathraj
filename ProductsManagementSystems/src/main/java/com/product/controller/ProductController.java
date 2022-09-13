package com.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.service.IProductService;

@RestController
public class ProductController<T> {

	@Autowired
	IProductService productService;
	
	@PostMapping("/addproduct")
	public Integer saveProduct(@RequestBody Product product) {
		Integer id = productService.addProduct(product);
		System.out.println(id);
		return id;
	}
	
	@GetMapping("/getProducts")
	public List<Product> getAllProducts() {
		List<Product> productList = productService.getAllProducts();
		return productList;
	}
	
	@GetMapping("/product/{id}")
	public Optional<Product> getProduct( @PathVariable Integer id) {
		Optional<Product> product = productService.getProduct(id);
		System.out.println(id);
		return product;
	}
	
	@PostMapping("/updateProduct/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Integer id) {
//		Product updateProduct = productService.updateProduct(product, id);
		System.out.println(id);
		return new ResponseEntity<Product>(productService.updateProduct(product, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable Integer id) {
		ResponseEntity<Product> response = new ResponseEntity<>(HttpStatus.OK);
		try {
			productService.deleteProduct(id);
		} catch(Exception ex) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return response;
	}
}
