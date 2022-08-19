package com.pages;

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
	
	public void ckeckDimension(WebElement element)
	{
		Dimension size = UIKeyword.driver.manage().window().getSize();
		int width = size.getWidth();
		if(width<=767)
		{	
			PageFactory.initElements(UIKeyword.driver, this);	
			WebElement myElement = new WebDriverWait(UIKeyword.driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(open_menu));
			((JavascriptExecutor) UIKeyword.driver).executeScript("arguments[0].scrollIntoView();", myElement);
			UIKeyword.click(open_menu); 		//			open_menu.click();       //we can also use in this way
			WaitFor.time(1);
			UIKeyword.click(element);
		}
		if(width>=768)
		{
			PageFactory.initElements(UIKeyword.driver, this);	
			UIKeyword.mousemove(element);
		}
	}

	public void click_toggle_below_768px() 
	{
		UIKeyword.driver.manage().window().setSize(new Dimension(765, 800));
		HomePage home = new HomePage();
		PageFactory.initElements(UIKeyword.driver, this);
		WaitFor.time(1);
		home.ckeckDimension(studyMaterial);
		WaitFor.elementToBeClickable(studyMaterial);
//		UIKeyword.mouseMove(repository.getLocator("classes")[0], repository.getLocator("classes")[1]);
//		UIKeyword.click(repository.getLocator("class_1_to_3")[0], repository.getLocator("class_1_to_3")[1]);
		
	}

}
