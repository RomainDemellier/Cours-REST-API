package com.oc.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oc.restapi.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
