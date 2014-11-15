package com.jhomlala.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.jhomlala.spring.controller.TimeMapper;
import com.jhomlala.spring.model.Course;
import com.jhomlala.spring.model.Stop;
import com.jhomlala.spring.model.Time;

public class BusStopMapper implements RowMapper<Stop> 
{
	public Stop mapRow(ResultSet rs, int rowNum) throws SQLException 
	   {
		   
		   Stop busStop = new Stop();
		   busStop.setStopID(rs.getInt("STOP_ID"));
		   busStop.setCourseID(rs.getInt("COURSE_ID"));
		   busStop.setCityID(rs.getInt("CITY_ID"));
		   busStop.setArrivalTime(new TimeMapper(rs.getString("ARRIVAL_TIME")).getTime());
		   busStop.setDepartureTime(new TimeMapper(rs.getString("DEPARTURE_TIME")).getTime());
	      return busStop;
	   }
	
}
