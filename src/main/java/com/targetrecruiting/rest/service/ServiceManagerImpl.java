package com.targetrecruiting.rest.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.targetrecruiting.rest.model.Item;
import com.targetrecruiting.rest.model.ProductPrice;

@Component
public class ServiceManagerImpl implements ServiceManager {
	
	private static final Logger log = LogManager.getLogger(ServiceManagerImpl.class);
	
	@Autowired
	private RestClientService client;
	
	@Autowired
	private ProductRepository repository;
	
	public Item externalRestCall(String url, String productId){
		
		return client.getProductName(url, productId).getProduct().getItem();
	}
	
	public ProductPrice findByProductId(String productId) {
		
		return repository.findByProductId(productId);
	}

	public ProductPrice save(ProductPrice newPrice) {
		return repository.save(newPrice);
	}
}
