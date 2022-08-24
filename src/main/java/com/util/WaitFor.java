package com.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.irris22akeyword.UIKeyword;
public class WaitFor 
{
	
//	explicitwait
	private static final RemoteWebDriver WebDriver = UIKeyword.driver;
	private static WebDriverWait wait = null;
	static
	{
		wait = new WebDriverWait(WebDriver , Duration.ofSeconds(60));
		wait.pollingEvery(Duration.ofMillis(5000));
		wait.withTimeout(Duration.ofSeconds(60));
		wait.withMessage("60 seconds are over. There is some performance issue");
	}
	
//	OR
	
//	private static FluentWait <WebDriver> wait = null;
//	static
//	{
//		wait = new FluentWait <WebDriver>(UIkeywords.driver);
//		wait.withTimeout(Duration.ofSeconds(30));
//		wait.pollingEvery(Duration.ofMillis(500));
//		wait.withMessage("Element not loaded");
//	}
	
	public static void elementToBePresent(String locatorType , String locatorValue) 
	{
		wait.ignoring(NoSuchElementException.class,ElementClickInterceptedException.class);
	}
	
	public static void elementToBePresent(WebElement element) 
	{
		wait.ignoring(NoSuchElementException.class,ElementClickInterceptedException.class);
//		wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
	}

	public static void time(int timeSec) 
	{
		long startTime = System.currentTimeMillis();
		long endTime = startTime + (timeSec*1000);
		while (startTime <= endTime)
		{
			startTime = System.currentTimeMillis();
		}
	}

	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
}
