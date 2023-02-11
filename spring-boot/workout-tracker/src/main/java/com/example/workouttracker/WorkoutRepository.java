package com.example.workouttracker;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.workouttracker.entities.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Integer> {
	
	@Query("SELECT u FROM Workout u WHERE u.cbpm < ?1")
	List<Workout> findWorkoutByCbpm(Integer cbpm);

	List<Workout> findWorkoutByCategory(int category);


}
