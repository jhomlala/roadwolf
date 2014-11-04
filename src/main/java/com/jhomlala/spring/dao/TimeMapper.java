package com.jhomlala.spring.dao;

import com.jhomlala.spring.model.Time;

public class TimeMapper 
{
	private Time timeExploded;
	public TimeMapper(String StringTimeToExplode)
	{
		String explodedTimeString [] = StringTimeToExplode.split(":");
		if (explodedTimeString.length > 2 )
		{
			timeExploded = new Time();
			if (Integer.valueOf(explodedTimeString[0]) != null)
			{
				timeExploded.setHour(Integer.valueOf(explodedTimeString[0]));
			}
			if (Integer.valueOf(explodedTimeString[1]) != null)
			{
				timeExploded.setMinute(Integer.valueOf(explodedTimeString[1]));
			}
			if (Integer.valueOf(explodedTimeString[2]) != null)
			{
				timeExploded.setSecond(Integer.valueOf(explodedTimeString[2]));
			}
			
		}
		else
		{
			System.err.println("Warning:  wrong time: "+StringTimeToExplode + ".");
		}
	}
	
	public Time getTime()
	{
		return timeExploded;
	}
	

	
}
