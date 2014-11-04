package com.jhomlala.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.jhomlala.spring.model.BusStop;
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
   
   public static List <Course> changeCourseBusStopIDtoName(List <BusStop> busStopList,List<Course> courseList)
   {
	   for (int i=0;i<courseList.size();i++)
		{
			for (int k=0;k<busStopList.size();k++)
			{
				if (courseList.get(i).getFromBS() == busStopList.get(k).getId())
				{
					courseList.get(i).setFromBSName(busStopList.get(k).getBusStopName());
				}
				if (courseList.get(i).getToBS() == busStopList.get(k).getId())
				{
					courseList.get(i).setToBSName(busStopList.get(k).getBusStopName());
				}
				
			}
		}
	   return courseList;
   }
}