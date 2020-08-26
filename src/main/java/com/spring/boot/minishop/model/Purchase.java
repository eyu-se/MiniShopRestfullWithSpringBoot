package com.spring.boot.minishop.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class Purchase {
	
	@NotNull(message = "Product Code is required")
	private String product_code;
	
	@NotNull(message = "Product Code is required")
	private String username;
	
	@NotNull(message = "Product Code is required")
	private String qty;
	
	@NotNull(message = "Product Code is required")
	private Date purchase_date;

	public Purchase(@NotNull(message = "Product Code is required") String product_code,
			@NotNull(message = "Product Code is required") String username,
			@NotNull(message = "Product Code is required") String qty,
			@NotNull(message = "Product Code is required") Date purchase_date) {
		super();
		this.product_code = product_code;
		this.username = username;
		this.qty = qty;
		this.purchase_date = purchase_date;
	}

	public Purchase() {
		super();
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public Date getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}

	@Override
	public String toString() {
		return "Purchase [product_code=" + product_code + ", username=" + username + ", qty=" + qty + ", purchase_date="
				+ purchase_date + "]";
	}
	
	
}
