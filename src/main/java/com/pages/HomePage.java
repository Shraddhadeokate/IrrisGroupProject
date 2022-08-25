package com.pages;

import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.irris22akeyword.UIKeyword;
import com.util.PropertiesUtil;
import com.util.WaitFor;

public class HomePage 
{
	PropertiesUtil repository = new PropertiesUtil();
	@CacheLookup
	@FindBy (css = "button.navbar-toggle.collapsed>span")
	public WebElement open_menu;
	@FindBy (xpath = "//a[contains(text(),'Study Materials')]")
	public WebElement studyMaterial;
	@FindBy (xpath = "//li[@class='sub']/child::a[@href='/jee/']")
	public WebElement jee;
	@FindBy (xpath = "//li[@class='sub']/child::a[@href='/jee/']/following-sibling::ul/child::li//a[@href='/jee/jee-main/']")
	public WebElement jeeMain;
	@FindBy (xpath = "//li[@class='sub']/child::a[@href='/calculators/']")
	public WebElement calculators;
	@FindBy (xpath = "//li[@class='sub']/child::a[@href='/calculators/']/following-sibling::ul/child::li//a[@href='/basic-calculators/']")
	public WebElement basic_calc;
	@FindBy (xpath = "//a[contains(text(),'Percentage Calculator')]")
	public WebElement percentage;
	@FindBy (css = "li.primary-search>div.search-bar")
	public WebElement search;
	@FindBy (css = "li.primary-search>div.search-bar input[placeholder='Type your search']")
	public WebElement searchBox;
	@FindBy (xpath ="//li[@class='no-separator nav-spacing']")
	public WebElement login; 
	
	public void ckeckDimension(WebElement element)
	{
		Dimension size = UIKeyword.driver.manage().window().getSize();
		int width = size.getWidth();
		if(width<=783)
		{	
			PageFactory.initElements(UIKeyword.driver, this);
//			MoveTargetOutOfBoundsException => below two lines are solution for that 
			WebElement myElement = new WebDriverWait(UIKeyword.driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(open_menu));
			((JavascriptExecutor) UIKeyword.driver).executeScript("arguments[0].scrollIntoView();", myElement);

//			UIKeyword.click(open_menu); 		
			open_menu.click();       //we can also use in this way
			WaitFor.time(1);
			UIKeyword.click(element);
		}
		if(width>=784)
		{
			PageFactory.initElements(UIKeyword.driver, this);	
			WaitFor.elementToBePresent(element);
			UIKeyword.mousemove(element);
		}
	}
	
	public void click_toggle(WebElement element) 
	{
		HomePage home = new HomePage();
		PageFactory.initElements(UIKeyword.driver, this);
		home.ckeckDimension(element);
	}
	public void click_on_toggle() 
	{
		UIKeyword.driver.manage().window().setSize(new Dimension(700, 800));
		HomePage home = new HomePage();
		PageFactory.initElements(UIKeyword.driver, this);
		WaitFor.time(1);
		home.click_toggle(studyMaterial);
	}

	public void openJeeMain()
	{
		HomePage home = new HomePage();
		PageFactory.initElements(UIKeyword.driver, this);
		WaitFor.time(1);
		home.click_toggle(studyMaterial);	
		UIKeyword.mousemove(jee);
		jeeMain.click();
	}

	public void percentageCalculator() 
	{
		HomePage home = new HomePage();
		PageFactory.initElements(UIKeyword.driver, this);
		WaitFor.time(1);
		home.click_toggle(studyMaterial);
		UIKeyword.mousemove(calculators);
		UIKeyword.mousemove(basic_calc);
		percentage.click();
	}

	public void clickSearch() 
	{
		PageFactory.initElements(UIKeyword.driver, this);
		search.click();
		searchBox.sendKeys("akshay");
		UIKeyword.hitButton(KeyEvent.VK_ENTER);
	}

	public void clickLogin() 
	{
		PageFactory.initElements(UIKeyword.driver, this);
		login.click();
	}

}
