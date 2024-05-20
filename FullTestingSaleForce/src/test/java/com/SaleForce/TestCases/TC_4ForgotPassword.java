package com.SaleForce.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_4ForgotPassword {
	WebDriver driver;

	@Test
	public void forgotPassword() {
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// entering user id
		driver.findElement(By.id("username")).sendKeys("jawadqureshi323@gmail.com");
		// clciking on forgot password link
		driver.findElement(By.linkText("Forgot Your Password?")).click();

		// validating user is not forgot password page
		WebElement forgotPage = driver.findElement(By.id("header"));
		if (forgotPage.isDisplayed()) {
			System.out.println("user is in forgot password page");
		} else {
			System.out.println("user is not in the forgot passwor page");
		}
		// entering user id in search box of forgot password
		driver.findElement(By.id("un")).sendKeys("jawadqureshi323@gmail.com");

		// clciking on the continu button
		driver.findElement(By.id("continue")).click();

		WebElement emailMessage = driver.findElement(By.xpath("//*[@class='mb12']"));
		if (emailMessage.isDisplayed()) {
			System.out.println("check your email text displayed Tc4 passsed");
		} else {
			System.out.println("check your email text not  displayed Tc4 failed");
		}
		driver.quit();
	}

}