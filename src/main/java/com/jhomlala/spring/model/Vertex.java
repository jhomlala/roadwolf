package com.jhomlala.spring.model;

import java.util.List;

public class Vertex implements Comparable
{
	private int vertexID ; // its CityID
	private List <Node> nodeList; // its Course List - list of all courses from cityID
	
	public Vertex()
	{
		
	}

	public int getVertexID() {
		return vertexID;
	}

	public void setVertexID(int vertexID) {
		this.vertexID = vertexID;
	}

	public List<Node> getNodeList() {
		return nodeList;
	}

	public void setNodeList(List<Node> nodeList) {
		this.nodeList = nodeList;
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
