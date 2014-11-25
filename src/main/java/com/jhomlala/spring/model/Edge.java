package com.jhomlala.spring.model;

import java.util.ArrayList;
import java.util.List;

public class Edge 
{
	private int edgeID;
	private List <Integer> connectionList = new ArrayList<Integer>();
	public Edge(int edgeID)
	{
		this.edgeID = edgeID;
	}
	public int getEdgeID() {
		return edgeID;
	}


}
