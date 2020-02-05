package com.oc.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.oc.restapi.entity.Product;
import com.oc.restapi.exception.ResourceNotFoundException;
import com.oc.restapi.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product findById(Long productId) {
		return productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Prduct", "id", productId));
	}
	
	public Product updateProduct(Product product) {
		
		return productRepository.save(product);
	}
	
	public ResponseEntity<?> deleteProduct(Long productId){
		Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
		
		productRepository.delete(product);
		
		return ResponseEntity.ok().build();
	}
}
