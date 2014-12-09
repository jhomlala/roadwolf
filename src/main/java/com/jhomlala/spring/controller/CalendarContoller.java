package com.jhomlala.spring.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


public class CalendarContoller
{
	
	public CalendarContoller()
	{
		
	}
	
	
	public List <Date> getEasternDaysForYear(int year)
	{
		Calendar cal = new GregorianCalendar(year,2,22);
		
		List <Date> easternDaysList = new ArrayList<Date>();
		Date firstEasterDay;
		//gauss method
		int A = 24;
		int B = 5;
		int a = year % 19;
		int b = year % 4;
		int c = year % 7;
		int d = (a * 19 + A) % 30;
		int e = (2*b + 4*c + 6*d + B) % 7;
		
		// 2 exceptions from gauss
		cal.add(Calendar.DAY_OF_MONTH, d+e);

		
		if (d == 29 && e == 6)
			cal = new GregorianCalendar(year,3,19);
		if (d == 28 && e == 6)
			cal = new GregorianCalendar(year,3,18);
		
		
		
		 easternDaysList.add(cal.getTime());
		 cal.add(Calendar.DAY_OF_MONTH, 1);
		 System.out.println(cal.getTime());
		 easternDaysList.add(cal.getTime());
		 
			
			
		return easternDaysList;
	}
	
	
}
