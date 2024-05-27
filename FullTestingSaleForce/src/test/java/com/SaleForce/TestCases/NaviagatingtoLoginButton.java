package com.SaleForce.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NaviagatingtoLoginButton {
	
	WebDriver driver;
	@Test
	public void goingToLoginButton() {
		
		
	
		driver = new ChromeDriver();
		driver.get("https://www.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Login")).click();

}
}