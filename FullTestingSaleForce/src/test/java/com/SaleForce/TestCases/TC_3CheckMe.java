package com.SaleForce.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_3CheckMe {

	WebDriver driver;

	@Test
	public void checkMe() {
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// user id
		driver.findElement(By.id("username")).sendKeys("jawadqureshi323@gmail.com");
		// user passwrod
		driver.findElement(By.id("password")).sendKeys("saleforce1");

		// check box remember me
		driver.findElement(By.id("rememberUn")).click();
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

		// clciking on logout button
		driver.findElement(By.linkText("Logout")).click();

		WebElement userName = driver.findElement(By.id("idcard-identity"));
		if (userName.isDisplayed()) {
			System.out.println("name displayed >===Testcase 3 is passed");
		} else {
			System.out.println(" name is not displayed>===Testcase 3 is failed");
		}
		driver.quit();

	}
}
