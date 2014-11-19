package com.jhomlala.spring.controller;

import java.util.ArrayList;
import java.util.List;

import com.jhomlala.spring.model.City;
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
		
		List <Vertex> openVertexList = new ArrayList<Vertex>();
		List <Vertex> blackVertexList = new ArrayList<Vertex>();
		ArrayList <ArrayList <Node>> checkRoutes = new ArrayList<ArrayList <Node>>();
		/*if (checkDoVertexAreInSameDistrict(startPosition,endingPosition)) 
		{
			System.out.println("Ten sam powiat");
		}
		if (checkDoVertexAreInSaveVoivodeship(startPosition,endingPosition)) 
		{
			System.out.println("Te same wojewodztwo");
		}*/
		
		
		
		openVertexList.add(startPosition);
		List <Node> nodeList;
		List <Vertex> vertexFromNodeList;
		//openVertexList.addAll(vertexFromNodeList);
		//openVertexList = removeFromListElement(openVertexList,startPosition);
		//blackVertexList.add(startPosition);
		//System.out.println("=================");
		 //drawGraph(openVertexList);
		
		
		
		while (openVertexList.size() > 0 )
		{
			 nodeList = openVertexList.get(0).getNodeList();
			 vertexFromNodeList = getVertexFromNodeList(openVertexList.get(0),blackVertexList);
			 System.out.println("Vertexes from node:"+vertexFromNodeList.size());
			 for (int i=0;i<vertexFromNodeList.size();i++) System.out.print(vertexFromNodeList.get(i).getVertexID()+",");
			 for (Vertex vertex:vertexFromNodeList)
			 {
				 if (vertexIsNotInOpenVertexList(vertex,openVertexList))
				 {
					 openVertexList.add(vertex);
				 }
			 }
			 
			 
			 blackVertexList.add(openVertexList.get(0));
			 openVertexList = removeFromListElement(openVertexList,openVertexList.get(0));
			 System.out.println("=================");
			// System.out.println(openVertexList.size());
			 drawGraph(openVertexList);
			 
		
		}
		
		
		
		return null;
	}
	
	private void drawGraph(List <Vertex> vertexList) 
	{
		for (int i=0;i<vertexList.size();i++)
		{
			//System.out.println("VERTEX ID:"+vertexList.get(i).getVertexID());
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
	
	
	
	private List<Vertex> getVertexFromNodeList(Vertex parentVertex,List <Vertex> blackVertexList)
	{
		List<Node> nodeList = parentVertex.getNodeList();
		List <Vertex> childrenVertex = new ArrayList<Vertex>();
		for (int k=0;k<nodeList.size();k++)
		{
			for (int i=0;i<vertexList.size();i++)
			{
				if (nodeList.get(k).getConnectedToVertexID() == vertexList.get(i).getVertexID())
					if (vertexIsNotBlack(vertexList.get(i),blackVertexList))
						//if (vertexList.get(i).getVertexID()==parentVertex.getVertexID())
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
	
	private boolean vertexIsNotInOpenVertexList(Vertex vertex,List<Vertex> openVertexList)
	{
		for (int i=0;i<openVertexList.size();i++)
		{
			return (openVertexList.get(i).getVertexID()==vertex.getVertexID()) ? false : true ;
		}
		
		return false;
	}
	
	
	private boolean checkDoVertexAreInSameDistrict(Vertex vertex1,Vertex vertex2)
	{
		List <City> cityList = Startup.getCityMapper().getCityList();
		int districtIDOfVertex1=-1;
		int districtIDOfVertex2=0;
		
		for (City city:cityList)
		{
			if (city.getCityID()==vertex1.getVertexID())
			{
				districtIDOfVertex1 = city.getDistrictID();
			}
			if (city.getCityID() == vertex2.getVertexID())
			{
				districtIDOfVertex2 = city.getDistrictID();
			}
		}
		
		return (districtIDOfVertex1 == districtIDOfVertex2) ? true : false;

	}
	private boolean checkDoVertexAreInSaveVoivodeship(Vertex vertex1,Vertex vertex2)
	{
		List <City> cityList = Startup.getCityMapper().getCityList();
		int voivodeshipIDOfVertex1=-1;
		int voivodeshipIDOfVertex2=0;
		
		for (City city:cityList)
		{
			if (city.getCityID()==vertex1.getVertexID())
			{
				voivodeshipIDOfVertex1 = city.getVoivodeshipID();
			}
			if (city.getCityID() == vertex2.getVertexID())
			{
				voivodeshipIDOfVertex2 = city.getVoivodeshipID();
			}
		}
		
		return (voivodeshipIDOfVertex1 == voivodeshipIDOfVertex2) ? true : false;
	}
	
	
	
}
