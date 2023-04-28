package com.workout.personalworkouttracker.entities;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	public Category findByTitle(String title);
}
