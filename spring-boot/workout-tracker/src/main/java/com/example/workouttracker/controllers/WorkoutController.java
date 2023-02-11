package com.example.workouttracker.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workouttracker.CategoryRepository;
import com.example.workouttracker.WorkoutRepository;
import com.example.workouttracker.entities.Category;
import com.example.workouttracker.entities.Workout;

@RestController
@RequestMapping("/api/v1")
public class WorkoutController {
	
	@Autowired
	WorkoutRepository workoutRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
//	List<Employee> employees = new ArrayList<>();
	
	@PostMapping("/workouts")
//	Step 1. Get the binary file to server
	public ResponseEntity<Void> addWorkout(@RequestBody Workout e) {
		System.out.println(e);
		
//		Step 2. Mv the file to some pre-decided location (/uploads/IMG_20181025_110211.jpg)
		if(e.getCategory().getId() > 0 ) {
			Optional<Category> categoryFound = categoryRepository.findById(e.getCategory().getId());
			if(categoryFound.isPresent()) {
				e.setCategory(categoryFound.get());
			}
			
		}
//		Step 3. set field location to that path 
//		e.setLocation('/uploads/IMG_20181025_110211.jpg')
//		employees.add(e);
		workoutRepository.save(e);
		ResponseEntity<Void> re = new ResponseEntity<>(HttpStatus.CREATED);
		return re;
	}
	
	@GetMapping("/workouts/cbpmlessthan/{calories}")
	public List<Workout> fetchAllEmployeesWithCbpm(@PathVariable("calories") int calories){
//		return employees;
		return workoutRepository.findWorkoutByCbpm(calories);
	}
	
	@GetMapping("/workouts")
	public List<Workout> fetchAllEmployees(){
//		return employees;
		return workoutRepository.findAll();
	}

}
