package com.jhomlala.spring.controller;

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
		Document document = loadDocument();
		loadSymbols(document);
		
	}
	
	private Document loadDocument()
  	{
  		ClassLoader classLoader = getClass().getClassLoader();
  		Document document = null;
  		File file = new File(classLoader.getResource("oznaczenia.xml").getFile());
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

	private void loadSymbols(Document document) 
	{
		NodeList nodeSymbolList = document.getElementsByTagName("symbol");
		for (int i=0;i<nodeSymbolList.getLength();i++)
		{
			Symbol symbol = getSymbolFromNode(nodeSymbolList.item(i),i);	
			symbolList.add(symbol);
		}		
	}
	
	
	
	private Symbol getSymbolFromNode(Node node,int index)
	{
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element currentElement = (Element) node;
			Symbol symbol = new Symbol();
			symbol.setSymbolID(index);
			symbol.setSymbolDescription(currentElement.getElementsByTagName("description").item(0).getTextContent());
			symbol.setSymbolShort(currentElement.getElementsByTagName("short").item(0).getTextContent());
			return symbol;
		}
		return null;
	}





	public List<Symbol> getSymbolList() {
		return symbolList;
	}

	
}
