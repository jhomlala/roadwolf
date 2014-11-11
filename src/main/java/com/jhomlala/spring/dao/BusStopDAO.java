package com.jhomlala.spring.dao;


import com.jhomlala.spring.model.Course;
import com.jhomlala.spring.model.Stop;

public interface BusStopDAO {
	

	
	public void delete(int contactId);
	
	public Stop get(int contactId);
	
	//public List<Contact> list();
}
