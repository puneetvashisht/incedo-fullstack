package com.workout.personalworkouttracker.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GymUser {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	public String email;

}
