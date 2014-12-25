package com.jhomlala.spring.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


public class CalendarContoller
{
	public enum CalendarSymbols {
		Eeastern_1_Day,Eastern_2_Day,Christmas_1_Day,Christmas_2_Day,Christmas_3_Day,Friday,Saturday,Sunday,Vacation, 
		Winter_Holidays,School_Working_Days,New_Year_Eve_1day,New_Year_Eve_2day,
	}
	
	public List <Date> getDateListFromCalendarSymbol(CalendarSymbols symbol,int year)
	{
		List <Date> returnList = new ArrayList <Date>();
		List <Date> helperList;
		switch (symbol)
		{
		case Eeastern_1_Day:
		{
			return getEasternDays(year);
		}
		case Eastern_2_Day:
		{
			return getEasternDays(year);
		}
		case Christmas_1_Day:
		{
			return getChristmasDays(year);
		}
		case Christmas_2_Day:
		{
			return getChristmasDays(year);
		}
		case Christmas_3_Day:
		{
			return getChristmasDays(year);
		}
		case Friday:
		{
			return getFridays(year);
		}
		case Saturday:
		{
			return getSaturdays(year);
		}
		case Sunday:
		{
			return getSundays(year);
		}
		
		
		
		}
		
		
	
		
		return returnList;
	}
	
	
	
	
	public CalendarContoller()
	{
		
	}
	
	public List<Date> sumTwoDateLists(List <Date> sourceList,List <Date> toAddList)
	{
		boolean found = false;
		for (Date date: toAddList)
		{
			found = false;
			for (Date dateSource: sourceList)
			{
				if (dateSource.equals(toAddList))
				{
					found = true;
				}
			}
			if (!found)
				sourceList.add(date);
		}
		
		return sourceList;
	}
	
	public List<Date> differenceTwoDateLists(List <Date> sourceList,List <Date> toRemoveList)
	{
		sourceList.removeAll(toRemoveList);
		return sourceList;
	}
	
	
	
	public List<Date> getYear(int year)
	{
		List <Date> yearList = new ArrayList <Date>();
		Calendar cal = new GregorianCalendar(year, 1, 1);
		while (cal.getTime().getYear() != year-1900+1)
		{
			yearList.add(cal.getTime());
			cal.add(Calendar.DAY_OF_YEAR, 1);
			
		}
		
		return yearList;
	}
	
	
	
	public List <Date> getVacation(int year)
	{
		List <Date> vacationList = new ArrayList <Date>();
		Calendar cal = new GregorianCalendar(year, 6, 1);
		cal.add( Calendar.DAY_OF_MONTH, -( cal.get( Calendar.DAY_OF_WEEK ) % 7 + 1 ) );
		vacationList.add(cal.getTime());
		
		while (cal.getTime().getMonth() != 8 )
		{
			cal.add(Calendar.DAY_OF_YEAR, 1);
			vacationList.add(cal.getTime());
		}
		
		return vacationList;
		
	}
	
	
	
	
	
	public List<Date> getFridays(int year)
	{
		
		List <Date> saturdaysList = new ArrayList<Date>();
		Calendar cal = new GregorianCalendar(year, 0, 1);

		while (cal.getTime().getYear() != year-1900 + 1)
		{
			int day = cal.get(Calendar.DAY_OF_WEEK);
			   
			if (day == Calendar.FRIDAY ) 
			{
				saturdaysList.add(cal.getTime());
			}
			
			cal.add(Calendar.DAY_OF_YEAR, 1);
		}
		
		return saturdaysList;
	}
	
	public List<Date> getSaturdays(int year)
	{
		
		List <Date> saturdaysList = new ArrayList<Date>();
		Calendar cal = new GregorianCalendar(year, 0, 1);

		while (cal.getTime().getYear() != year-1900 + 1)
		{
			int day = cal.get(Calendar.DAY_OF_WEEK);
			   
			if (day == Calendar.SATURDAY ) 
			{
				saturdaysList.add(cal.getTime());
			}
			
			cal.add(Calendar.DAY_OF_YEAR, 1);
		}
		
		return saturdaysList;
	}
	
	public List<Date> getSundays(int year)
	{
		
		List <Date> saturdaysList = new ArrayList<Date>();
		Calendar cal = new GregorianCalendar(year, 0, 1);

		while (cal.getTime().getYear() != year-1900 + 1)
		{
			int day = cal.get(Calendar.DAY_OF_WEEK);
			   
			if (day == Calendar.SUNDAY ) 
			{
				saturdaysList.add(cal.getTime());
			}
			
			cal.add(Calendar.DAY_OF_YEAR, 1);
		}
		
		return saturdaysList;
	}
	
	public List<Date> getHolidaysCalendar(int year)
	{
		List <Date> holidaysCalendar = new ArrayList<Date>();
		holidaysCalendar.addAll(getEasternDays(year));
		holidaysCalendar.addAll(getChristmasDays(year));
		holidaysCalendar.addAll(getNewYearEve(year));
		return holidaysCalendar;
	}
	
	
	public List<Date> getNewYearEve(int year)
	{
		Calendar calendar = new GregorianCalendar(year,0,1);
		List <Date> newYearEve = new ArrayList<Date>();
		newYearEve.add(calendar.getTime());
		return newYearEve;
	}
	
	
	public List <Date> getChristmasDays(int year)
	{
		List <Date> christmasCalendar = new ArrayList<Date>();
		Calendar calendar = new GregorianCalendar(year,11,24);
		christmasCalendar.add(calendar.getTime());
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		christmasCalendar.add(calendar.getTime());
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		christmasCalendar.add(calendar.getTime());
		return christmasCalendar;
	}
	
	public List <Date> getEasternDays(int year)
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
		 easternDaysList.add(cal.getTime());
		 
			
			
		return easternDaysList;
	}
	
	
}
