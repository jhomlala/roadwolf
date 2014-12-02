package com.jhomlala.spring.controller;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.jhomlala.spring.model.Node;
import com.jhomlala.spring.model.NodePair;
import com.jhomlala.spring.model.Vertex;



public class BFSSearch 
{
	private List <NodePair> edgeTo;
	private List <Vertex> vertexChecked;
	private Queue <Vertex> vertexesToCheck;
	private List <Vertex> digraph;
	private int sourceVertexID;
	private int finalVertexID;
	private Deque <Integer> finalPath;
	
	public BFSSearch(List <Vertex> vertexList,int sourceVertexID,int finalVertexID)
	{
		digraph = vertexList;
		this.sourceVertexID = sourceVertexID;
		this.finalVertexID = finalVertexID;
		
		edgeTo = new ArrayList<NodePair>();
		vertexChecked = new ArrayList <Vertex>();
		vertexesToCheck = new PriorityQueue <Vertex>();
		
		makeEdgeToMap();
		finalPath = findWayToFinalVertex();
		
	}
	
	private void makeEdgeToMap() 
	{
		Vertex sourceVertex = getVertexWithID(sourceVertexID);
		if (sourceVertex != null )
		{
			vertexesToCheck.offer(sourceVertex);
			edgeTo.add(new NodePair(sourceVertex.getVertexID(),sourceVertex.getVertexID()));
			while (!(vertexesToCheck.isEmpty()))
			{
				Vertex vertexRemoved = vertexesToCheck.remove();
				vertexChecked.add(vertexRemoved);
				List <Node> nodeList = vertexRemoved.getNodeList(); 
				for (Node node: nodeList) 
				{
					Vertex vertexToCheck = getVertexFromNode(node);
					if (!(isVertexChecked(vertexToCheck)))
					{
						vertexesToCheck.offer(vertexToCheck);
						edgeTo.add(new NodePair(vertexToCheck.getVertexID(),vertexRemoved.getVertexID()));
					}
				}
				
			}
		}
		else
		{
			
		}
	}

	private Deque <Integer> findWayToFinalVertex()
	{
		Deque<Integer> path = new ArrayDeque<Integer>();
		if (!(checkDoesPathExistsToVertex()))
		{
			return path;
		}
		else
		{
			int current = finalVertexID;
			path.push(current);
			while (current !=sourceVertexID)
			{
				for (NodePair np : edgeTo)
				{
					if (np.getFrom()==current)
					{
						current = np.getTo();
						path.push(current);
					}
				}
				
			}
		}
		return path;
	}

	
	
	private boolean checkDoesPathExistsToVertex()
	{
		for (NodePair np : edgeTo)
		{
			if (np.getFrom() == finalVertexID)
				return true;
		}
		return false;
	}

	private boolean isNotOnPathList(Deque<Integer> path, int current) 
	{
		Deque<Integer> pathCopy = path;
		while (!pathCopy.isEmpty())
		{
			int checkedID = pathCopy.remove();
			if (checkedID == current)
				return false;
		}

		return true;
	}

	private boolean isVertexChecked(Vertex vertex)
	{
		for (Vertex v: vertexChecked)
		{
			if (v.getVertexID()==vertex.getVertexID())
				return true;
		}
		return false;
	}
	
	
	private Vertex getVertexFromNode(Node node) 
	{
		return getVertexWithID(node.getConnectedToVertexID());
		
	}

	public Vertex getVertexWithID(int vertexID)
	{
		for (Vertex vertex : digraph)
		{
			if (vertex.getVertexID() == vertexID)
				return vertex;
		}

			return null;
	}
	
	public Deque <Integer> getPath()
	{
		return finalPath;
	}
	
	
}
