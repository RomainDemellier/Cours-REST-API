package com.oc.restapi.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.oc.restapi.conversion.Conversion;

@Configuration
public class ApplicationConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}
	
	@Bean
	public Conversion conversion() {
		Conversion conversion = new Conversion();
		return conversion;
	}
}
