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
import com.cts.repository.CourseRepository;
import com.cts.services.CourseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestCourseService {
	
	@Autowired
	CourseRepository repo;


//	@Test
	public void testFetchCourse(){
		int result = repo.fetchAllCourses();
		assertEquals("Two courses should be present", result, 2);
	}
	
	@Test
	public void testFetchCourseByName(){
		Course course = repo.fetchAllCoursesByName("Angular");
		assertEquals("Two courses should be present", course.getTitle(), "Angular");
	}
}
