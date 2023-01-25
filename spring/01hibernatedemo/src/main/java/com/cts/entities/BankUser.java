package com.cts.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BankUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7368627523992772496L;

	@Id
	CompositeKey id;
	
	String username;
	
	double balance;
	
	BankUserDetails bankUserDetails;
	
	

	public BankUserDetails getBankUserDetails() {
		return bankUserDetails;
	}

	public void setBankUserDetails(BankUserDetails bankUserDetails) {
		this.bankUserDetails = bankUserDetails;
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public CompositeKey getId() {
		return id;
	}

	public void setId(CompositeKey id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "BankUser [id=" + id + ", username=" + username + ", balance=" + balance + ", bankUserDetails="
				+ bankUserDetails + "]";
	}

	
	
	
	
	
}
