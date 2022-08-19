package com.hometests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.config.TestBase;
import com.irris22akeyword.UIKeyword;
import com.pages.HomePage;

public class HomeTests extends TestBase
{
	HomePage home = PageFactory.initElements(UIKeyword.driver, HomePage.class);
	@Test
	public void click_toggle_button() 
	{
		home.click_toggle_below_768px();
	}
}
