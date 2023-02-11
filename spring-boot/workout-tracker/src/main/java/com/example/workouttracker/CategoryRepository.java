package com.example.workouttracker;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workouttracker.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
