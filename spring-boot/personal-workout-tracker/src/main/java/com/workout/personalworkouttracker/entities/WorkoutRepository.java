package com.workout.personalworkouttracker.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WorkoutRepository extends JpaRepository<Workout, Integer>{
	
	public Workout findByTitle(String title);
	public List<Workout> findByCbpmGreaterThan(int cbpm);
	
	@Query("select SUM(w.cbpm) from Workout w")
	public Integer findSumofCalories();

}
