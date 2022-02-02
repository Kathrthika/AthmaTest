package com.athma.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.athma.qa.base.TestBase;

public class PatientRgistrationsPage extends TestBase {
	
	
	@FindBy(xpath = "//button[contains(text(),' Create New ')]")
	WebElement createNew_btn;
	
	

	public PatientRgistrationsPage() throws IOException {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public NewRegistrationPage clickon_createNew() throws IOException {
		commonWaits(createNew_btn);
		createNew_btn.click();
		return new NewRegistrationPage();
	}

}
