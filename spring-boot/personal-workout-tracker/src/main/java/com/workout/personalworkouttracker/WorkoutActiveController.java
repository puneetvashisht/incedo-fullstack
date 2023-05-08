package com.workout.personalworkouttracker;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workout.personalworkouttracker.entities.Workout;
import com.workout.personalworkouttracker.entities.WorkoutActive;
import com.workout.personalworkouttracker.entities.WorkoutActiveRepository;
import com.workout.personalworkouttracker.entities.WorkoutRepository;

@RestController
@CrossOrigin
@RequestMapping("/workoutactive")
public class WorkoutActiveController {
	
	@Autowired
	WorkoutActiveRepository workoutActiveRepository;
	
	@Autowired
	WorkoutRepository workoutRepository;
	
	@PostMapping("/")
	public ResponseEntity<Void> add(@RequestBody WorkoutActive workoutActive) {
		
		// If workout already exists, use the same
		Optional<Workout> workoutFound = workoutRepository.findById(workoutActive.getWorkout().getId());
		
		workoutActive.setStartTime(LocalTime.now());
		
		if(workoutFound.isPresent()) {
			workoutActive.setWorkout(workoutFound.get());
		}
		
		workoutActiveRepository.save(workoutActive);
		ResponseEntity re = new ResponseEntity<>(HttpStatus.CREATED);
		return re;
	}
	
	@PatchMapping("/end/{id}")
	public void endWorkout(@PathVariable("id") int id){
		// If workout already exists, use the same
				Optional<WorkoutActive> workoutActiveFound = workoutActiveRepository.findById(id);
//		WorkoutActive workoutActiveFound = workoutActiveRepository.findByWorkoutId(id);
				
				if(workoutActiveFound.isPresent()) {
					WorkoutActive workoutActive = workoutActiveFound.get();
					workoutActive.setEndTime(LocalTime.now());
					workoutActiveRepository.save(workoutActive);	
				}				
	}
	
	@GetMapping("/")
	public List<WorkoutActive> fetchAll() {	
		return workoutActiveRepository.findAll();
		
	}

}
