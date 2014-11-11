package com.jhomlala.spring.model;

import java.util.List;

public class Voivodeship {
	private int ID;
	private String name;
	private List <District> districtList;
	
	
	/**
	 * @param iD
	 * @param name
	 * @param districtList
	 */
	public Voivodeship(int iD, String name, List<District> districtList) {
		super();
		ID = iD;
		this.name = name;
		this.districtList = districtList;
	}
	public List<District> getDistrictList() {
		return districtList;
	}
	public void setDistrictList(List<District> districtList) {
		this.districtList = districtList;
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
