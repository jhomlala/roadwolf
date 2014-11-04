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
import com.jhomlala.spring.model.BusStop;

@Component
public class Startup implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private static BusStopDAO busStopDAO;
	
  private static List <BusStop> busStopList = new ArrayList<BusStop>();
	
  @Override
  public void onApplicationEvent(final ContextRefreshedEvent event) 
  {
		MvcConfiguration config = new MvcConfiguration();
		DataSource dataForDAO = config.getDataSource();
		BusStopDAOImpl busIMPL = new BusStopDAOImpl(dataForDAO);
		BusStop bus = busIMPL.get(1);
		
		System.out.println("Creating BusStop list.");
		for (int i=0;i<100;i++)
		{
			BusStop buss = busIMPL.get(i);
			if (!(buss==null))
			{
				busStopList.add(buss);
			}
			else
			{
				System.out.println("ID: "+i+" is empty. Skipping.");
			
			}
			
		}
		System.out.println("BusStop list created.");
  }
  
  public static List<BusStop> getBusList()
  {
	  return busStopList;
  }
}