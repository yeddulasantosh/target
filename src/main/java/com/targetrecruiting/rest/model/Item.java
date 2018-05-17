package com.targetrecruiting.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
	private String tcin;
	@JsonProperty(value = "product_description")
	private ProductDescription product_description;

	public Item() {

	}

	public Item(String tcin, ProductDescription description) {
		this.tcin = tcin;
		product_description = description;
	}

	public String getTcin() {
		return tcin;
	}

	public void setTcin(String tcin) {
		this.tcin = tcin;
	}

	public ProductDescription getDescription() {
		return product_description;
	}

	public void setDescription(ProductDescription description) {
		this.product_description = description;
	}

	@Override
	public String toString() {
		return "Item [tcin=" + tcin + ", description=" + product_description + "]";
	}
}
