package com.targetrecruiting.rest.model;

import org.springframework.stereotype.Component;


@Component
public class ProductDetails {
	
	private String id;
	private String name;
	private ProductPrice current_price;
	
	public ProductDetails(){
		
	}
	
	public ProductDetails(String id, String name, ProductPrice currentPrice){
		this.id =id;
		this.name=name;
		current_price = currentPrice;
	}

	public ProductPrice getCurrent_price() {
		return current_price;
	}

	public void setCurrent_price(ProductPrice current_price) {
		this.current_price = current_price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ProductDetails [id=" + id + ", name=" + name + ", current_price=" + current_price + "]";
	}
	
}
