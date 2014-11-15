package com.jhomlala.spring.dao;

import java.util.List;


import com.jhomlala.spring.model.Course;

/**
 * Defines DAO operations for the contact model.
 * @author www.codejava.net
 *
 */
public interface CourseDAO {
	

	
	public void delete(int contactId);
	
	public List <Course> listCoursesWithID(int courseID);
	
	public List<Course> listCourses();

	public List <Course> listCoursesWithCityID(int departureCityID,int arrivalCityID);
	
	public List <Course> listCoursesWithDepartureCityID(int departureCityID);
	
	public List <Course> listCoursesWithArrivalCityID(int arrivalCityID);
}
