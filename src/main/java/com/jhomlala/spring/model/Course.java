package com.jhomlala.spring.model;

import java.util.ArrayList;
import java.util.List;

public class Course 
{
	private int courseID;
	private int operatorID;
	private int departureCityID;
	private int arrivalCityID;
	private Time departureTime;
	private Time arrivalTime;
	private List <Stop> stopList;
	private List <Symbol> symbolList;
	private City departureCity;
	private City arrivalCity;
	private String symbols;
	
	
	public Course()
	{
		
	}
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public int getOperatorID() {
		return operatorID;
	}
	public void setOperatorID(int operatorID) {
		this.operatorID = operatorID;
	}
	public int getDepartureCityID() {
		return departureCityID;
	}
	public void setDepartureCityID(int departureCityID) {
		this.departureCityID = departureCityID;
	}
	public int getArrivalCityID() {
		return arrivalCityID;
	}
	public void setArrivalCityID(int arrivalCityID) {
		this.arrivalCityID = arrivalCityID;
	}
	public Time getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}
	public Time getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public List<Stop> getStopList() {
		return stopList;
	}
	public void setStopList(List<Stop> stopList) {
		this.stopList = stopList;
	}
	public List<Symbol> getSymbolList() {
		return symbolList;
	}
	public void setSymbolList(List<Symbol> symbolList) {
		this.symbolList = symbolList;
	}
	public City getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(City departureCity) {
		this.departureCity = departureCity;
	}
	public City getArrivalCity() {
		return arrivalCity;
	}
	public void setArrivalCity(City arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	public String getSymbols() {
		return symbols;
	}
	public void setSymbols(String symbols) {
		this.symbols = symbols;
	}
	
}


