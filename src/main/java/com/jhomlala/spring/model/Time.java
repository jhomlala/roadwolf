package com.jhomlala.spring.model;

import com.jhomlala.spring.dao.TimeMapper;

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
	
	
}
