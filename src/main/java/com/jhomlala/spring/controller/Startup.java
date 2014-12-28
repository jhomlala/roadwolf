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
import com.jhomlala.spring.model.CalendarSymbols;
import com.jhomlala.spring.model.Symbol;


@Component
public class Startup implements ApplicationListener<ContextRefreshedEvent> {
	

	private static TerritorialMapper territorialMapper;
	private static CityMapper cityMapper;
	private static SymbolMapper symbolMapper;
	private static GraphBuilder graphBuilder;
	private static OperatorController operatorController;
	
  @Override
  public void onApplicationEvent(final ContextRefreshedEvent event) 
  {
	  
	  territorialMapper = new TerritorialMapper();
	  cityMapper = new CityMapper(territorialMapper.getVoivodeshipList());
	  symbolMapper = new SymbolMapper();
	  graphBuilder = new GraphBuilder();
	  operatorController = new OperatorController();
	  
	  for (Symbol symbol: symbolMapper.getSymbolList())
	  {
		  List <CalendarSymbols> calList = symbol.getCalendarSymbolsList();
		  if (calList !=null)
		  for (CalendarSymbols calendar:calList)
		  {
			  System.out.println(calendar);
		  }
	  }
  }

  


	public static GraphBuilder getGraphBuilder() {
	return graphBuilder;
	}




	public static void setGraphBuilder(GraphBuilder graphBuilder) {
		Startup.graphBuilder = graphBuilder;
	}




	public static TerritorialMapper getTerritorialMapper() {
		return territorialMapper;
	}



	public static CityMapper getCityMapper() {
		return cityMapper;
	}


	public static SymbolMapper getSymbolMapper() {
		return symbolMapper;
	}




	public static OperatorController getOperatorController() {
		return operatorController;
	}

  
  
}