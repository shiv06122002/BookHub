package com.tka.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	@Id
	@Column(name="product_id", nullable=false, unique=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	
	@Column(name="product_name", nullable=false)
	private String productName;
	
	@Column(name="product_price", nullable=false)
	private double productPrice;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private Category category;
	
	
	public Product() {
	}


	public Product(long productId, String productName, double productPrice, Category category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.category = category;
	}


	public long getProductId() {
		return productId;
	}


	public void setProductId(long productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}

}
