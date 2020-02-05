package com.oc.restapi.restController;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oc.restapi.conversion.Conversion;
import com.oc.restapi.dto.ProductDTO;
import com.oc.restapi.entity.Product;
import com.oc.restapi.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private Conversion conversion;
	
	@GetMapping("/products")
	public List<ProductDTO> getAllProducts(){
		//return ResponseEntity.ok(productMapper.toProductDTOs(productService.findAll()));
		List<Product> products = productService.findAll();
		//return products.stream().map(this::convertToDto).collect(Collectors.toList());
		return products.stream().map(p -> conversion.convertToDto(p)).collect(Collectors.toList());

	}
	
	@GetMapping("/products/{id}")
	public ProductDTO getProductById(@PathVariable(value = "id") Long productId) {
		return conversion.convertToDto(productService.findById(productId));
	}
	
	@PostMapping("/products")
	public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
		Product product = conversion.convertToEntity(productDTO);
		Product productCreated = productService.createProduct(product);
		
		return conversion.convertToDto(productCreated);
	}
	
	@PutMapping("/products/{id}")
	public ProductDTO updateProduct(@PathVariable(value = "id") Long productId, @RequestBody ProductDTO productDTO) {
		
		Product product = conversion.convertToEntity(productDTO);
		product.setId(productId);
		productService.updateProduct(product);
		
		return conversion.convertToDto(product);
	}
	
	@DeleteMapping("products/{id}")
	public void deleteProduct(@PathVariable(value = "id") Long productId){
		productService.deleteProduct(productId);
	}
}
