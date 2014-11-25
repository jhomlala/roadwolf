package com.jhomlala.spring.model;

public class Node 
{
	private int nodeID; //courseID

	private int connectedToVertexID;
	
	public Node()
	{
		
	}
	
	
	public int getNodeID() {
		return nodeID;
	}
	public void setNodeID(int nodeID) {
		this.nodeID = nodeID;
	}
	
	public int getConnectedToVertexID() {
		return connectedToVertexID;
	}
	public void setConnectedToVertexID(int connectedToVertexID) {
		this.connectedToVertexID = connectedToVertexID;
	}


	
}


