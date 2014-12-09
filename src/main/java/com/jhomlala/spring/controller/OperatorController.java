package com.jhomlala.spring.controller;

import java.util.List;

import javax.sql.DataSource;

import com.jhomlala.spring.config.MvcConfiguration;
import com.jhomlala.spring.dao.OperatorDAO;
import com.jhomlala.spring.dao.OperatorDAOImpl;
import com.jhomlala.spring.model.Operator;

public class OperatorController 
{
	MvcConfiguration config;
	DataSource dataForDAO;
	List <Operator> operatorList;
	OperatorDAO operatorDAO;
	
	public OperatorController()
	{
		loadConfiguration();
		loadOperatorListFromDatabase();
	}

	private void loadOperatorListFromDatabase() 
	{
		operatorList = operatorDAO.listAllOperators();
		
	}

	private void loadConfiguration() 
	{
		config = new MvcConfiguration();
		dataForDAO = config.getDataSource();
		operatorDAO = new OperatorDAOImpl(dataForDAO);
		
	}
	
	public Operator getOperatorWithID(int id)
	{
		for (Operator operator: operatorList)
		{
			if (operator.getId() == id)
				return operator;
		}
		
		return null;
	}
	
	public List <Operator> getAllOperators()
	{
		operatorList = operatorDAO.listAllOperators();
		return operatorList;
	}
}
