package com.jhomlala.spring.controller;

import java.util.ArrayList;
import java.util.List;

import com.jhomlala.spring.model.*;


public class Finder 
{
	List <BusStop> busList;
	
	public Finder (List <BusStop> busList)
	{
		if (busList == null)
		{
			System.err.print("Error: Buslist is null.");
			return;
		}
		else
			this.busList = busList;
	}
	
	public List <BusStop> findByTime(Time timeToFind)
	{
		List <BusStop> returnBusList = new ArrayList<BusStop>();
		
		
		
		
		
		return returnBusList;
	}
	
	
	
	
}
