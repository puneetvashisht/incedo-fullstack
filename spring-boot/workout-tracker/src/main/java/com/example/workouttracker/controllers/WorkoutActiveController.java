package com.example.workouttracker.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workouttracker.CategoryRepository;
import com.example.workouttracker.WorkoutActiveRepository;
import com.example.workouttracker.WorkoutRepository;
import com.example.workouttracker.entities.Category;
import com.example.workouttracker.entities.Workout;
import com.example.workouttracker.entities.WorkoutActive;

@RestController
@RequestMapping("/api/v1")
public class WorkoutActiveController {
	
	@Autowired
	WorkoutRepository workoutRepository;
	
	@Autowired
	WorkoutActiveRepository workoutActiveRepository;
	
//	List<Employee> employees = new ArrayList<>();
	
	@PostMapping("/workoutactive")
//	Step 1. Get the binary file to server
	public ResponseEntity<Void> addWorkoutActive(@RequestBody WorkoutActive wa) {

		if(wa.getWorkout().getId() > 0 ) {
			Optional<Workout> workoutFound = workoutRepository.findById(wa.getWorkout().getId());
			if(workoutFound.isPresent()) {
				wa.setWorkout(workoutFound.get());
			}
			
		}
		
//		Step 3. set field location to that path 
//		e.setLocation('/uploads/IMG_20181025_110211.jpg')
//		employees.add(e);
		wa.setStartTime(LocalDateTime.now());
		workoutActiveRepository.save(wa);
//		workoutRepository.save(e);
		ResponseEntity<Void> re = new ResponseEntity<>(HttpStatus.CREATED);
		return re;
	}
	
	
	@GetMapping("/workoutactive")
	public List<WorkoutActive> fetchAllActiveWorkouts(){
//		return employees;
		return workoutActiveRepository.findAll();
	}
	
	@PatchMapping("/workoutactive/{id}")
	public ResponseEntity<Void> endWorkoutActive(@PathVariable("id") int id){
//		return employees;
		Optional<WorkoutActive> workoutActiveFound = workoutActiveRepository.findById(id);
		if(workoutActiveFound.isPresent()) {
			WorkoutActive wa = workoutActiveFound.get();
			wa.setEndTime(LocalDateTime.now());
			workoutActiveRepository.save(wa);
		}
		
		ResponseEntity<Void> re = new ResponseEntity<>(HttpStatus.OK);
		return re;
	}

}
