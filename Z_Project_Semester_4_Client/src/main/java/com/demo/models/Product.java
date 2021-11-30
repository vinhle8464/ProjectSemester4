package com.demo.models;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.annotations.SerializedName;

public class Product {

	@SerializedName("id")
	private int id;
	
	@SerializedName("name")
	private String name;
	
	@SerializedName("price")
	private double price;
	
	@SerializedName("quantity")
	private int quantity;
	
	@SerializedName("status")
	private boolean status;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@SerializedName("created")
	private Date created;
	
	@SerializedName("description")
	private String description;
	
	@SerializedName("categoryId")
	private int categoryId;
	
	@SerializedName("categoryName")
	private String categoryName;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getId() {
		return id;
	}
	public int setId(int id) {
		return this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public Product(int id, String name, double price, int quantity, boolean status, Date created, String description,
			int categoryId, String categoryName) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
		this.created = created;
		this.description = description;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	public Product() {
		super();
	}

	@Override
	public String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", status="
				+ status + ", created=" + simpleDateFormat.format(created) + ", description=" + description + ", categoryId=" + categoryId
				+ ", categoryName=" + categoryName + "]";
	}
	
	
	
	
}
