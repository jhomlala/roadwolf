package com.jhomlala.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jhomlala.spring.model.Course;

public class CourseMapper implements RowMapper<Course> 
{
   public Course mapRow(ResultSet rs, int rowNum) throws SQLException 
   {
	   Course course = new Course(
				rs.getInt("COURSEID"),
				rs.getInt("FROMID"), 
				rs.getInt("TOID"), 
				rs.getString("DEPARTURETIME"), 
				rs.getString("ARRIVALTIME"), 
				rs.getString("SYMBOLS")
			 
			);
      return course;
   }
}