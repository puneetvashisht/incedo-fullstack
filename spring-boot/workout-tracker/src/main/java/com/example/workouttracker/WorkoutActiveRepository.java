package com.example.workouttracker;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.workouttracker.entities.Workout;
import com.example.workouttracker.entities.WorkoutActive;

public interface WorkoutActiveRepository extends JpaRepository<WorkoutActive, Integer> {
	

}
