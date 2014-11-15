package com.jhomlala.spring.controller;
import java.util.List;

import javax.sql.DataSource;

import com.jhomlala.spring.config.MvcConfiguration;
import com.jhomlala.spring.dao.BusStopDAOImpl;
import com.jhomlala.spring.dao.CourseDAOImpl;
import com.jhomlala.spring.model.*;
public class CourseSearch 

{
	
	public CourseSearch(int departureCityID,int arrivalCityID)
	{
		List <Course> listAfterSearchDirectConnection = findDirectConnection(departureCityID,arrivalCityID);
		if (listAfterSearchDirectConnection.size() > 0 )
		{
			// yeah! direct connection!
			System.out.println("Have direct");
		}
		else
		{
			// oh :( no direct connections. but we can still something find
			System.out.println("No direct");
		}
	}
	
	
	
	
	public static List <Course> findDirectConnection(int departureCityID,int arrivalCityID)
	{
		MvcConfiguration config = new MvcConfiguration();
		DataSource dataForDAO = config.getDataSource();
		CourseDAOImpl CourseIMPL = new CourseDAOImpl(dataForDAO);
		
		List <Course> courseList = CourseIMPL.listCoursesWithCityID(departureCityID,arrivalCityID);
		List <City> cityList = Startup.getCityMapper().getCityList();
		List <Symbol> symbolList = Startup.getSymbolMapper().getSymbolList();
		
		courseList = CourseController.loadCityNames(courseList,cityList);
		courseList = CourseController.loadSymbols(courseList,symbolList);
		BusStopDAOImpl StopIMPL = new BusStopDAOImpl(dataForDAO);
		courseList = CourseController.loadStopList(courseList,StopIMPL);
		courseList = CourseController.loadStopListCityNames(courseList,cityList);
		
		return courseList;
	}
}
