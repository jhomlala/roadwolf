package com.jhomlala.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.jhomlala.spring.model.Course;
import com.jhomlala.spring.model.Time;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class CourseDAOImpl implements CourseDAO {

	private JdbcTemplate jdbcTemplate;
	
	public CourseDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	

	@Override
	public void delete(int contactId) {
		String sql = "DELETE FROM contact WHERE contact_id=?";
		jdbcTemplate.update(sql, contactId);
	}

	

	@Override
	public List <Course> listCoursesWithID(int courseID) {
		String sql = "SELECT * FROM course WHERE COURSE_ID=" + courseID;
		return jdbcTemplate.query(sql,new CourseMapper()); 
	}



	@Override
	public List<Course> listCourses() 
	{
		 String SQL = "select * from course";
	     List <Course> courses = jdbcTemplate.query(SQL, new CourseMapper());
	     return courses;
	}



	@Override
	public List<Course> listCoursesWithCityID(int departureCityID, int arrivalCityID) 
	{
		String SQL = "select * from course WHERE CITY_DEPARTURE_ID = "+departureCityID+" AND CITY_ARRIVAL_ID = "+arrivalCityID;
		List <Course> courses = jdbcTemplate.query(SQL, new CourseMapper());
		return courses;
	}



	@Override
	public List<Course> listCoursesWithDepartureCityID(int departureCityID) {
		String SQL = "select * from course WHERE CITY_DEPARTURE_ID = "+departureCityID;
		List <Course> courses = jdbcTemplate.query(SQL,new CourseMapper());
		return courses;
	}



	@Override
	public List<Course> listCoursesWithArrivalCityID(int arrivalCityID) {
		String SQL = "select * from course WHERE CITY_ARRIVAL_ID = "+arrivalCityID;
		List <Course> courses = jdbcTemplate.query(SQL,new CourseMapper());
		return courses;
	}

}
