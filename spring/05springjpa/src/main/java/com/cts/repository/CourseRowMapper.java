package com.cts.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.entity.Course;

public class CourseRowMapper implements RowMapper<Course>{

	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		Course course = null;

			Integer id = rs.getInt(1);
			String name = rs.getString(2);
			String description = rs.getString(3);
			course = new Course(id, name, description);
			

		return course;
	}

}
