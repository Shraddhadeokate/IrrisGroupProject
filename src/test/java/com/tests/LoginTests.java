package com.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.config.TestBase;
import com.irris22akeyword.UIKeyword;
import com.pages.HomePage;
import com.pages.LoginPage;

public class LoginTests extends TestBase
{
	HomePage home = PageFactory.initElements(UIKeyword.driver, HomePage.class);
	LoginPage login = PageFactory.initElements(UIKeyword.driver, LoginPage.class);
	@Test
	public void click_on_signup() 
	{
		home.clickLogin();
		login.clickSignup();
	}

}
