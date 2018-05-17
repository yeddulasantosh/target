package com.targetrecruiting.rest.service;

import com.targetrecruiting.rest.model.Item;
import com.targetrecruiting.rest.model.ProductPrice;

public interface ServiceManager {

	public Item externalRestCall(String url, String productId);
	public ProductPrice findByProductId(String productId);
	public ProductPrice save(ProductPrice newPrice);
	
}
