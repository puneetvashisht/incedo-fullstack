package com.example.workouttracker.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Workout {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	String title;
	
	String description;
	
	int cbpm;
	
	String videoLocation;
//	List<VideoLocation> videoLocation;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Category category;
	
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCbpm() {
		return cbpm;
	}

	public void setCbpm(int cbpm) {
		this.cbpm = cbpm;
	}
	
	
	

}
