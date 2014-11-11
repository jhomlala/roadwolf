package com.jhomlala.spring.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.jhomlala.spring.model.City;
import com.jhomlala.spring.model.District;
import com.jhomlala.spring.model.Voivodeship;

public class TerritorialMapper 
{
	List <Voivodeship> voivodeshipList;
	
	public TerritorialMapper ()
	{
		voivodeshipList = new ArrayList<Voivodeship>();
		
		loadTerritorial();
	}
	
	private void loadTerritorial()
	{
		boolean emptyPOW=false,emptyGMI=false;
		int savedID=0;
	    ClassLoader classLoader = getClass().getClassLoader();

		File file = new File(classLoader.getResource("podzial.xml").getFile());
		DocumentBuilder dBuilder;
		try {
			dBuilder = DocumentBuilderFactory.newInstance()
			        .newDocumentBuilder();Document 
			doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();

		
		
			NodeList nList = doc.getElementsByTagName("row");
			for (int i=0;i<nList.getLength();i++)
			{
				
				NodeList nList2 = nList.item(i).getChildNodes();
				emptyPOW=false;
				emptyGMI=false;
				for (int k=0;k<nList2.getLength();k++)
				{
					
					if (nList2.item(k).getNodeName().equals("col"))
							{
								
								Element element = (Element) nList2.item(k);
								if (element.getAttribute("name").equals("WOJ"))
								{
									savedID = Integer.valueOf(element.getTextContent());
									
								}
								
								
								if (element.getAttribute("name").equals("POW"))
								{
								
									if (element.getTextContent().length()==0)
									{
										emptyPOW=true;
									}
									
								}
								if (element.getAttribute("name").equals("GMI"))
								{
									if (element.getTextContent().length()==0)
									{
										emptyGMI=true;
									}
									
								}
								
								if (element.getAttribute("name").equals("NAZWA") && emptyPOW==true && emptyGMI==true)
								{
									List<District> districtList = new ArrayList<District>();
									voivodeshipList.add(new Voivodeship(savedID,element.getTextContent(),districtList));
								}
								
								
							}
				}
				
				
			
				
				
				
			}
			//voivodeshipList = removeCopyFromList(voivodeshipList);
			voivodeshipList = getDistrictListForVoivodeship(voivodeshipList);
			
			/*for (int z=0;z<voivodeshipList.size();z++)
			{
				System.out.println(voivodeshipList.get(z).getName() + ":" + voivodeshipList.get(z).getID());
				System.out.println(voivodeshipList.get(z).getDistrictList().size());
				for (int k=0;k<voivodeshipList.get(z).getDistrictList().size();k++)
				{
					System.out.println("->"+voivodeshipList.get(z).getDistrictList().get(k).getName());
				}
			
			}*/
			/*for (int u=0;u<voivodeshipList.size();u++)
			{
				if (voivodeshipList.get(u).getName().equals("LUBUSKIE"))
				{
					List <District> lista= voivodeshipList.get(u).getDistrictList();
					for (int x=0;x<lista.size();x++)
					{
						System.out.println(lista.get(x).getID()+":"+lista.get(x).getName());
					}
				}
			}*/
		
	  	
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private List<Voivodeship> getDistrictListForVoivodeship( List<Voivodeship> voivodeshipList2) {


	    ClassLoader classLoader = getClass().getClassLoader();
	    boolean emptyPOW,emptyGMI;
	    int savedWOJID=0;
	    int savedID=0;
		File file = new File(classLoader.getResource("podzial.xml").getFile());
		DocumentBuilder dBuilder;
		try {
			dBuilder = DocumentBuilderFactory.newInstance()
			        .newDocumentBuilder();Document 
			doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();

		
		
			NodeList nList = doc.getElementsByTagName("row");
			for (int i=0;i<nList.getLength();i++)
			{
				emptyGMI=false;
				emptyPOW=false;
				NodeList nList2 = nList.item(i).getChildNodes();

				for (int k=0;k<nList2.getLength();k++)
				{
					
					if (nList2.item(k).getNodeName().equals("col"))
							{
								
								Element element = (Element) nList2.item(k);
								if (element.getAttribute("name").equals("WOJ"))
								{
									savedWOJID = Integer.valueOf(element.getTextContent());
									
								}
								if (element.getAttribute("name").equals("POW"))
								{
									
									if (element.getTextContent().length()==0)
									{
										emptyPOW=true;
									}
									else
									{
										savedID = Integer.valueOf(element.getTextContent());
									}
									
								}
								if (element.getAttribute("name").equals("GMI"))
								{
									if (element.getTextContent().length()==0)
									{
										emptyGMI=true;
									}
									
								}
								if (element.getAttribute("name").equals("NAZWA") && emptyPOW==false && emptyGMI==true)
								{
									for (int w=0;w<voivodeshipList2.size();w++)
									{
										if (voivodeshipList2.get(w).getID() == savedWOJID)
										{
											List <District> districtList = voivodeshipList2.get(w).getDistrictList();
											District newDist = new District(savedID,element.getTextContent());
											districtList.add(newDist);
											voivodeshipList2.get(w).setDistrictList(districtList);
											
										}
									}
								}
								
								
								
							}
				}
				

			}
		
		
	  	
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return voivodeshipList2;
	}

	private List<Voivodeship> removeCopyFromList( List<Voivodeship> voivodeshipList2)
	{
		boolean isCopy=false;
		List <Voivodeship> newList = new ArrayList<Voivodeship>();
		for (int i=0;i<voivodeshipList2.size();i++)
		{
			for (int k=0;k<newList.size();k++)
			{
				if (voivodeshipList2.get(i).getID() == newList.get(k).getID())
				{
					isCopy = true;
				}
			}
			if (isCopy==false)
			{
				newList.add(voivodeshipList2.get(i));
			}
		}
		
		
		return newList;
	}

	public List<Voivodeship> getVoivodeshipList() {
		return voivodeshipList;
	}


	
	
}
