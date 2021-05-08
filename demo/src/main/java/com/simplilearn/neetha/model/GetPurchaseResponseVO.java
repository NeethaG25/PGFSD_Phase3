package com.simplilearn.neetha.model;

import java.util.Date;

public class GetPurchaseResponseVO {
	
	private Integer id;
	private String userId;
	private Integer productId;
	private Integer quantity;
	private Double amount;
	private Date purchaseDate;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	@Override
	public String toString() {
		return "MakePurchaseRequestVO [id=" + id + ", userId=" + userId + ", productId=" + productId + ", quantity="
				+ quantity + ", amount=" + amount + "]";
	}

}
