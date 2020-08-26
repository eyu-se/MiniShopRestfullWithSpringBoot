package com.spring.boot.minishop.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class User {

	@NotNull(message = "username is required")
	private String username;
	
	@NotNull(message = "username is required")
	private String full_name;
	
	@NotNull(message = "username is required")
	private String address;
	
	@PositiveOrZero(message = "invalid balance")
	private double balance;
	
	private Date reg_date;

	public User(@NotNull(message = "username is required") String username,
			@NotNull(message = "username is required") String full_name,
			@NotNull(message = "username is required") String address,
			@PositiveOrZero(message = "invalid balance") double balance, Date reg_date) {
		super();
		this.username = username;
		this.full_name = full_name;
		this.address = address;
		this.balance = balance;
		this.reg_date = reg_date;
	}

	public User() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", full_name=" + full_name + ", address=" + address + ", balance="
				+ balance + ", reg_date=" + reg_date + "]";
	}
	
	
}
