package com.targetrecruiting.rest.service;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.targetrecruiting.rest.model.ProductPrice;

@Repository
public interface ProductRepository extends MongoRepository<ProductPrice,String> {
	
	public boolean existsByProductId(String id);
	
	public ProductPrice findByProductId(String id);
	
}
