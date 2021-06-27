package com.app.entity;

import java.io.Serializable;

public class Product implements Serializable {
private int PId;
private String PName;
private float PQty;
private float price;
public int getPId() {
	return PId;
}
public void setPId(int pId) {
	PId = pId;
}
public String getPName() {
	return PName;
}
public void setPName(String pName) {
	PName = pName;
}
public float getPQty() {
	return PQty;
}
public void setPQty(float pQty) {
	PQty = pQty;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
@Override
public String toString() {
	return "Product [PId=" + PId + ", PName=" + PName + ", PQty=" + PQty + ", price=" + price + "]";
}

}
