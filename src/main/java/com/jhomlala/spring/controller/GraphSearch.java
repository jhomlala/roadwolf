package com.jhomlala.spring.controller;

import java.util.ArrayList;
import java.util.List;

import com.jhomlala.spring.model.Node;
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
		//vertexList -- wszystkie vertexy
		List <Vertex> openVertexList = new ArrayList<Vertex>();
		List <Vertex> blackVertexList = new ArrayList<Vertex>();
		openVertexList.add(startPosition);
		List <Node> nodeList = startPosition.getNodeList();
		List <Vertex> vertexFromNodeList = getVertexFromNodeList(nodeList,blackVertexList);
		openVertexList.addAll(vertexFromNodeList);
		openVertexList = removeFromListElement(openVertexList,startPosition);
		blackVertexList.add(startPosition);
		while (openVertexList.size() > 1 )
		{
			nodeList = openVertexList.get(0).getNodeList();
			 vertexFromNodeList = getVertexFromNodeList(nodeList,blackVertexList);
			 openVertexList.addAll(vertexFromNodeList);
			 blackVertexList.add(openVertexList.get(0));
			 openVertexList = removeFromListElement(openVertexList,openVertexList.get(0));
			 System.out.println("=================");
			 System.out.println(openVertexList.size());
			 drawGraph(openVertexList);
			 
			 if (openVertexList.get(0).getVertexID()==endingPosition.getVertexID());
				{
					System.out.println("JEST KONCOWY!!!");
				}
				 
		}
		
		
		
		return null;
	}
	
	private void drawGraph(List <Vertex> vertexList) 
	{
		for (int i=0;i<vertexList.size();i++)
		{
			System.out.println("VERTEX ID:"+vertexList.get(i).getVertexID());
			List <Node> nodeList = vertexList.get(i).getNodeList();
			for (int k=0;k<nodeList.size();k++)
			{
				System.out.println("->NODE ID:"+nodeList.get(k).getNodeID()+", "+nodeList.get(k).getConnectedFromVertexID()+"->"+nodeList.get(k).getConnectedToVertexID());
			}
		}
		
	}
	private List <Vertex> removeFromListElement(List<Vertex> openVertexList, Vertex startPosition) 
	{
		for (int i=0;i<openVertexList.size();i++)
		{
			if (openVertexList.get(i).getVertexID() == startPosition.getVertexID())
			{
				openVertexList.remove(i);
			}
		}
		return openVertexList;
	}
	
	private List<Vertex> getVertexFromNodeList(List<Node> nodeList,List <Vertex> blackVertexList)
	{
		List <Vertex> childrenVertex = new ArrayList<Vertex>();
		for (int k=0;k<nodeList.size();k++)
		{
			for (int i=0;i<vertexList.size();i++)
			{
				if (nodeList.get(k).getConnectedToVertexID() == vertexList.get(i).getVertexID())
					if (vertexIsNotBlack(vertexList.get(i),blackVertexList))
						childrenVertex.add(vertexList.get(i));
			}
		}
		return childrenVertex;
	}
	private boolean vertexIsNotBlack(Vertex vertex,List <Vertex> blackVertexList) 
	{
		for (int i=0;i<blackVertexList.size();i++)
		{
			if (blackVertexList.get(i).getVertexID()==vertex.getVertexID())
			{
				return false;
			}
		}
		
		return true;
	}
	
	
	
	
}
