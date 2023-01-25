package com.cts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cts.entity.Course;
import com.cts.services.CourseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestCourseRepo {
	
	@Autowired
	CourseService service;

//	@Test
//	public void testFetchCourses(){
//		List<Course> courses = service.fetchCourses();
//		assertEquals("The length should be 1", courses.size(), 1);
//	}
	
	@Test
	public void testFetchCourseById(){
		Course course= null;
		try {
			course = service.fetchCourseById(234);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		Course course2 = service.fetchCourseByName("React");
		List<Course> courses = service.fetchCourses();
//		assertEquals("The length should be 1", course.getId(), 234);
	}
}
