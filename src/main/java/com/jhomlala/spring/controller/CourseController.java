package com.jhomlala.spring.controller;

import java.util.ArrayList;
import java.util.List;

import com.jhomlala.spring.dao.BusStopDAOImpl;
import com.jhomlala.spring.model.City;
import com.jhomlala.spring.model.Course;
import com.jhomlala.spring.model.Stop;
import com.jhomlala.spring.model.Symbol;

public class CourseController 
{

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
	   
}
