package com.cts;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cts.entity.Course;
import com.cts.services.CourseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestCourseService {
	
	@Autowired
	CourseService service;

	@Test
	public void testFetchCourses(){
		List<Course> courses = service.fetchCourses();
		assertEquals("The length should be 1", courses.size(), 1);
	}
}
