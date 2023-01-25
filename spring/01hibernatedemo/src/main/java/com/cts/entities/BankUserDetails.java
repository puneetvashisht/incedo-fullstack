package com.cts.entities;

import javax.persistence.Embeddable;

@Embeddable
public class BankUserDetails {
	
	int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

}
