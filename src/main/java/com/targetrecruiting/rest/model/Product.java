package com.targetrecruiting.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Product {
	private Item item;
    
	public Product(){
		
	}
	
	public Product(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return item;
	}

	/*public void setItem(Item item) {
		this.item = item;
	}
*/
	@Override
	public String toString() {
		return "Product [item=" + item + "]";
	}
}
