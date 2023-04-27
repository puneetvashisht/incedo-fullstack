package com.workout.personalworkouttracker.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Workout {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	String title;
	int cbpm;
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
	public int getCbpm() {
		return cbpm;
	}
	public void setCbpm(int cbpm) {
		this.cbpm = cbpm;
	}
	
	

}
