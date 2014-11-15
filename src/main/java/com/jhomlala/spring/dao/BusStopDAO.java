package com.jhomlala.spring.dao;


import java.util.List;

import com.jhomlala.spring.model.Course;
import com.jhomlala.spring.model.Stop;

public interface BusStopDAO {
	

	
	public void delete(int stopid);
	
	public Stop get(int stopid);
	
	public List<Stop> listStopsWithID(int id);
}
