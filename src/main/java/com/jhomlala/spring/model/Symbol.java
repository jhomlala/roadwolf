package com.jhomlala.spring.model;

import java.util.List;

public class Symbol 
{
	private int symbolID;
	private String symbolShort;
	private String symbolDescription;
	private List <CalendarSymbols> calendarSymbolsList;
	
	/**
	 * @param symbolID
	 * @param symbolShort
	 * @param symbolDescription
	 */
	public Symbol() {}
	public Symbol(int symbolID, String symbolShort, String symbolDescription) {
		super();
		this.symbolID = symbolID;
		this.symbolShort = symbolShort;
		this.symbolDescription = symbolDescription;
	}
	
	
	/**
	 * @param symbolID
	 * @param symbolShort
	 * @param symbolDescription
	 * @param calendarSymbolsList
	 */
	public Symbol(int symbolID, String symbolShort, String symbolDescription,
			List<CalendarSymbols> calendarSymbolsList) {
		super();
		this.symbolID = symbolID;
		this.symbolShort = symbolShort;
		this.symbolDescription = symbolDescription;
		this.calendarSymbolsList = calendarSymbolsList;
	}
	
	public List<CalendarSymbols> getCalendarSymbolsList() {
		return calendarSymbolsList;
	}
	public void setCalendarSymbolsList(List<CalendarSymbols> calendarSymbolsList) {
		this.calendarSymbolsList = calendarSymbolsList;
	}
	public int getSymbolID() {
		return symbolID;
	}
	public void setSymbolID(int symbolID) {
		this.symbolID = symbolID;
	}
	public String getSymbolShort() {
		return symbolShort;
	}
	public void setSymbolShort(String symbolShort) {
		this.symbolShort = symbolShort;
	}
	public String getSymbolDescription() {
		return symbolDescription;
	}
	public void setSymbolDescription(String symbolDescription) {
		this.symbolDescription = symbolDescription;
	}
	
}
