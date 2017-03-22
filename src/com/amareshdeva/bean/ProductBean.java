package com.amareshdeva.bean;

import java.util.ArrayList;
import java.util.List;

public class ProductBean {

	private int id;
	private String productname;
	private String discription;
	private int price;
	private int product_warranty;
	private String product_commands;
	private String status;
	private String brandname;
	private int brandId;
	private List<String> prodList = new ArrayList<String>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getProduct_warranty() {
		return product_warranty;
	}
	public void setProduct_warranty(int product_warranty) {
		this.product_warranty = product_warranty;
	}
	public String getProduct_commands() {
		return product_commands;
	}
	public void setProduct_commands(String product_commands) {
		this.product_commands = product_commands;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<String> getProdList() {
		return prodList;
	}
	public void setProdList(List<String> prodList) {
		this.prodList = prodList;
	}
	
	
}
