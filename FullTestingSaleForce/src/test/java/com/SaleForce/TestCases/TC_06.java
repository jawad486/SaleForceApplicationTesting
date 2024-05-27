package com.SaleForce.TestCases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TC_06 {

	WebDriver driver;

	@Test
	public void testCase_06() {
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

		// clicking on MY Profile link
		driver.findElement(By.linkText("My Profile")).click();

		// clicking on edit button
		driver.findElement(By.xpath("(//img[@title='Edit Profile'])[1]")).click();

		// validating the edit pop window

		String newPopWindow = driver.getWindowHandle();
		driver.switchTo().window(newPopWindow);

		// get the contact text from the pop up window
		String textOfThePOpWind = driver.findElement(By.id("contactInfoTitle")).getText();
		System.out.println("This is the current window handle::" + textOfThePOpWind);
		WebElement textDisplayed = driver.findElement(By.id("contactInfoTitle"));
		if (textDisplayed.isDisplayed()) {
			System.out.println("the contact window pop is displayed");
		} else {
			System.out.println("the contact window POP is not displayed");
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// switching to frame

		driver.switchTo().frame(3);

		// clicking on About button
		driver.findElement(By.xpath("//li[@id='aboutTab']//a[1]")).click();

		// entering the last name
		driver.findElement(By.id("lastName")).sendKeys("Qureshii");

		// clciking on save all button
		driver.findElement(By.xpath("//input[contains(@class,'zen-btn zen-primaryBtn')]")).click();

		// switch back from iframe and window pop up
		driver.switchTo().defaultContent();

		// validating the change last name
		WebElement lastNameChange = driver.findElement(By.id("tailBreadcrumbNode"));
		if (lastNameChange.isDisplayed()) {
			System.out.println("last name change is displayed");
		} else {
			System.out.println("last name change is not displayed");
		}

		// clicking on the post link
		driver.findElement(By.xpath("//span[text()='Post']")).click();

		// switching to iframe inside the post link
		driver.switchTo().frame(1);

		// clicking on text box and sending text
		WebElement textBox = driver.findElement(By.xpath("//body[@contenteditable='true']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(textBox));

		textBox.click();
		textBox.sendKeys("Doaba");

		// switching back frome the frame
		driver.switchTo().defaultContent();

		// clicking of the share button
		driver.findElement(By.id("publishersharebutton")).click();

	}
}
