package com.evi.domain;

import java.util.Properties;

public class ApplicationProperties {
	private Properties properties = new Properties();
	private String [] params = {"location", "url","username","password"};
	private String [] arguments;
	/*
	 * Set up the application properties for the testsuite
	 */
	public ApplicationProperties(String [] args){
		arguments = args;
	}
	/*
	 * getter method to return the value from the properties map
	 */
	
	public Properties setup(){
		System.out.println(arguments.length);
		
		for(int i=0;i<arguments.length;i++){
			properties.setProperty(params[i],arguments[i]);
		}
		System.out.println(properties);
		return properties;
	}
	
	public String getProperty(String key){	
		return properties.getProperty(key);
	}
	
	
}
