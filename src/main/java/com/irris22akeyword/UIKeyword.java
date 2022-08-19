package com.irris22akeyword;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class UIKeyword 
{
	public static RemoteWebDriver driver;
	public static void openBrowser(String browserName) 
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		System.out.println(browserName+" is launched");
		
	}
	
	public static void launchUrl(String url) 
	{
		driver.get(url);
		System.out.println("Url launched :"+url);
//		driver.manage().window().maximize();    // maximize the browser window
	}
	
	public static void closeBrowser() 
	{
		driver.close();
		System.out.println("Browser closed");
	}
	
	/**
	 * 
	 * @param element
	 * @param text
	 */
	@Deprecated
	public static void enterText(By element, String text) 
	{
		driver.findElement(element).sendKeys(text);
	}
	
	public static void enterText(WebElement element, String text) 
	{
		element.sendKeys(text);
	}

	public static void enterText(String locatorType , String locatorValue , String text) 
	{
		getWebElement(locatorType, locatorValue).sendKeys(text);
	}
	
	public static void hitButton(int keycode) 
	{
		Robot robo = null;
		try
		{
			robo = new Robot();
		}
		catch(AWTException e)
		{
			e.printStackTrace();
		}
		robo.keyPress(keycode);
		robo.keyRelease(keycode);
	}
	
	public static WebElement getWebElement(String locatorType , String locatorValue)
	{
		WebElement element = null ;
		if(locatorType.equalsIgnoreCase("xpath"))
			{
				element = driver.findElement(By.xpath(locatorValue));
			}
			else if(locatorType.equalsIgnoreCase("id"))
			{
				element = driver.findElement(By.id(locatorValue));
			}
			else if(locatorType.equalsIgnoreCase("css"))
			{
				element = driver.findElement(By.cssSelector(locatorValue));
			}
			else if(locatorType.equalsIgnoreCase("linkText"))
			{
				element = driver.findElement(By.linkText(locatorValue));
			}
			else if(locatorType.equalsIgnoreCase("partialLinkText"))
			{
				element = driver.findElement(By.partialLinkText(locatorValue));
			}
			else if(locatorType.equalsIgnoreCase("class"))
			{
				element = driver.findElement(By.className(locatorValue));
			}
			else if(locatorType.equalsIgnoreCase("name"))
			{
				element = driver.findElement(By.name(locatorValue));
			}
			else
			{
				System.err.println("Invalid locator type: "+locatorValue);
			}
		return element;
	}
	
	public static List<WebElement> getWebElements(String locatorType , String locatorValue)
	{
		List<WebElement> elements = new ArrayList<WebElement> ();
		if(locatorType.equalsIgnoreCase("xpath"))
			{
				elements = driver.findElements(By.xpath(locatorValue));
			}
			else if(locatorType.equalsIgnoreCase("id"))
			{
				elements = driver.findElements(By.id(locatorValue));
			}
			else if(locatorType.equalsIgnoreCase("css"))
			{
				elements = driver.findElements(By.cssSelector(locatorValue));
			}
			else if(locatorType.equalsIgnoreCase("linkText"))
			{
				elements = driver.findElements(By.linkText(locatorValue));
			}
			else if(locatorType.equalsIgnoreCase("partialLinkText"))
			{
				elements = driver.findElements(By.partialLinkText(locatorValue));
			}
			else if(locatorType.equalsIgnoreCase("class"))
			{
				elements = driver.findElements(By.className(locatorValue));
			}
			else if(locatorType.equalsIgnoreCase("name"))
			{
				elements = driver.findElements(By.name(locatorValue));
			}
			else
			{
				System.err.println("Invalid locator type: "+locatorValue);
			}
		return elements;
	}

	@Deprecated
	public static void click(By xpath) 
	{
		driver.findElement(xpath).click();
	}
	
//	@Deprecated
	public static void click(WebElement element) 
	{
		element.click();
	}
	
	public static void click(String locatorType , String locatorValue)
	{	
		getWebElement(locatorType, locatorValue).click();
	}
	
	@Deprecated
	public static void mousemove(By xpath) 
	{
		Actions action = new Actions(UIKeyword.driver);
		action.moveToElement(driver.findElement(xpath)).build().perform();
	}
	
	public static void mousemove(WebElement element) 
	{
		Actions action = new Actions(UIKeyword.driver);		
		action.moveToElement(element).build().perform();
	}
	
	public static void mouseMove(String locatorType , String locatorValue) 
	{
		Actions action = new Actions(UIKeyword.driver);
		action.moveToElement(getWebElement(locatorType , locatorValue)).build().perform();
	}
	
	public static List<String> getText(String locatorType , String locatorValue) 
	{
		List<WebElement> elements = getWebElements(locatorType , locatorValue);
		List<String> texts = new ArrayList<String>();
		for(WebElement ele : elements)
		{
			texts.add(ele.getText());
		}
		return texts;
	}


	public static void moveInFrame(String locatorType, String locatorValue) 
	{
		driver.switchTo().frame(getWebElement(locatorType , locatorValue));
	}	

	
	public static void switchToWindow(String byTitle) 
	{
//		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
//		String title = driver.getTitle();
		for(String window : windows)
		{
			if(driver.switchTo().window(window).getTitle().equals(byTitle))
			{
				System.out.println("Switched on window: "+byTitle);
				break;
			}
		}
	}

}
