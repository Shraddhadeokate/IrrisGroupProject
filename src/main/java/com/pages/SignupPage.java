package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.irris22akeyword.UIKeyword;
import com.util.WaitFor;

public class SignupPage 
{
//	@FindBy (css="div.iframe-loader+iframe")
//	@FindBy (css="div.modal-body>iframe")
//	public WebElement frame1;
	@FindBy (css = "input[placeholder*='Enter your mobile number']")
	public WebElement mobile;
	@FindBy (css = "a.sign-up-txt")
	public WebElement login;

	public void enter_mobile() 
	{
		PageFactory.initElements(UIKeyword.driver, this);
//		WaitFor.elementToBePresent(frame1);
//		UIKeyword.driver.switchTo().frame(frame1);
		WaitFor.elementToBePresent(mobile);
		mobile.sendKeys("9876543210");
		login.click();
	}

}
