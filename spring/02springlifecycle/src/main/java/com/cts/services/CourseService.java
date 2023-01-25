package com.cts.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.entity.Course;

@Service
public class CourseService {
	
	
	MyDataSource myDataSource;
	
	public MyDataSource getMyDataSource() {
		return myDataSource;
	}
	

	@Autowired
	public void setMyDataSource(MyDataSource myDataSource) {
		System.out.println("setter...");
		this.myDataSource = myDataSource;
	}


	CourseService(){
		System.out.println("constructor...");
	}
	
	@PostConstruct
	public void initialize(){
		System.out.println("Initialization code");
	}
	
	
	List<Course> courses = new ArrayList<>();
	
	
	public List<Course> fetchCourses(){
		System.out.println(myDataSource);
		Course course1 = new Course(23, "Angular", "framework by google");
		courses.add(course1);
		return this.courses;
	}
	

}
