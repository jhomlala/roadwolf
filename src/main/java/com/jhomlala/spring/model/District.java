package com.jhomlala.spring.model;

public class District 
{
	private int ID;
	private String name;
	
	/**
	 * @param iD
	 * @param name
	 */
	public District(int iD, String name) {
		super();
		ID = iD;
		this.name = name;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
