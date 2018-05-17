package com.targetrecruiting.rest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection="productprice")
@Component
public class ProductPrice {
	
	@Id
	private String id;
	private String productId;
	private String value;
	private String currency_code;
	
	public ProductPrice(){
		
	}
	
	public ProductPrice(String productId,String value, String currencyCode){
		this.productId = productId;
		this.value = value;
		this.currency_code = currencyCode;
	}
	
	@JsonIgnore
	public String getId() {
		return id;
	}
	
	@JsonIgnore
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getCurrency_code() {
		return currency_code;
	}
	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}

	@Override
	public String toString() {
		return "ProductPrice [id=" + id + ", productId=" + productId + ", value=" + value + ", currency_code="
				+ currency_code + "]";
	}
	
}
