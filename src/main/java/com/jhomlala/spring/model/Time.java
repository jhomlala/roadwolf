package com.jhomlala.spring.model;

import com.jhomlala.spring.controller.TimeMapper;

public class Time 
{
	private int hour;
	private int minute;
	private int second;
	/**
	 * @param hour
	 * @param minute
	 * @param second
	 */
	public Time(int hour, int minute, int second) {
		super();
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public Time()
	{
		
	}
	
	public Time(String timeToExplode)
	{
		TimeMapper timeMapper = new TimeMapper(timeToExplode);
		this.hour = timeMapper.getTime().getHour();
		this.minute = timeMapper.getTime().getMinute();
		this.hour = timeMapper.getTime().getHour();
	}
	public Time(Time time,int range)
	{
		this.hour = time.getHour();
		this.minute = time.getMinute();
		this.second = time.getSecond();
		
		boolean isNegative = false;
		if (range < 0) 
			isNegative = true;
		range = Math.abs(range);
		
		int rangeHour = range / 60;
		int rangeMinute = Math.abs(rangeHour*60 - range);

		if (!isNegative)
		{
			
			this.hour = this.hour + rangeHour;
			if (this.minute + rangeMinute > 60)
			{
				this.hour++;
				//10.45 -> + 25 -> 11:10
				int rangeMinus = 60 - this.minute;
				rangeMinute = rangeMinute - rangeMinus;
				this.minute = rangeMinute;
			}
			else
			{
				this.minute = this.minute+rangeMinute;
			}
		}
		else
		{
			//is negative
		
			this.hour = this.hour - rangeHour;
			if (this.minute - rangeMinute < 0)
			{
				this.hour--;
				int rangeMinus = this.minute;
				rangeMinute = rangeMinute - rangeMinus;
				this.minute = 60 - rangeMinute;
			}
			else
			{
				this.minute = this.minute - rangeMinute;
			}
			
			
		}
		if (this.minute == 60)
		{ 
			this.hour++;
			this.minute = 0;
		}
		
		
		
	}
	
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	
	public String toString()
	{
		return this.hour + ":" + this.minute + ":" + this.second ;
	}
	
}
