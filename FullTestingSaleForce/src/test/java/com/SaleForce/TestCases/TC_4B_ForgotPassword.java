package com.SaleForce.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_4B_ForgotPassword {
	WebDriver driver;

	@Test
	public void invalidLoginCredentials() {
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// user id
		driver.findElement(By.id("username")).sendKeys("j123");

		// password
		driver.findElement(By.id("password")).sendKeys("32323");
		// clciking on login button
		driver.findElement(By.id("Login")).click();

		// validating the error is displayed or not
		WebElement errorContAdmis = driver.findElement(By.id("error"));
		if (errorContAdmis.isDisplayed()) {
			System.out.println(
					"Please check your username and password. If you still can't log in, contact your Salesforce administrator.|| displayed Tc4-B passsed");
		} else {
			System.out.println(
					"Please check your username and password. If you still can't log in, contact your Salesforce administrator.|| not displayed Tc4 failed");
		}

		driver.quit();
	}
}