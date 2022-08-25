package com.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.config.TestBase;
import com.irris22akeyword.UIKeyword;
import com.pages.HomePage;

public class HomeTests extends TestBase
{
	HomePage home = PageFactory.initElements(UIKeyword.driver, HomePage.class);
	LoginTests login = new LoginTests();
	@Test
	public void click_toggle_button() 
	{
		home.click_on_toggle();
	}
	@Test
	public void open_jee_main() 
	{
		home.openJeeMain();
	}
	@Test
	public void open_percentage_calculator() 
	{
		home.percentageCalculator();
	}
	@Test
	public void click_on_search() 
	{
		home.clickSearch();
	}
	
	@Test
	public void click_on_login()
	{
		login.click_on_signup();
	}
	
	
}
