package com.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class BaseConfig {
	
	public static String getConfig(String key) throws Throwable {
		Properties prop = new Properties();  // how to read a config file
		String path = "./Config.properties";
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
	//	System.out.println(prop.get(key));
		return prop.getProperty(key);
	//	return prop.keys().toString();
		
	}
	public static void main(String[] args) throws Throwable {
		BaseConfig.getConfig("URL");
		
	}

}
