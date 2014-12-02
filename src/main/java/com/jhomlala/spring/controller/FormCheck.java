package com.jhomlala.spring.controller;

public class FormCheck 
{
	
	public String [] checkDoesTimeAndDateValid(String timeAndDate)
	{
		
		if (timeAndDate.matches("[a-zA-Z]+"))
		{
			return null;
		}
		else
		{
			String [] timeAndDateSplited = timeAndDate.split(" ");
			//wrong date check here:
			/////////////////////////
			//wrong time check here:
			System.out.println(timeAndDateSplited.length);
			if (timeAndDateSplited.length > 0 && timeAndDateSplited.length <= 2)
			{
				if (checkTime(timeAndDateSplited[1]))
				{
					timeAndDateSplited[1] = timeAndDateSplited[1]+":00";
					return timeAndDateSplited;
				}
			}
				
		}
		return null;
	}

	private boolean checkTime(String time) 
	{
		String timeSplited [] = time.split(":");
		if (timeSplited.length > 0 && timeSplited.length <= 2 )
		{
			if (checkHour(timeSplited[0]))
				if (checkMinute(timeSplited[1]))
					return true;
				else
					return false;
			else
				return false;
		}
		else
			return false;
	}
	
	public boolean checkHour(String hour)
	{
		int hourToInteger = Integer.valueOf(hour);
		if (hourToInteger >=0 && hourToInteger <=24)
			return true;
		else	
			return false;
	}
	public boolean checkMinute(String minute)
	{
		int minuteToInteger = Integer.valueOf(minute);
		if (minuteToInteger >=0 && minuteToInteger <= 60 )
			return true;
		else
			return false;
	}
	
	public int getNumberFromCityString(String cityString)
	{
		if (cityString != null && cityString.length() > 0)
		{

			int cityID = Integer.parseInt(cityString.substring(1,cityString.indexOf(')')));
			return cityID;
		}

		return 0;
		
	}
	
	
}
