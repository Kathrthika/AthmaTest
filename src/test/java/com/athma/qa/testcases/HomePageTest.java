package com.athma.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.athma.qa.base.TestBase;
import com.athma.qa.pages.HomePage;
import com.athma.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	  LoginPage loginpage;
	  HomePage homepage;
	  
	
	
     
	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialize();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("userName"), prop.getProperty("passWord"));
		Thread.sleep(5000);
		
	}
	@Test
	public void homepageTitleTest() throws InterruptedException {
		String title = homepage.getathmahomepageTitle();
		System.out.println("print title : "+title);
		org.testng.Assert.assertEquals(title, "Athma","actual title : "+title);
		
		
	}
	@Test
	public void titleTest() {
		org.testng.Assert.assertEquals(homepage.homepagetitleTest(), "Dashboard","Actual : "+homepage.homepagetitleTest());
	}	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
