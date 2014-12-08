package com.jhomlala.spring.dao;

import java.util.List;

import com.jhomlala.spring.model.Operator;

public interface OperatorDAO 
{
	public Operator listOperatorWithID(int id);
	public List<Operator> listAllOperators();
}
