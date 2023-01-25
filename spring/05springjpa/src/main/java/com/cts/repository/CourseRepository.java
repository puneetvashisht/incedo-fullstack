package com.cts.repository;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.entity.Course;
import com.cts.entity.Course2;

@Repository
public class CourseRepository {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public int fetchAllCourses(){
		   String SQL = "select * from Course c";
//		   Map<String, Object> courseMap = jdbcTemplateObject.queryForMap(SQL);
//		   System.out.println(courseMap);
//		   System.out.println(courseMap.get("name"));
//		   return courseMap.size();
		   
		   List<Map<String, Object>> coursesList= jdbcTemplateObject.queryForList(SQL);
		   System.out.println(coursesList);
		   for(Map<String, Object> courseMap: coursesList){
			   System.out.println(courseMap.get("name"));
		   }
		   return coursesList.size();
	   }

	public Course fetchAllCoursesByName(String courseName) {
		String SQL = "select * from Course c where c.name=?" ;
		
		CourseRowMapper rowMapper = new CourseRowMapper();
		Course course = jdbcTemplateObject.queryForObject(SQL, rowMapper, courseName);
		System.out.println(course);
		
		
		String SQL1 = "select c.id from Course c" ;
		List<Integer> courseCount = jdbcTemplateObject.queryForList(SQL1, Integer.class);
		System.out.println(courseCount);
		
		return course;
	}
	
	
	
	
	
	
	
	
	
	

}
