package com.homfleet.utilites;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader 
{
	static Properties pro;
	public PropertyReader(String filename) throws Exception
	{
		String filepath=".//Testdata//"+filename+".properties";
		FileInputStream inputstream=new FileInputStream(filepath);
		pro=new Properties();
		pro.load(inputstream);
	}
	public String Getdata(String key)
	{
		return pro.getProperty(key);
	}
	
	
}

