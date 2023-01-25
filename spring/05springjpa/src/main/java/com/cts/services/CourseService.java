package com.cts.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.entity.Course;

@Service
public class CourseService {
	


	CourseService(){
		System.out.println("constructor...");
	}
	
	@PostConstruct
	public void initialize(){
		System.out.println("Initialization code");
	}
	
	
	List<Course> courses = new ArrayList<>();
	
	
	public List<Course> fetchCourses(){
//		System.out.println(myDataSource);
		Course course1 = new Course(23, "Angular", "framework by google");
		courses.add(course1);
		return this.courses;
	}
	
	public Course fetchCourseById(int id) throws Exception{
		//Logging Code
//		System.out.println("Course Id recieved is " + id);
		
		// Business Logic Code
		if(id==234){
			throw new Exception("Something went wrong");
		}
		Course course1 = new Course(id, "Angular", "framework by google");
		return course1;
	}
	
	public Course fetchCourseByName(String name){

		// Business Logic Code
		Course course1 = new Course(23, name, "framework by google");
		return course1;
	}
	

}
