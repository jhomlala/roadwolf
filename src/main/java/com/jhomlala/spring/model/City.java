package com.jhomlala.spring.model;

public class City 
{
	private int cityID;
	private String cityName;
	private int districtID;
	private int voivodeshipID;
	private String districtName;
	private String voivodeshipName;
	
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getVoivodeshipName() {
		return voivodeshipName; 
	}
	public void setVoivodeshipName(String voivodeshipName) {
		this.voivodeshipName = voivodeshipName;
	}
	/**
	 * @param cityID
	 * @param cityName
	 */

	public City()
	{
		
	}
	public int getDistrictID() {
		return districtID;
	}
	public void setDistrictID(int districtID) {
		this.districtID = districtID;
	}


	public int getVoivodeshipID() {
		return voivodeshipID;
	}
	public void setVoivodeshipID(int voivodeshipID) {
		this.voivodeshipID = voivodeshipID;
	}
	public int getCityID() {
		return cityID;
	}
	public void setCityID(int cityID) {
		this.cityID = cityID;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public String toString()
	{
		return cityName;
	}
	
	
}
