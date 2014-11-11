package com.jhomlala.spring.dao;

import java.util.ArrayList;
import java.util.List;

import com.jhomlala.spring.model.Stop;

public class BusStopMapper 
{
	private List <Stop> stopList;
	public BusStopMapper(String ids)
	{
		stopList = new ArrayList<Stop>();
	}
	public List<Stop> getStopList() {
		return stopList;
	}

	
}
