package com.jhomlala.spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.jhomlala.spring.config.MvcConfiguration;
import com.jhomlala.spring.dao.BusStopDAO;
import com.jhomlala.spring.dao.BusStopDAOImpl;
import com.jhomlala.spring.dao.CourseDAO;
import com.jhomlala.spring.dao.CourseDAOImpl;
import com.jhomlala.spring.dao.CourseMapper;
import com.jhomlala.spring.dao.TimeMapper;

import com.jhomlala.spring.model.Course;
import com.jhomlala.spring.model.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class HomeController {

	@Autowired
	private CourseDAO courseDAO;
	
	@Autowired
	private BusStopDAO busStopDAO;
	
	@RequestMapping(value="/")
	public ModelAndView listContact(ModelAndView model) throws IOException{



	
	model.setViewName("home");
		return model;
	}
	

	@RequestMapping(value = "course", method = RequestMethod.POST)
	public ModelAndView viewPlayer(ModelAndView model,HttpServletRequest request) throws IOException 
	{
		MvcConfiguration config = new MvcConfiguration();
		DataSource dataForDAO = config.getDataSource();
		CourseDAOImpl CourseIMPL = new CourseDAOImpl(dataForDAO);
		List <Course> courseList = CourseIMPL.listCourses();
		
		//Map Time class from String class
		String time = request.getParameter("time");
		TimeMapper timemap = new TimeMapper(time);
		Time timeMapped = timemap.getTime();
		
		// get Bus list
		//List <BusStop> busStopList = Startup.getBusList();
		//CourseMapper.changeCourseBusStopIDtoName(busStopList, courseList);
		
		
		
		
		model.addObject("timeMapped",timeMapped);
		model.addObject("cslist", courseList);
	    model.setViewName("course");
	    
	    return model;
	}

	

}
