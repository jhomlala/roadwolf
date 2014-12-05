package com.jhomlala.spring.controller;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import javax.sql.DataSource;

import com.jhomlala.spring.config.MvcConfiguration;
import com.jhomlala.spring.dao.BusStopDAOImpl;
import com.jhomlala.spring.dao.CourseDAOImpl;
import com.jhomlala.spring.model.City;
import com.jhomlala.spring.model.Course;
import com.jhomlala.spring.model.Stop;
import com.jhomlala.spring.model.Symbol;
import com.jhomlala.spring.model.Time;

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
	
	public List<Course> loadCoursesFromPath(Deque <Integer> path, String time)
	{
		TimeMapper timemapper = new TimeMapper(time);
		Time currentTime = timemapper.getTime();
		currentTime = new Time(time);
		List <Integer> pathList = transformPathToList(path);
		for (int a:pathList)
			System.out.println(a);
		
		
		List <Course> pathCourseList = new ArrayList<Course>();
		List <Course> tempList = new ArrayList<Course>();

		
		for (int i=0;i<pathList.size();i++)
		{
			for (Course course:courseList)
			{
				if(i+1<pathList.size())
					if (course.getArrivalCityID() == pathList.get(i+1) && course.getDepartureCityID()==pathList.get(i))
					pathCourseList.add(course);
			}

		}
		
		//find by time
		int range = 15; // 15min range
		boolean found=false;
		for (int i=0;i<pathList.size();i++)
		{
			loops:
			if (i+1 < pathList.size())
			while (!found)
			{
				for (int k=0;k<pathCourseList.size();k++)
				{
					if (pathCourseList.get(k).getDepartureCityID() == pathList.get(i) && pathCourseList.get(k).getArrivalCityID() == pathList.get(i+1))
					{
						System.out.println("Tak"+k);
						if (isTimeInRange(currentTime,pathCourseList.get(k).getDepartureTime(),range))
						{
							tempList.add(pathCourseList.get(k));
							
							range = 15;
							currentTime = pathCourseList.get(k).getArrivalTime();
							System.out.println("ZNALAZLEM");
							break loops;
							
						}
						
					}
				}
				range = range + 15;
				
			}
		}
	
	
		
		
		
	
		
		
		System.out.println("SIZE:"+pathCourseList.size());
		return tempList;
			
	}
	
	public boolean isTimeInRange(Time expectedTime, Time courseTime, int range)
	{
		Time rangeMinus = new Time (expectedTime,range);
		Time rangePlus = new Time (expectedTime,0-range);
		if (isTimeGreaterOrEquals(rangeMinus,courseTime))
		{
			System.out.println("1");
			if (isTimeGreaterOrEquals(courseTime,rangePlus))
			{
				System.out.println("2");
			
				return true;
			}
			else
			{
				System.out.println("3");
				return false;
			}
		}
		else
		{
			System.out.println("4");
			return false;
		}

	}
	
	//time 1 >= time 2
	// 20:59 i 20:40
	public boolean isTimeGreaterOrEquals(Time time1,Time time2)
	{
		System.out.println(time1 + ">" + time2);
		if (time1.getHour() > time2.getHour())
		{
			return true;
		}
		else	
		{
			if (time1.getHour() - time2.getHour() < 0)
				return false;
			if (time1.getMinute() >= time2.getMinute())
				return true;
			else
				return false;
		}
	}

	
	
	
	
	public List<Course> getCourseList()
	{
	
		return courseList;
		
	}
	

	public List<Integer> transformPathToList(Deque <Integer> path)
	{
		List <Integer> pathList = new ArrayList<Integer>();
		while (!path.isEmpty())
		{
			int removedItem = path.remove();
			pathList.add(removedItem);
		}
		return pathList;
		
	}
	
	   
}
