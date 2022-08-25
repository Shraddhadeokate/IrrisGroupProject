package com.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.config.TestBase;
import com.irris22akeyword.UIKeyword;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.SignupPage;

public class SignupTests extends TestBase
{
	HomePage home = PageFactory.initElements(UIKeyword.driver, HomePage.class);
	LoginPage login = PageFactory.initElements(UIKeyword.driver, LoginPage.class);
	SignupPage signup = PageFactory.initElements(UIKeyword.driver, SignupPage.class);
	@Test
	public void enter_mobile_number() 
	{
		home.clickLogin();
		login.clickSignup();
		signup.enter_mobile();
	}

}
