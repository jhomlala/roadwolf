package com.jhomlala.spring.controller;

import com.jhomlala.spring.model.Time;

public class TimeMapper 
{
	private Time timeExploded;
	
	public TimeMapper(String StringTimeToExplode)
	{
		
		String explodedTimeString [] = StringTimeToExplode.split(":");
		if (explodedTimeString.length > 2 )
		{
			timeExploded = loadTimeFromTable(explodedTimeString);
		}
		else
		{
			System.err.println("Warning:  wrong time: "+StringTimeToExplode + ".");
		}
	}
	
	private Time loadTimeFromTable(String explodedTimeString[])
	{
		timeExploded = new Time();
		timeExploded.setHour(Integer.valueOf(explodedTimeString[0]));
		timeExploded.setMinute(Integer.valueOf(explodedTimeString[1]));
		timeExploded.setSecond(Integer.valueOf(explodedTimeString[2]));
		return timeExploded;
	}
	
	public Time getTime()
	{
		return timeExploded;
	}
	

	
}
