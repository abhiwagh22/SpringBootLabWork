package com.example.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// Wap to implement OneToMany mapping between customer and product Entity.
@Entity
@Table(name = "CustomerInfo")
public class Customer {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "c_id")
private long id;
private String cName;
@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
private List<Product> product= new ArrayList<>();
public Customer(String cName) {
	super();
	this.cName = cName;
}
public String getcName() {
	return cName;
}
public void setcName(String cName) {
	this.cName = cName;
}
public List<Product> getProduct() {
	return product;
}
public void setProduct(List<Product> product) {
	this.product = product;
}
}