package com.cts.entity;

public class Course2 {
	int id;
	String name;
	String description;
	public Course2(){
		
	}
	public Course2(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Course2 [id=" + id + ", name=" + name + ", description=" + description + "]";
	}



}
