package com.jhomlala.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.jhomlala.spring.config.MvcConfiguration;
import com.jhomlala.spring.dao.BusStopDAOImpl;
import com.jhomlala.spring.dao.CourseDAOImpl;
import com.jhomlala.spring.model.City;
import com.jhomlala.spring.model.Course;
import com.jhomlala.spring.model.Stop;
import com.jhomlala.spring.model.Symbol;

public class CourseController 
{

	private List <Course> courseList;
	private List <City> cityList;
	private List <Symbol> symbolList;
	MvcConfiguration config;
	DataSource dataForDAO;
	CourseDAOImpl CourseIMPL;
	BusStopDAOImpl StopIMPL;
	
	public CourseController()
	{
		loadConfiguration();
		loadCourseListFromDatabase();
		loadElementsForCourseFromStartup();
		
		courseList = loadCityNames(courseList,cityList);
		courseList = loadSymbols(courseList,symbolList);
		courseList = loadStopList(courseList,StopIMPL);
		courseList = loadStopListCityNames(courseList,cityList);
	}
	
	
	
	private void loadElementsForCourseFromStartup() 
	{
		cityList = Startup.getCityMapper().getCityList();
		symbolList = Startup.getSymbolMapper().getSymbolList();
		
	}



	private void loadCourseListFromDatabase() 
	{
		courseList = CourseIMPL.listCourses();	
	}



	private void loadConfiguration() 
	{
		config = new MvcConfiguration();
		dataForDAO = config.getDataSource();
		CourseIMPL = new CourseDAOImpl(dataForDAO);
		StopIMPL = new BusStopDAOImpl(dataForDAO);
	}



	public  List<Course> loadStopList(List<Course> courseList, BusStopDAOImpl stopIMPL)
	{
		for (Course course: courseList)
		{
			List <Stop> stopList = stopIMPL.listStopsWithID(course.getCourseID());
			course.setStopList(stopList);
		}
		
		return courseList;
	}
	
	public  List<Course> loadCityNames(List<Course> courseList, List<City> cityList) 
	{
		for (City city: cityList)
		{
			for (Course course: courseList)
			{
				if (course.getArrivalCityID() == city.getCityID())
					course.setArrivalCity(city);
				if (course.getDepartureCityID() == city.getCityID())
					course.setDepartureCity(city);
			}
		}
		return courseList;
	}

	public List <Course>loadSymbols(List<Course> courseList, List<Symbol> globalSymbolList) 
	{
		for (Course course: courseList)
		{
			String symbols = course.getSymbols();
			String symbolArray [] = symbols.trim().split(",");
			List <Symbol> symbolListForCourse = getSymbolListFromArray(symbolArray,globalSymbolList);
			course.setSymbolList(symbolListForCourse);
		}
		return courseList;
	}
	
	
	
	private  List<Symbol> getSymbolListFromArray(String[] symbolArray,List <Symbol> globalSymbolList)
	{
		List <Symbol> symbolListForCourse = new ArrayList<Symbol> ();
		for (int k=0;k<symbolArray.length;k++)
		{
			for (Symbol symbol: globalSymbolList)
			{
				if (symbol.getSymbolShort().equals(symbolArray[k]))
					symbolListForCourse.add(symbol);
			}
		}
		return symbolListForCourse;
	}

	public  List<Course> loadStopListCityNames(List<Course> courseList, List<City> cityList) 
	{
		for (Course course: courseList)
		{
			List <Stop> stopList = course.getStopList();
			for (Stop stop: stopList)
			{
				for (City city: cityList)
				{
					if (city.getCityID() == stop.getCityID())
						stop.setCityName(city.getCityName());
				}
			}
		}
		
		return courseList;
	}
	
	public List<Course> getCourseList()
	{
	
		return courseList;
		
	}
	   
}
