package com.cts.entity;


import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class BankUserDetails implements Serializable{

	private static final long serialVersionUID = 6267294124912785031L;
	int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

}

