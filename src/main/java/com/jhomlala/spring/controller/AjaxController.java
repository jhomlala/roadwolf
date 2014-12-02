package com.jhomlala.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jhomlala.spring.model.City;
import com.jhomlala.spring.model.Employee;

@Controller
public class AjaxController {
	 
 

 
	@RequestMapping(value = "/getCities", method = RequestMethod.POST, produces = "application/json")
	public  @ResponseBody List<City> getEmployees(@RequestParam String term, HttpServletResponse response) {
		return simulateSearchResult(term);
 
	}
 /**
  * 	@RequestMapping(value = "/getEmployees", method = RequestMethod.POST)
	public void getEmployees(@RequestParam String term, HttpServletResponse response) {
		System.out.println("Term entered is");
		try {
			response.setContentType("application/json");
			List al = new ArrayList();
			al.add("John D");
			al.add("Johnny");
			al.add("John");
			String g = new Gson().toJson(simulateSearchResult(term));
//			String g = new Gson().toJson(al);
			response.getWriter().write(g);
		} catch (IOException e) {
			e.printStackTrace();
		}
 
	}
 
  * @param empName
  * @return
  */

	private List<City> simulateSearchResult(String cityName) {
		List <City> data = Startup.getCityMapper().getCityList();
		List<City> result = new ArrayList<City>();
		
		// iterate a list and filter by tagName
		for (City city : data) {
			if (city.getCityName().contains(cityName)) {
				result.add(city);
			}
		}
 
		return result;
	}
 
}
