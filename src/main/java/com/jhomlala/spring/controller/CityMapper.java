package com.jhomlala.spring.controller;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.jhomlala.spring.model.City;
import com.jhomlala.spring.model.District;
import com.jhomlala.spring.model.Voivodeship;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CityMapper {

		List <City> cityList = new ArrayList<City>();
		List <Voivodeship> voivodeshipList;
		
	  	public CityMapper(List <Voivodeship> voivodeshipListReceived) 
	  	{
	  		voivodeshipList = voivodeshipListReceived;
	  		loadCities();
	  	}
	  	
	  		
	  	private void loadCities()
	  	{
	  		
	  		Document document = loadDocument();
			NodeList nodeList = document.getElementsByTagName("row");
			loadCitiesFromNodeList(nodeList); 	
	  	}
	  	
	  	private Document loadDocument()
	  	{
	  		ClassLoader classLoader = getClass().getClassLoader();
	  		Document document = null;
	  		File file = new File(classLoader.getResource("miasta.xml").getFile());
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
	  	
	  	private void loadCitiesFromNodeList(NodeList nodeList)
	  	{
	  		for (int i=0;i<nodeList.getLength();i++)
			{
	  			NodeList childrenNodeList = nodeList.item(i).getChildNodes();
				City city = new City();
				city.setCityID(i);
				city = loadCityDataFromChildrenNodeList(city,childrenNodeList);				 
				city = getCityDistrictName(city);
				city = getCityVoivodeshipName(city);
				city = renameVoivodeshipNames(city);
				cityList.add(city);
			}	
			
		}
	  	

		private City loadCityDataFromChildrenNodeList(City city, NodeList childrenNodeList) 
		{
			for (int k=0;k<childrenNodeList.getLength();k++)
			{
				if (childrenNodeList.item(k).getNodeName().equals("col"))
						{
							Element element = (Element) childrenNodeList.item(k);
							if (element.getAttribute("name").equals("NAZWA"))
							{
								city.setCityName(element.getTextContent());
							}
							if (element.getAttribute("name").equals("WOJ"))
							{
								city.setVoivodeshipID(Integer.valueOf(element.getTextContent()));
							}
							if (element.getAttribute("name").equals("POW"))
							{
								city.setDistrictID(Integer.valueOf(element.getTextContent()));
							}
						}
			}
			return city;
		}


		private City renameVoivodeshipNames(City city) 
	  	{
			String voivodeshipName = city.getVoivodeshipName().toLowerCase();
			city.setVoivodeshipName(Character.toString(voivodeshipName.charAt(0)).toUpperCase()+voivodeshipName.substring(1));
			return city;
		}
		private City getCityVoivodeshipName(City city) 
		{
			for (Voivodeship voivodeship: voivodeshipList)
			{
					if (city.getVoivodeshipID()==voivodeship.getID())
						city.setVoivodeshipName(voivodeship.getName());
			}
			
			return city;
		}
		private City getCityDistrictName(City city)
		{
			for (Voivodeship voivodeship: voivodeshipList)
			{
					if (city.getVoivodeshipID()==voivodeship.getID())
					{
						List <District> districtList = voivodeship.getDistrictList();
						for (District district: districtList)
						{
							if (district.getID()==city.getDistrictID())
								city.setDistrictName(district.getName());
						}
					}
			}
			
			return city;
		}

		public List<City> getCityList() {
			return cityList;
		}

	
}