package com.oc.restapi.conversion;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.oc.restapi.dto.ProductDTO;
import com.oc.restapi.entity.Product;

public class Conversion {

	@Autowired
	private ModelMapper modelMapper;
	
	public Conversion() {
		
	}
	
	public ProductDTO convertToDto(Product product) {
	    ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
	    return productDTO;
	}
	
	public Product convertToEntity(ProductDTO productDTO) {
		Product product = modelMapper.map(productDTO, Product.class);
		return product;
	}
}
