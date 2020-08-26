package com.spring.boot.minishop.model;

import javax.validation.constraints.NotNull;


public class ProductQtyUpdate {

	@NotNull(message = "product code is required")
	private String product_code;
	
	private int qty;

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
	
	
	
}
