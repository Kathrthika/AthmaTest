package com.athma.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.athma.qa.base.TestBase;
import com.athma.qa.pages.HomePage;
import com.athma.qa.pages.LoginPage;
import com.athma.qa.pages.PatientRgistrationsPage;

public class PatientRegistrationsTest extends TestBase {
	  LoginPage loginpage;
	  HomePage homepage;
	  PatientRgistrationsPage patientrgistrationspage;
	

	public PatientRegistrationsTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialize();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("userName"), prop.getProperty("passWord"));
		homepage.clickonambMainmenu();
		patientrgistrationspage = homepage.clickonPatientregistrationsubmenu();
		shortSleep();
		
	}
	
	@Test
	public void tittleTest() {
		String title = patientrgistrationspage.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Patient Registrations", "Print title : "+title);
		System.out.println("testing");
		System.out.println("testing");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
