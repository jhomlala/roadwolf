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
	
	public Course get(int contactId);
	
	public List<Course> listCourses();

}
