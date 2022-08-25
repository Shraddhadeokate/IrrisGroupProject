package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.irris22akeyword.UIKeyword;
import com.util.WaitFor;

public class LoginPage 
{
	@FindBy (css = "div.modal-body>iframe")
	public WebElement frame;
	@FindBy (css = "p.text-muted.dont-have-txt>a.sign-up-txt")
	public WebElement signup;

	public void clickSignup() 
	{
		PageFactory.initElements(UIKeyword.driver, this);
		WaitFor.elementToBePresent(frame);
		UIKeyword.driver.switchTo().frame(frame);
		WaitFor.elementToBePresent(signup);
		signup.click();	
		WaitFor.time(1);
	}
	

}
