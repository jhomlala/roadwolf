package com.jhomlala.spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.jhomlala.spring.model.City;
import com.jhomlala.spring.model.District;
import com.jhomlala.spring.model.Voivodeship;

public class TerritorialMapper 
{
	List <Voivodeship> voivodeshipList;
	Document document;
	public TerritorialMapper ()
	{
		voivodeshipList = new ArrayList<Voivodeship>();
		document = loadDocument();
		loadTerritorial(document);
	}
	
	private Document loadDocument()
  	{
  		ClassLoader classLoader = getClass().getClassLoader();
  		Document document = null;
  		File file = new File(classLoader.getResource("podzial.xml").getFile());
		try 
		{
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			document = documentBuilder.parse(file);
			document.getDocumentElement().normalize();
		} 
		catch (ParserConfigurationException e) 
		{
			System.err.println("Error: ParserConfigurationException.");
		} 
		catch (SAXException e) 
		{
			System.err.println("Error: SAXException.");
		} 
		catch (IOException e) 
		{
			System.err.println("Error: IOException.");
		}
		return document;
  	}


	private void loadTerritorial(Document doc)
	{
	    NodeList nodeList = doc.getElementsByTagName("row");
		for (int i=0;i<nodeList.getLength();i++)
		{
			loadTerritorialElements(nodeList.item(i));
		}
		getDistrictListForVoivodeship(doc);
	}

	private void loadTerritorialElements(Node node) 
	{
		NodeList nodeChildrenList = node.getChildNodes();
		boolean emptyPowiat = false; // checking does current Element is not Powiat element
		boolean emptyGmina = false; // checking does current Element is not Gmina element
		int savedID = 0; // saved voivodeship id from iteration over element
		
		for (int k=0;k<nodeChildrenList.getLength();k++)
		{
			if (nodeChildrenList.item(k).getNodeName().equals("col"))
			{
				Element currentElement = (Element) nodeChildrenList.item(k);
				if (currentElement.getAttribute("name").equals("WOJ"))
					savedID =  Integer.valueOf(currentElement.getTextContent());
				if (currentElement.getAttribute("name").equals("POW"))	
					if (currentElement.getTextContent().length()==0)
						emptyPowiat=true;
				if (currentElement.getAttribute("name").equals("GMI"))
					if (currentElement.getTextContent().length()==0)
						emptyGmina=true;
				if (emptyPowiat==true && emptyGmina == true)
					addVoivodeshipToVoivodeshipList(currentElement,savedID);
				}
			}
		}


	private int voivodeshipGetID(Element currentElement) {
		int savedID;
		if (currentElement.getAttribute("name").equals("WOJ"))
			 savedID =  Integer.valueOf(currentElement.getTextContent());
		else
			savedID = 0;
		
		return savedID;
	}

	private void addVoivodeshipToVoivodeshipList(Element currentElement,int savedID) 
	{
		if (currentElement.getAttribute("name").equals("NAZWA") )
		{
			List<District> districtList = new ArrayList<District>();
			voivodeshipList.add(new Voivodeship(savedID,currentElement.getTextContent(),districtList));
		}
		
	}

	private void getDistrictListForVoivodeship(Document document) 
	{
		NodeList nodeList = document.getElementsByTagName("row");
		for (int i=0;i<nodeList.getLength();i++)
		{
		    loadDistrict(nodeList.item(i));
		}
	}

	private void loadDistrict(Node node)
	{
		boolean emptyGmina=false;
		boolean emptyPowiat=false;
	    int savedVoivodeshipID=0;
	    int savedDistrictID=0;
		NodeList nodeChildrenList = node.getChildNodes();
		
		for (int k=0;k<nodeChildrenList.getLength();k++)
		{
			if (nodeChildrenList.item(k).getNodeName().equals("col"))
			{
				Element element = (Element) nodeChildrenList.item(k);
				if (element.getAttribute("name").equals("WOJ"))
					savedVoivodeshipID = Integer.valueOf(element.getTextContent());
				if (element.getAttribute("name").equals("POW"))
				{
					if (element.getTextContent().length()==0)
						emptyPowiat=true;
					else
						savedDistrictID = Integer.valueOf(element.getTextContent());				
				}
				if (element.getAttribute("name").equals("GMI"))
					if (element.getTextContent().length()==0)
						emptyGmina=true;
				if (element.getAttribute("name").equals("NAZWA") && emptyPowiat==false && emptyGmina==true)
				{
					addDistrictToVoivodeship(savedVoivodeshipID,savedDistrictID,element.getTextContent());
					
				}			
			}
		}
	}
	

	private void addDistrictToVoivodeship(int savedVoivodeshipID, int savedDistrictID, String textContent) 
	{
		for (int w=0;w<voivodeshipList.size();w++)
		{
			if (voivodeshipList.get(w).getID() == savedVoivodeshipID)
			{
				
				List <District> districtList = voivodeshipList.get(w).getDistrictList();
				District newDist = new District(savedDistrictID,textContent);
				districtList.add(newDist);
				voivodeshipList.get(w).setDistrictList(districtList);
							
			}
		}
		
	}

	public List<Voivodeship> getVoivodeshipList() {
		return voivodeshipList;
	}


	
	
}
