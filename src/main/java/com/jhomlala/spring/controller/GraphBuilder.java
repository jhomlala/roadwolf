package com.jhomlala.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.jhomlala.spring.config.MvcConfiguration;
import com.jhomlala.spring.dao.BusStopDAOImpl;
import com.jhomlala.spring.dao.CourseDAOImpl;
import com.jhomlala.spring.model.City;
import com.jhomlala.spring.model.Course;
import com.jhomlala.spring.model.Node;
import com.jhomlala.spring.model.Symbol;
import com.jhomlala.spring.model.Vertex;

public class GraphBuilder
{
	
	private List <Symbol> symbolList;
	private List <Course> courseList;
	private List <City> cityList;
	private List <Vertex> vertexList;
	public GraphBuilder()
	{
		buildCourseList();
		buildGraph();
		//drawGraph();
	}
	
	
	
	
	
	public List<Vertex> getGraph()
	{
		return vertexList;
	}
	
	private void drawGraph() 
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




	public void buildGraph()
	{
		vertexList = new ArrayList<Vertex>();
		for (int i=0;i<courseList.size();i++)
		{
			if (!(vertexExists(courseList.get(i).getArrivalCityID())))
			{
				createVertex(courseList.get(i).getArrivalCityID());
			}
			if (!(vertexExists(courseList.get(i).getDepartureCityID())))
			{
				createVertex(courseList.get(i).getDepartureCityID());
			}
			addNodes(courseList.get(i));
			
			
		}
		
	}
	
	
	
	private void addNodes(Course course)
	{
		Node node = new Node();
		node.setNodeID(course.getCourseID());
		node.setConnectedFromVertexID(course.getDepartureCityID());
		node.setConnectedToVertexID(course.getArrivalCityID());
		
		for (int i=0;i<vertexList.size();i++)
		{
			if (vertexList.get(i).getVertexID() == course.getArrivalCityID())
			{
				vertexList.get(i).getNodeList().add(node);
			}
			if (vertexList.get(i).getVertexID() == course.getDepartureCityID())
			{
				vertexList.get(i).getNodeList().add(node);
			}
		}
		
	}

	private void createVertex(int cityID) 
	{
		Vertex vertex = new Vertex();
		vertex.setVertexID(cityID);
		vertex.setNodeList(new ArrayList<Node>());
		vertexList.add(vertex);
		System.out.println("Build vertex id:"+cityID);
		
	}

	

	
	private boolean vertexExists(int cityID) 
	{
		for (int i=0;i<vertexList.size();i++)
		{
			if (vertexList.get(i).getVertexID() == cityID)
			{
				return true;
			}
		}
		return false;
	}

	public void buildCourseList()
	{
		MvcConfiguration config = new MvcConfiguration();
		DataSource dataForDAO = config.getDataSource();
		CourseDAOImpl CourseIMPL = new CourseDAOImpl(dataForDAO);
		
		courseList = CourseIMPL.listCourses();
		cityList = Startup.getCityMapper().getCityList();
		symbolList = Startup.getSymbolMapper().getSymbolList();
		
		courseList = CourseController.loadCityNames(courseList,cityList);
		courseList = CourseController.loadSymbols(courseList,symbolList);
		BusStopDAOImpl StopIMPL = new BusStopDAOImpl(dataForDAO);
		courseList = CourseController.loadStopList(courseList,StopIMPL);
		courseList = CourseController.loadStopListCityNames(courseList,cityList);
		
	
	}
	
	public Vertex getVertexWithID(int id)
	{
		for (int i=0;i<vertexList.size();i++)
		{
			if (vertexList.get(i).getVertexID()==id)
				return vertexList.get(i);
		}
		return null;
	}
	
}
