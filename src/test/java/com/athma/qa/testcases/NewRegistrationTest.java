package com.athma.qa.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import com.athma.qa.base.TestBase;
import com.athma.qa.pages.HomePage;
import com.athma.qa.pages.LoginPage;
import com.athma.qa.pages.NewRegistrationPage;
import com.athma.qa.pages.PatientRgistrationsPage;
import com.athma.qa.utils.GeneralUtils;

public class NewRegistrationTest extends TestBase {
	
	Logger logger = Logger.getLogger(NewRegistrationTest.class.getName());
	
	LoginPage loginpage;
	HomePage homepage;
	PatientRgistrationsPage patientrgistrationspage;
	NewRegistrationPage newregistrationpage;

	public NewRegistrationTest() throws IOException
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException 
	{
		initialize();
		loginpage = new LoginPage();
		logger.info("Login to the application");
		homepage = loginpage.login(prop.getProperty("userName"), prop.getProperty("passWord"));
		logger.info("Clicking Amb main menu");
		homepage.clickonambMainmenu();
		logger.info("clicking patient registration sub menu");
		patientrgistrationspage = homepage.clickonPatientregistrationsubmenu();
		newregistrationpage = patientrgistrationspage.clickon_createNew();
	}
	
	@Test(enabled = false)
	public void newregistrationTitletets() throws IOException {
		Assert.assertEquals(newregistrationpage.newregistrationgetTitletest(), "Patient Registration", "Actual title : "+newregistrationpage.newregistrationgetTitletest());
	}
	
	@SuppressWarnings("deprecation")
	@Test(enabled = false)
	public void printprefix() throws InterruptedException {
		newregistrationpage.selectprefix();
		driver.manage().timeouts().pageLoadTimeout(GeneralUtils.common_wait, TimeUnit.SECONDS);
		
	}
	
	@Test(invocationCount = 1, enabled = false)
	public void singleregisterpatientTest() throws InterruptedException {
		logger.info("selecting prefix");
		newregistrationpage.selectprefix();
		logger.info("Entering patient details");
		newregistrationpage.EnterPatientDetails("Karthik", "30");
		logger.info("Clicking register button");
		newregistrationpage.clickRegisterbutton();
		logger.info(driver.findElement(By.xpath(".//pre")).getText());
		String sucessmessge = driver.findElement(By.xpath(".//pre")).getText();
		boolean success = sucessmessge.contains("successfully");
		Assert.assertEquals(success, true,"patient not registered"+sucessmessge );
		
		//Thread.sleep(10000);
		//System.out.println("print toast message : "+driver.switchTo().alert().getText());
		
	}
	
	@DataProvider	
	public Object[][] getpatientdata() throws IOException{
	    Object[][] data = getPatientdetails("patient");		
		return data;
	}
	
	@Test(dataProvider = "getpatientdata" , enabled = true)
	public void multipleregisterpatientTest(String firstname,String patientage) throws InterruptedException {
		logger.info("selecting prefix");
		newregistrationpage.selectprefix();
		logger.info("Entering patient details");
		newregistrationpage.EnterPatientDetails(firstname, patientage);
		logger.info("Clicking register button");
		newregistrationpage.clickRegisterbutton();
		logger.info(driver.findElement(By.xpath(".//pre")).getText());
		String sucessmessge = driver.findElement(By.xpath(".//pre")).getText();
		boolean success = sucessmessge.contains("successfully");
		Assert.assertEquals(success, true,"patient not registered"+sucessmessge );
		
		//Thread.sleep(10000);
		//System.out.println("print toast message : "+driver.switchTo().alert().getText());
		
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
    
}
