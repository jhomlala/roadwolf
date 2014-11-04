package com.jhomlala.spring.model;

public class BusStop 
{
	int id;
	String busStopName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBusStopName() {
		return busStopName;
	}
	public void setBusStopName(String busStopName) {
		this.busStopName = busStopName;
	}
	/**
	 * @param id
	 * @param busStopName
	 */
	public BusStop(int id, String busStopName) {
		super();
		this.id = id;
		this.busStopName = busStopName;
	}
	
	
	
	
}




