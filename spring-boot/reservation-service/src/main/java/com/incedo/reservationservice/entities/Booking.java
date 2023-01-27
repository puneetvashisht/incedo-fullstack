package com.incedo.reservationservice.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Booking {
	
	@Override
	public String toString() {
		return "Booking [id=" + id + ", source=" + source + ", destination=" + destination + ", quantity=" + quantity
				+ ", totalPrice=" + totalPrice + ", appUser=" + appUser + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	String source;
	String destination;
	int quantity;
	double totalPrice;
	LocalDateTime createdAt;
	
	@ManyToOne(cascade = CascadeType.ALL)
	AppUser appUser;
	
	
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public AppUser getAppUser() {
		return appUser;
	}
	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	

}
