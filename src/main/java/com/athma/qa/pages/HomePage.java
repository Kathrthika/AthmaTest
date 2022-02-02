package com.athma.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.athma.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	
	
	@FindBy(xpath = "//span[@class='navbar-title']")
	WebElement homepageathmaTitle;
	
	@FindBy(xpath = "//span[@class='sb-icon icon-athmamodules athma-ambulatory-module-icon']")
	WebElement amb_main_menu;
	
	@FindBy(xpath = "//a[@href='https://sqa.narayanahealth.org:7076/patient-registration']")
	WebElement submenu_patient_registration;
	

	public HomePage() throws IOException
	{		
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	
	public String homepagetitleTest() {
		return driver.getTitle();
		
	}
	
	public String getathmahomepageTitle() {
		return homepageathmaTitle.getText();
	}
	
	public void clickonambMainmenu() {
		commonWaits(amb_main_menu);
		amb_main_menu.click();
		
	}
	
	public PatientRgistrationsPage clickonPatientregistrationsubmenu() throws IOException{
		commonWaits(submenu_patient_registration);
		 submenu_patient_registration.click();
		 return new PatientRgistrationsPage();
	}
	

}
