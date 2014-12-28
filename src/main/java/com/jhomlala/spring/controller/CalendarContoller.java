package com.jhomlala.spring.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.jhomlala.spring.model.CalendarSymbols;


public class CalendarContoller
{
	
	
	public List <Date> getDateListFromCalendarSymbol(CalendarSymbols symbol,int year)
	{
		List <Date> returnList = new ArrayList <Date>();

		switch (symbol)
		{
			case Eastern_1_Day:
			{
				List <Date> list = new ArrayList <Date>();
				list.add(getEasternDays(year).get(0));
				return list;
			}
			case Eastern_2_Day:
			{
				List <Date> list = new ArrayList <Date>();
				list.add(getEasternDays(year).get(1));
				return list;
			}
			case Christmas_1_Day:
			{
				List <Date> list = new ArrayList <Date>();
				list.add(getChristmasDays(year).get(0));
				return list;
			}
			case Christmas_2_Day:
			{
				List <Date> list = new ArrayList <Date>();
				list.add(getChristmasDays(year).get(1));
				return list;
			}
			case Christmas_3_Day:
			{
				List <Date> list = new ArrayList <Date>();
				list.add(getChristmasDays(year).get(2));
				return list;
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
			case Winter_Holidays:
			{
				return getYear(year);
			}
			case School_Working_Days:
			{
				return differenceTwoDateLists(differenceTwoDateLists(getYear(year),getVacation(year)),sumTwoDateLists(
						getHolidays(year),sumTwoDateLists(getSaturdays(year),getSundays(year))));
			}
			case New_Year_Eve_1_Day:
			{
				List <Date> listNYE = getNewYearEve(year);
				List <Date> listNYEReturn = new ArrayList <Date>();
				listNYEReturn.add(listNYE.get(0));
				
				return listNYEReturn;
			}
			case New_Year_Eve_2_Day:
			{
				List <Date> listNYE = getNewYearEve(year);
				List <Date> listNYEReturn = new ArrayList <Date>();
				listNYEReturn.add(listNYE.get(1));
				
				return listNYEReturn;
			}
			case Week:
			{
				return differenceTwoDateLists(getYear(year),getWeekDays(year));
			}
			case Vacation:
			{
				return getVacation(year);
			}
			
		}

		return returnList;
	}
	
	
	public CalendarSymbols getCalendarSymbolsFromString(String calendarSymbolString)
	{
		switch (calendarSymbolString)
		{
		case "Eastern_1_Day":
			return CalendarSymbols.Eastern_1_Day;
		
		case "Eastern_2_Day":
			return CalendarSymbols.Eastern_2_Day;
			
		case "Christmas_1_Day":
			return CalendarSymbols.Christmas_1_Day;
			
		case "Christmas_2_Day":
			return CalendarSymbols.Christmas_2_Day;
			
		case "Christmas_3_Day":
			return CalendarSymbols.Christmas_3_Day;
			
		case "Friday":
			return CalendarSymbols.Friday;
			
		case "Saturday":
			return CalendarSymbols.Saturday;
			
		case "Sunday":
			return CalendarSymbols.Sunday;
			
		case "Vacation":
			return CalendarSymbols.Vacation;
			
		case "Winter_Holidays":
			return CalendarSymbols.Winter_Holidays;	
			
		case "School_Working_Days":
			return CalendarSymbols.School_Working_Days;		
			
		case "New_Year_Eve_1_Day":
			return CalendarSymbols.New_Year_Eve_1_Day;	
			
		case "New_Year_Eve_2_Day":
			return CalendarSymbols.New_Year_Eve_2_Day;	
			
		case "Week":
			return CalendarSymbols.Week;
		}
		return null;
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
	
	
	public List<Date> getWeekDays(int year)
	{
		List <Date> weekdaysList = new ArrayList<Date>();
		Calendar cal = new GregorianCalendar(year, 0, 1);

		while (cal.getTime().getYear() != year-1900 + 1)
		{
			int day = cal.get(Calendar.DAY_OF_WEEK);
			   
			if (day == Calendar.MONDAY  ) 
			{
				weekdaysList.add(cal.getTime());
			}
			if (day == Calendar.TUESDAY ) 
			{
				weekdaysList.add(cal.getTime());
			}
			if (day == Calendar.THURSDAY  ) 
			{
				weekdaysList.add(cal.getTime());
			}
			if (day == Calendar.WEDNESDAY  ) 
			{
				weekdaysList.add(cal.getTime());
			}
			if (day == Calendar.FRIDAY  ) 
			{
				weekdaysList.add(cal.getTime());
			}
			
			
			cal.add(Calendar.DAY_OF_YEAR, 1);
		}
		
		return weekdaysList;
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
	
	public List<Date> getHolidays(int year)
	{
		List <Date> holidaysCalendar = new ArrayList<Date>();
		holidaysCalendar.addAll(getEasternDays(year));
		holidaysCalendar.addAll(getChristmasDays(year));
		holidaysCalendar.addAll(getNewYearEve(year));
		return holidaysCalendar;
	}
	
	
	public List<Date> getNewYearEve(int year)
	{
		Calendar calendar = new GregorianCalendar(year,11,31);
		List <Date> newYearEve = new ArrayList<Date>();
		newYearEve.add(calendar.getTime());
		calendar.add(Calendar.DAY_OF_MONTH, 1);
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
