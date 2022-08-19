package com.config;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.irris22akeyword.UIKeyword;
import com.util.Environment;

public class TestBase 
{
	private static Logger log = Logger.getLogger(TestBase.class);
	@BeforeMethod
	public void setUp() throws Exception
	{
		String browserName = Environment.browser;
		if(browserName == null)
		{
			browserName = "Chrome";
			log.info("Set chrome as default browser");
		}
		if(browserName.isEmpty())
		{
			browserName = "Chrome";
			log.info("Set chrome as default browser");
		}
		UIKeyword.openBrowser(browserName);
		UIKeyword.launchUrl(Environment.url);
	}
	
	@AfterMethod
	public void closeUP()  throws Exception
	{	
		UIKeyword.closeBrowser();
	}
	
}
