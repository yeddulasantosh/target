package com.targetrecruiting.rest.service;

import com.targetrecruiting.rest.model.ProductData;

public interface RestClientService {
	public ProductData getProductName(String url, String byId);
}
