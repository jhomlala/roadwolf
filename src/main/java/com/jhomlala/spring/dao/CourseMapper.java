package com.jhomlala.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;






import com.jhomlala.spring.model.City;
import com.jhomlala.spring.model.Course;
import com.jhomlala.spring.model.Symbol;
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
	   course.setSymbols(rs.getString("SYMBOLS"));

      return course;
   }

public static List<Course> loadCityNames(List<Course> courseList, List<City> cityList) 
{
	for (int i=0;i<cityList.size();i++)
	{
		for (int k=0;k<courseList.size();k++)
		{
			if (courseList.get(k).getArrivalCityID() == cityList.get(i).getCityID())
			{
				courseList.get(k).setArrivalCity(cityList.get(i));
			}
			if (courseList.get(k).getDepartureCityID() == cityList.get(i).getCityID())
			{
				courseList.get(k).setDepartureCity(cityList.get(i));
			}
		}
	}
	
	return courseList;
}

public static List <Course>loadSymbols(List<Course> courseList, List<Symbol> symbolList) 
{
	for (int i=0;i<courseList.size();i++)
	{
		String symbols = courseList.get(i).getSymbols();
		System.out.println(symbols);
		String symbolArray [] = symbols.trim().split(",");
		List <Symbol> symbolListForCourse = new ArrayList<Symbol>();
		
		for (int k=0;k<symbolArray.length;k++)
		{
			for (int s=0;s<symbolList.size();s++)
			{
				if (symbolList.get(s).getSymbolShort().equals(symbolArray[k]))
				{
					symbolListForCourse.add(symbolList.get(s));
				}
			}
		}
		courseList.get(i).setSymbolList(symbolListForCourse);
	}
	return courseList;
}
   
  
}