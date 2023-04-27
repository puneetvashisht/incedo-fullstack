package com.workout.personalworkouttracker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workout.personalworkouttracker.entities.Workout;
import com.workout.personalworkouttracker.entities.WorkoutRepository;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {
	
	@Autowired
	WorkoutRepository workoutRepository;
	
	@PostMapping("/")
	public ResponseEntity<Void> add(@RequestBody Workout workout) {
		workoutRepository.save(workout);
		ResponseEntity re = new ResponseEntity<>(HttpStatus.CREATED);
		return re;
	}
	
	@GetMapping("/")
	public List<Workout> fetchAllWorkouts(){
		return workoutRepository.findAll();
	}
	
	@PatchMapping("/")
	public void updateWorkout(@RequestBody Workout workout){
		 Workout workoutFound = workoutRepository.getById(workout.getId());
		 workoutFound.setCbpm(workout.getCbpm());
		 workoutRepository.save(workoutFound);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteWorkout(@PathVariable("id") int id){
//		return workoutRepository.findAll();
		ResponseEntity re = new ResponseEntity<>(HttpStatus.OK);
		try {
			workoutRepository.deleteById(id);
		}
		catch(Exception e) {
			re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return re;
	}

}
