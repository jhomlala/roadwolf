package com.jhomlala.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;



import com.jhomlala.spring.model.Course;
import com.jhomlala.spring.model.Time;

public class CourseMapper implements RowMapper<Course> 
{
   public Course mapRow(ResultSet rs, int rowNum) throws SQLException 
   {
	   
	   Course course = new Course();
	   course.setCourseID(rs.getInt("COURSE_ID"));
	   course.setOperatorID(rs.getInt("OPERATOR_ID"));
	   course.setDepartureCityID(rs.getInt("CITY_DEPARTURE_ID"));
	   course.setArrivalCityID(rs.getInt("CITY_ARRIVAL_ID"));
	   course.setDepartureTime(new Time(rs.getString("DEPARTURE_TIME")));
	   course.setArrivalTime(new Time(rs.getString("ARRIVAL_TIME")));
	   course.setStopList(new BusStopMapper(rs.getString("STOP_LIST")).getStopList());
	   course.setSymbolList(new SymbolMapper(rs.getString("SYMBOLS")).getSymbolList());

      return course;
   }
   
  
}