package com.jhomlala.spring.model;

public class Symbol 
{
	private int symbolID;
	private String symbolShort;
	private String symbolDescription;
	
	
	/**
	 * @param symbolID
	 * @param symbolShort
	 * @param symbolDescription
	 */
	public Symbol(int symbolID, String symbolShort, String symbolDescription) {
		super();
		this.symbolID = symbolID;
		this.symbolShort = symbolShort;
		this.symbolDescription = symbolDescription;
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
