package com.jhomlala.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.jhomlala.spring.config.MvcConfiguration;
import com.jhomlala.spring.dao.BusStopDAO;
import com.jhomlala.spring.dao.BusStopDAOImpl;
import com.jhomlala.spring.dao.CityMapper;
import com.jhomlala.spring.dao.TerritorialMapper;


@Component
public class Startup implements ApplicationListener<ContextRefreshedEvent> {
	

	private static TerritorialMapper territorialMapper;
	
  
	
  @Override
  public void onApplicationEvent(final ContextRefreshedEvent event) 
  {
	  
	  territorialMapper = new TerritorialMapper();
	  CityMapper cityMapper = new CityMapper(territorialMapper.getVoivodeshipList());
  }



	public static TerritorialMapper getTerritorialMapper() {
		return territorialMapper;
	}




  
  
}