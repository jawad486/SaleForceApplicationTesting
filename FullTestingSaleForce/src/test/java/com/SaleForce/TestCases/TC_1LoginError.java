package com.SaleForce.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_1LoginError {
	WebDriver driver;

	@Test
	public void loginError() {
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// user id
		driver.findElement(By.id("username")).sendKeys("jawadqureshi323@gmail.com");

//user password
		driver.findElement(By.id("password")).sendKeys("");
//clicking on login button
		driver.findElement(By.id("Login")).click();

		// geting text
		String text = driver.findElement(By.id("error")).getText();
		System.out.println(text);
		Assert.assertEquals("Please enter your password.", text, "Test case  1 passed");
		driver.quit();

	}

}
