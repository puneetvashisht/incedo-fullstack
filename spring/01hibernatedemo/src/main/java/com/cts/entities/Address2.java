package com.cts.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address2 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	String location;
	
	@Column(name ="MY_CITY")
	String city;
	
	public Address2(){}

	public Address2(String location, String city) {
		super();
		this.location = location;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", location=" + location + ", city=" + city + "]";
	}

	
	
}
