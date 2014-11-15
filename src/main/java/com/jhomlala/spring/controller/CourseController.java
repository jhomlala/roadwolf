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

	public static List<Course> loadStopList(List<Course> courseList, BusStopDAOImpl stopIMPL)
	{
		for (int i=0;i<courseList.size();i++)
		{
			List <Stop> stopList = stopIMPL.listStopsWithID(courseList.get(i).getCourseID());
			courseList.get(i).setStopList(stopList);
		}
		
		return courseList;
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
	public static List<Course> loadStopListCityNames(List<Course> courseList, List<City> cityList) 
	{
		for (int i=0;i<courseList.size();i++)
		{
			List <Stop> stopList = courseList.get(i).getStopList();
			for (int k=0;k<stopList.size();k++)
			{
				for (int c=0;c<cityList.size();c++)
				{
					if (cityList.get(c).getCityID()==stopList.get(k).getCityID())
					{
						stopList.get(k).setCityName(cityList.get(c).getCityName());
					}
				}
			}
		}
		
		return courseList;
	}
	   
	  
	
}
