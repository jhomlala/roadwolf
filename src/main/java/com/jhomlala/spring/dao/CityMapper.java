package com.jhomlala.spring.dao;

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
	  		

	    ClassLoader classLoader = getClass().getClassLoader();

		File file = new File(classLoader.getResource("miasta.xml").getFile());
		DocumentBuilder dBuilder;
		try {
			dBuilder = DocumentBuilderFactory.newInstance()
			        .newDocumentBuilder();Document 
			doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();

		
		
			NodeList nList = doc.getElementsByTagName("row");
			for (int i=0;i<nList.getLength();i++)
			{
				City city = new City();
				city.setCityID(i);
				NodeList nList2 = nList.item(i).getChildNodes();
				for (int k=0;k<nList2.getLength();k++)
				{
					if (nList2.item(k).getNodeName().equals("col"))
							{
								Element element = (Element) nList2.item(k);
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
				 
				city = getCityDistrictName(city);
				city = getCityVoivodeshipName(city);				
				cityList.add(city);
				
				
				
			}
				
			
	  	
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	}
	  	
	  	static int countz=0;
		private City getCityVoivodeshipName(City city) 
		{
			for (int w=0;w<voivodeshipList.size();w++)
			{
					if (city.getVoivodeshipID()==voivodeshipList.get(w).getID())
					{
						city.setVoivodeshipName(voivodeshipList.get(w).getName());
						countz++;
					}
			}

			return city;
		}
		private City getCityDistrictName(City city) {
			for (int w=0;w<voivodeshipList.size();w++)
			{
					if (city.getVoivodeshipID()==voivodeshipList.get(w).getID())
					{
						List <District> districtList = voivodeshipList.get(w).getDistrictList();
						for (int d=0;d<districtList.size();d++)
						{
							if (districtList.get(d).getID()==city.getDistrictID())
							{
								city.setDistrictName(districtList.get(d).getName());
								
							}
						}
					}
			}
			
			return city;
		}

		public List<City> getCityList() {
			return cityList;
		}

	
}