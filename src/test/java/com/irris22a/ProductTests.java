package com.irris22a;

import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.config.TestBase;
import com.irris22akeyword.UIKeyword;

public class ProductTests extends TestBase {

	@Test
	public void verifySearchResultForPoloMean() {
		UIKeyword.launchedUrl("https://www.myntra.com/");
		UIKeyword.enterText(By.xpath("//input[@placeholder='Search for products, brands and more']"), "polo men");
		UIKeyword.hitButton(KeyEvent.VK_ENTER);
		List<String> productTitles = UIKeyword.getTexts(By.xpath("//h3[@class='product-brand']"));
		for (String productTitle : productTitles) {
			Assert.assertTrue(productTitle.contains("Polo"), "productTitle doen't contains Polo" + productTitle);

		}
	}
}
