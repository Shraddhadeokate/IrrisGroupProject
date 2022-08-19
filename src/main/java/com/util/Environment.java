package com.util;

public class Environment 
{
	private static String filePath = "/src/main/resources/Environment.properties";
	public static String url;
	public static String browser;
	
	static
	{
		PropertiesUtil prop = new PropertiesUtil();
		String baseDir = System.getProperty("user.dir");
		url = prop.getValue(baseDir+filePath, "app_url");
		browser = prop.getValue(baseDir+filePath, "browser_name");
	}
}
