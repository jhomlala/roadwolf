package com.jhomlala.spring.model;

import java.util.ArrayList;
import java.util.List;

public class Digraph 
{
	private int edges;
	private int vertexes;
	private List <Edge> adjacencyList;
	
	public Digraph(int vertexes)
	{
		this.vertexes = vertexes;
		this.edges = 0;
		this.adjacencyList = new ArrayList<Edge>();
	}
	
	private void addEdge(Edge edge)
	{
		
	}
	
}
