package com.jhomlala.spring.model;

public class Stop 
{
	private int stopID;
	private int courseID;
	private int cityID;
	private Time arrivalTime;
	private Time departureTime;
	private String cityName;
	
	
	/**
	 * @param stopID
	 * @param courseID
	 * @param cityID
	 * @param arrivalTime
	 * @param departureTime
	 */
	public Stop()
	{
		
	}
	public Stop(int stopID, int courseID, int cityID, Time arrivalTime,
			Time departureTime) {
		super();
		this.stopID = stopID;
		this.courseID = courseID;
		this.cityID = cityID;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}
	public int getStopID() {
		return stopID;
	}
	public void setStopID(int stopID) {
		this.stopID = stopID;
	}
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public int getCityID() {
		return cityID;
	}
	public void setCityID(int cityID) {
		this.cityID = cityID;
	}
	public Time getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public Time getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
	
	
}




