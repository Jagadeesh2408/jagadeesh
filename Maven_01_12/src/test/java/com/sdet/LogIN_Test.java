package com.sdet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LogIN_Test {
	@Test
	public void logIntest() throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		Thread.sleep(2000);
		driver.get("https://demo.actitime.com/");
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys("admin");
		Thread.sleep(2000);
		driver.findElement(By.name("pwd")).sendKeys("manager");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		Thread.sleep(2000);
		
		
		Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
	}

}
