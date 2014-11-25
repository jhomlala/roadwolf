package com.jhomlala.spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Deque;
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
import com.jhomlala.spring.model.City;
import com.jhomlala.spring.model.Course;
import com.jhomlala.spring.model.Node;
import com.jhomlala.spring.model.Stop;
import com.jhomlala.spring.model.Symbol;
import com.jhomlala.spring.model.Time;
import com.jhomlala.spring.model.Vertex;

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
	public ModelAndView home(ModelAndView model) {
	
	model.setViewName("home");
		return model;
	}
	

	@RequestMapping(value = "course", method = RequestMethod.POST)
	public ModelAndView viewPlayer(ModelAndView model,HttpServletRequest request) throws IOException 
	{

		List <Course> courseList = null;

		String time = request.getParameter("datetimepicker");
		System.out.println(time);
		String cityFrom = request.getParameter("cityFrom");
		String cityTo = request.getParameter("cityTo");
		System.out.println(cityFrom);
		System.out.println(cityTo);
		
		System.out.println(cityTo.substring(1,cityTo.indexOf(')')));
		
		
		//model.addObject("timeMapped",timeMapped);
		model.addObject("cslist", courseList);
	    model.setViewName("course");
	    
	    return model;
	}

	

}
