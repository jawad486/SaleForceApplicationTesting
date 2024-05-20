package com.SaleForce.TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_5 {
	WebDriver driver;

	@Test
	public void testCase_5() {
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// user id
		driver.findElement(By.id("username")).sendKeys("jawadqureshi323@gmail.com");
		// user passwrod
		driver.findElement(By.id("password")).sendKeys("saleforce1");

		
		// clicking on login button
		driver.findElement(By.id("Login")).click();

		// validating the title
		String exceptedtitle = driver.getTitle();
		String actualTitle = "Home Page ~ Salesforce - Developer Edition";
		if (exceptedtitle.equals(actualTitle)) {
			System.out.println("User in The home page ");
		} else {
			System.out.println("User is not in the home page");
		}

		// user dropdown
		driver.findElement(By.id("userNav-arrow")).click();

		// print all the options of dropdown
		List<WebElement> options = driver.findElements(By.id("userNavMenu"));

		for (int i = 0; i < options.size(); i++) {
			System.out.println(options.get(i).getText());
		}

	}
}