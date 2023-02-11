package com.example.workouttracker.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GymUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	int mobileNumber;
	int pin;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	
}
