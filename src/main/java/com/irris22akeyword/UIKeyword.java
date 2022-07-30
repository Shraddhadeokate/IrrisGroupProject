package com.irris22akeyword;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bouncycastle.crypto.prng.BasicEntropySourceProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UIKeyword {
	public static RemoteWebDriver driver;

	public static void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("crome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		System.out.println(browserName + "Browser launched Succesfuly");
	}

	public static void launchedUrl(String url) {
		driver.get(url);
		System.out.println("url is launched" + url);
	}

	public static void closeBrowser() {
		driver.close();
		System.out.println("Brower closed succesfully");
	}

	public static void switchtoWindow(String byTitle) {
		String parentwindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if (driver.switchTo().window(window).getTitle().equalsIgnoreCase(byTitle)) {
				System.out.println("switched to window" + byTitle);
				break;
			}
		}
	}

	public static void enterText(By element, String text) {
		driver.findElement(element).sendKeys(text);
	}

	public static void hitButton(int keyCode) {
		Robot robo = null;
		try {
			robo = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robo.keyPress(keyCode);
	}

	public static List<String> getTexts(By element) {
		List<WebElement> elements = driver.findElements(element);
		List<String> texts = new ArrayList<String>();
		for (WebElement elmnt : elements) {
			texts.add(elmnt.getText());

		}
		return texts;
	}
}
