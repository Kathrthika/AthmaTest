package com.athma.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.athma.qa.base.TestBase;
import com.athma.qa.pages.HomePage;
import com.athma.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void beforeTest() {
		initialize();
		
	}
	
	@Test
	public void Teting1() throws IOException, InterruptedException {
		System.out.println("testing1");
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("userName"), prop.getProperty("passWord"));
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	


}
