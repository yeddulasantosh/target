package com.targetrecruiting.rest.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.targetrecruiting.rest.model.ProductData;

@Service
public class RestClientServiceImpl implements RestClientService {
	private static final Logger log = LogManager.getLogger(RestClientServiceImpl.class);
	private final RestTemplate restTemplate;

	public RestClientServiceImpl(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}

	public ProductData getProductName(String url, String byId) {
		log.debug("getProductName : Received productId- "+byId);
		//String url = "https://redsky.target.com/v2/pdp/tcin/{id}?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics,deep_red_labels";
		Map<String, String> uriParams = new HashMap<String, String>();
		uriParams.put("id", byId);
		ResponseEntity<ProductData> response = this.restTemplate.exchange(url, HttpMethod.GET, null, ProductData.class,
				uriParams);
		log.debug("getProductName : status code "+response.getStatusCode());
		ProductData dt = response.getBody();
		log.debug("getProductName : Product data from response - "+dt.toString());
		return dt;
	}

}
