package com.jhomlala.spring.model;

import java.util.ArrayList;
import java.util.List;

public class Course 
{
	int courseID;
	int fromBS;
	int toBS;
	String departureTime;
	String arrivalTime;
	String symbols;
	String fromBSName;
	String toBSName;
	
	/**
	 * @param courseID
	 * @param fromBS
	 * @param toBS
	 * @param departureTime
	 * @param arrivalTime
	 * @param symbols
	 */
	public Course(int courseID, int fromBS, int toBS, String departureTime,
			String arrivalTime, String symbols) {
		super();
		this.courseID = courseID;
		this.fromBS = fromBS;
		this.toBS = toBS;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.symbols = symbols;
		fromBSName = "";
		toBSName = "";
	}
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public int getFromBS() {
		return fromBS;
	}
	public void setFromBS(int fromBS) {
		this.fromBS = fromBS;
	}
	public int getToBS() {
		return toBS;
	}
	public void setToBS(int toBS) {
		this.toBS = toBS;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getSymbols() {
		return symbols;
	}
	public void setSymbols(String symbols) {
		this.symbols = symbols;
	}
	public String getFromBSName() {
		return fromBSName;
	}
	public void setFromBSName(String fromBSName) {
		this.fromBSName = fromBSName;
	}
	public String getToBSName() {
		return toBSName;
	}
	public void setToBSName(String toBSName) {
		this.toBSName = toBSName;
	}
	
	//List <BusStop> busStopList = new ArrayList<BusStop>();
}


