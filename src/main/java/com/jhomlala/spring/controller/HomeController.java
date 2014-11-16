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
import com.jhomlala.spring.model.City;
import com.jhomlala.spring.model.Course;
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
		
	GraphSearch GS = new GraphSearch();
	List <Vertex> vertexList = Startup.getGraphBuilder().getGraph();
	Vertex a = Startup.getGraphBuilder().getVertexWithID(64653);
	Vertex b = Startup.getGraphBuilder().getVertexWithID(101);
	System.out.println(a.getVertexID());
	System.out.println(b.getVertexID());
	GS.findNodesBetweenPoints(a, b);
	
	model.setViewName("home");
		return model;
	}
	

	@RequestMapping(value = "course", method = RequestMethod.POST)
	public ModelAndView viewPlayer(ModelAndView model,HttpServletRequest request) throws IOException 
	{
		CourseSearch courseSearch = new CourseSearch(99064, 100); 
		
		//List <Course> courseList = CourseSearch.findDirectConnection(64653, 990641);
		List <Course> courseList = null;
		//Map Time class from String class
		String time = request.getParameter("time");
		//TimeMapper timemap = new TimeMapper(time);
		//Time timeMapped = timemap.getTime();
		 
		
		
		//model.addObject("timeMapped",timeMapped);
		model.addObject("cslist", courseList);
	    model.setViewName("course");
	    
	    return model;
	}

	

}
