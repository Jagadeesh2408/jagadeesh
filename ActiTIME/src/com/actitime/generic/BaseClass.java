package com.actitime.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.actitime.pom.HomePage;
import com.actitime.pom.LoginPage;

public class BaseClass {
	static {
		System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
	}
	public static WebDriver driver;
	
	@BeforeClass
	public void openBrowser() {
		Reporter.log("openBrowser",true);
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	}
	@BeforeMethod
	public void login() throws IOException {
		Reporter.log("login",true);
		FileInputStream fis=new FileInputStream("./data/commondata.property");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pw = p.getProperty("password");
		driver.get(url);
		LoginPage l=new LoginPage(driver);
		l.setLogin(un,pw);
	}
	@AfterMethod
	public void logout() throws InterruptedException {
		Reporter.log("logout",true);
		Thread.sleep(20000);
		HomePage h=new HomePage(driver);
	    Thread.sleep(9000);
		h.setLogout();
		
	}
	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Reporter.log("closeBrowser",true);	
		Thread.sleep(9000);
		driver.close();
	}
}
