package com.cts.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class CompositeKey implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2312587424104536736L;

	
	int bankId;

	int userId;
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "CompositeKey [bankId=" + bankId + ", userId=" + userId + "]";
	}
	
	
}
