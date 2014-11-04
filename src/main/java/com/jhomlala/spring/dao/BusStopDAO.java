package com.jhomlala.spring.dao;

import com.jhomlala.spring.model.BusStop;
import com.jhomlala.spring.model.Course;

public interface BusStopDAO {
	

	
	public void delete(int contactId);
	
	public BusStop get(int contactId);
	
	//public List<Contact> list();
}
