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
	
	private List <Course> courseList;
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



	public void buildGraph()
	{
		vertexList = new ArrayList<Vertex>();
		for (Course course: courseList)
		{
			createVertex(course.getArrivalCityID());
			createVertex(course.getDepartureCityID());
			addNodes(course);

		}
		
	}
	
	
	
	private void addNodes(Course course)
	{
		Node node = new Node();
		node.setNodeID(course.getCourseID());
		node.setConnectedToVertexID(course.getArrivalCityID());
		addNodeToVertex(node,course.getDepartureCityID());
	}

	private void addNodeToVertex(Node node, int vertexID) 
	{
		for (Vertex vertex: vertexList)
		{
			if (vertex.getVertexID() == vertexID)
				vertex.getNodeList().add(node);
		}
		
	}

	private void createVertex(int cityID) 
	{
		if (!(vertexExists(cityID)))
		{
			Vertex vertex = new Vertex();
			vertex.setVertexID(cityID);
			vertex.setNodeList(new ArrayList<Node>());
			vertexList.add(vertex);
		}
		
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
		CourseController courseController = new CourseController();
		courseList = courseController.getCourseList();
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
