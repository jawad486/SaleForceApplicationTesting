package com.SaleForce.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_2Login {
	WebDriver driver;

	@Test
	public void login() {
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// user id
		driver.findElement(By.id("username")).sendKeys("jawadqureshi323@gmail.com");

		// user password
		driver.findElement(By.id("password")).sendKeys("saleforce1");
		// clicking on login button
		driver.findElement(By.id("Login")).click();

		// validing the the title page
		String exceptedtitle = driver.getTitle();
		String actualTitle = "Home Page ~ Salesforce - Developer Edition";
		if (exceptedtitle.equals(actualTitle)) {
			System.out.println("test case 2 passed");
		} else {
			System.out.println("test case 2 failed");
		}

		//driver.quit();

	}
}
