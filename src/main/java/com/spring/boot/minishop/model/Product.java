package com.spring.boot.minishop.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class Product {
	
	@NotNull(message = "product code is required ")
	private String code;
	
	@NotNull(message = "product title is required ")
	private String title;
	
	
	private String description;
	
	@NotNull(message = "product category is required ")
	private String category;
	
	@PositiveOrZero(message = "invalid price")
	private double price;
	
	@PositiveOrZero(message = "invalid initial quantity")
	private int init_qty;
	
	@PositiveOrZero(message = "invalid current quantity")
	private int current_qty;
	
	private Date insert_date;

	public Product(@NotNull(message = "product code is required ") String code,
			@NotNull(message = "product title is required ") String title, String description,
			@NotNull(message = "product category is required ") String category,
			@PositiveOrZero(message = "invalid price") double price,
			@PositiveOrZero(message = "invalid initial quantity") int init_qty,
			@PositiveOrZero(message = "invalid current quantity") int current_qty, Date insert_date) {
		super();
		this.code = code;
		this.title = title;
		this.description = description;
		this.category = category;
		this.price = price;
		this.init_qty = init_qty;
		this.current_qty = current_qty;
		this.insert_date = insert_date;
	}

	public Product() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getInit_qty() {
		return init_qty;
	}

	public void setInit_qty(int init_qty) {
		this.init_qty = init_qty;
	}

	public int getCurrent_qty() {
		return current_qty;
	}

	public void setCurrent_qty(int current_qty) {
		this.current_qty = current_qty;
	}

	public Date getInsert_date() {
		return insert_date;
	}

	public void setInsert_date(Date insert_date) {
		this.insert_date = insert_date;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", title=" + title + ", description=" + description + ", category=" + category
				+ ", price=" + price + ", init_qty=" + init_qty + ", current_qty=" + current_qty + ", insert_date="
				+ insert_date + "]";
	}
	
	
}
