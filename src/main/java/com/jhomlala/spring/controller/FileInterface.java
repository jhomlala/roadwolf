package com.jhomlala.spring.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileInterface {
	
	void SaveLastLogID(String content)
	{
	try {
		File file = new File("config.txt");

		// if file doesnt exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(content);
		bw.close();


	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	
	int LoadLastLogID() throws IOException
	{
		
		String everything = "";
		BufferedReader br = new BufferedReader(new FileReader("config.txt"));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append(System.lineSeparator());
	            line = br.readLine();
	        }
	         everything = sb.toString();
	    } finally {
	        br.close();
	        
	    }
	    return strToInt(everything);
	    
	}	
	
	
	
	static public Integer strToInt(String str) {
	    Integer result = null;
	    if (null == str || 0 == str.length()) {
	        return null;
	    }
	    try{
	        result = Integer.parseInt(str);
	    } catch (NumberFormatException e) {
	        String negativeMode = "";
	        if(str.indexOf('-') != -1)
	            negativeMode = "-";
	        str = str.replaceAll("-", "" );
	        if (str.indexOf('.') != -1) {
	            str = str.substring(0, str.indexOf('.'));
	            if (str.length() == 0) {
	                return (Integer)0;
	            }
	        }
	        String strNum = str.replaceAll("[^\\d]", "" );
	        if (0 == strNum.length()) {
	            return null;
	        }
	        result = Integer.parseInt(negativeMode + strNum);
	    }
	    return result;
	}
}

