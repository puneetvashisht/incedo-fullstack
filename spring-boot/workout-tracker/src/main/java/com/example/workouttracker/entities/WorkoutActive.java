package com.example.workouttracker.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class WorkoutActive {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	GymUser gymUser;
	
	@OneToOne(cascade = CascadeType.ALL)
	Workout workout;
	
	LocalDateTime startTime;
	LocalDateTime endTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public GymUser getGymUser() {
		return gymUser;
	}
	public void setGymUser(GymUser gymUser) {
		this.gymUser = gymUser;
	}
	public Workout getWorkout() {
		return workout;
	}
	public void setWorkout(Workout workout) {
		this.workout = workout;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	
	
	
}
