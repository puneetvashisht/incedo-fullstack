package com.workout.personalworkouttracker.entities;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutActiveRepository extends JpaRepository<WorkoutActive, Integer>{

	WorkoutActive findByWorkoutId(int id);

}
