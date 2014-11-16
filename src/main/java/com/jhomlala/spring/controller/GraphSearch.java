package com.jhomlala.spring.controller;

import java.util.List;

import com.jhomlala.spring.model.Vertex;

public class GraphSearch 
{

	private List <Vertex> vertexList;
	
	public GraphSearch()
	{
		vertexList = Startup.getGraphBuilder().getGraph();
	}
	public List <Vertex> findNodesBetweenPoints(Vertex startPosition,Vertex endingPosition)
	{
		return null;
	}
	
	
	
	
}
