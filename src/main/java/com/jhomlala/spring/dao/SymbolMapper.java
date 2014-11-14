package com.jhomlala.spring.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.jhomlala.spring.model.Symbol;

public class SymbolMapper 
{
	List <Symbol> symbolList ;
	public SymbolMapper()
	{
		symbolList = new ArrayList<Symbol>();
		loadSymbols();

	}
	
	
	
	
	
	private void loadSymbols() 
	{
		 ClassLoader classLoader = getClass().getClassLoader();

			File file = new File(classLoader.getResource("oznaczenia.xml").getFile()); 
			DocumentBuilder dBuilder;
			try {
				dBuilder = DocumentBuilderFactory.newInstance()
				        .newDocumentBuilder();Document 
				doc = dBuilder.parse(file);
				doc.getDocumentElement().normalize();

			
			
				NodeList nList = doc.getElementsByTagName("symbol");
				for (int i=0;i<nList.getLength();i++)
				{
					Node currentNode = nList.item(i);
					if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
						Element currentElement = (Element) currentNode;
						Symbol symbol = new Symbol();
						symbol.setSymbolID(i);
						symbol.setSymbolDescription(currentElement.getElementsByTagName("description").item(0).getTextContent());
						symbol.setSymbolShort(currentElement.getElementsByTagName("short").item(0).getTextContent());
						symbolList.add(symbol);
					}
					
				}
			} 
			catch (ParserConfigurationException | SAXException | IOException e) 
			{

				e.printStackTrace();
			}
			
	}
	
	
	
	public List<Symbol> getSymbolList() {
		return symbolList;
	}

	
}
