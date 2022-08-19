package com.config;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.irris22akeyword.UIKeyword;
import com.util.Environment;

public class TestBase 
{
	@BeforeMethod
	public void setUp() throws Exception
	{
		String browserName = Environment.browser;
		if(browserName == null)
		{
			browserName = "Chrome";
			System.out.println("Set chrome as default browser");
		}
		if(browserName.isEmpty())
		{
			browserName = "Chrome";
			System.out.println("Set chrome as default browser");
		}
		UIKeyword.openBrowser(browserName);
		UIKeyword.launchUrl(Environment.url);
	}
	
	@AfterMethod
	public void closeUP()  throws Exception
	{	
//		UIKeyword.closeBrowser();
	}
	
}
