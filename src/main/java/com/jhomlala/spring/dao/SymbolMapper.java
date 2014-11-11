package com.jhomlala.spring.dao;

import java.util.ArrayList;
import java.util.List;

import com.jhomlala.spring.model.Symbol;

public class SymbolMapper 
{
	List <Symbol> symbolList ;
	public SymbolMapper(String symbols)
	{
		symbolList = new ArrayList<Symbol>();
	}
	public List<Symbol> getSymbolList() {
		return symbolList;
	}

	
}
