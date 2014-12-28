package com.jhomlala.spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import com.jhomlala.spring.dao.OperatorDAO;
import com.jhomlala.spring.model.CalendarSymbols;
import com.jhomlala.spring.model.City;
import com.jhomlala.spring.model.Course;
import com.jhomlala.spring.model.Node;
import com.jhomlala.spring.model.Operator;
import com.jhomlala.spring.model.Stop;
import com.jhomlala.spring.model.Symbol;
import com.jhomlala.spring.model.Time;
import com.jhomlala.spring.model.Vertex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
	
	@Autowired
	private OperatorDAO operatorDAO;
	
	@RequestMapping(value="/")
	public ModelAndView home(ModelAndView model) {
	
	model.setViewName("home");
	
	
		return model;
	}
	

	@RequestMapping(value = "course", method = RequestMethod.POST)
	public ModelAndView viewPlayer(ModelAndView model,HttpServletRequest request) throws IOException 
	{
		List <Course> courseList = null;
		CourseController controler = new CourseController();
		FormCheck formCheck = new FormCheck();
		String time = request.getParameter("datetimepicker");
		String cityFrom = request.getParameter("cityFrom");
		String cityTo = request.getParameter("cityTo");
		String cityFromHidden = request.getParameter("cityFromHidden");
		String cityToHidden = request.getParameter("cityToHidden");

		 
		int toID = formCheck.checkCityID(cityToHidden);
		int fromID = formCheck.checkCityID(cityFromHidden);
		
		if (toID == -1 || fromID == -1 )
			throw new SpringException("Prosze wybrac miejscowosci ponownie.");
		
		BFSSearch bfss = new BFSSearch(Startup.getGraphBuilder().getGraph(),fromID,toID);
		Deque <Integer> path = bfss.getPath();
		
		String [] timeAndDateSplited = formCheck.checkDoesTimeAndDateValid(time);
		
		if (timeAndDateSplited == null)
			throw new SpringException("Prosze podac wlasciwy czas!");
		else
		{
			courseList = controler.loadCoursesFromPath(path,timeAndDateSplited[1]);
		}
		
		if (courseList.size() == 0 )
			throw new SpringException("Nie znaleziono kursu o podanych warunkach.");
		
		model.addObject("cslist", courseList);
	    model.setViewName("course");
	    
	    return model;
	}

	@ExceptionHandler(com.jhomlala.spring.controller.SpringException.class)
	public ModelAndView excHandler(SpringException springException) {
		ModelAndView model = new ModelAndView();
		model.addObject("exception",springException);
		model.setViewName("ExceptionPage");
		return model;
	}

}
