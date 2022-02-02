package com.athma.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.athma.qa.base.TestBase;

public class NewRegistrationPage extends TestBase {
	
	@FindBy(xpath = "//span[contains(text(),'Patient Registration')]")
	WebElement newregistrationtitle;
	
	@FindBy(xpath = "//ng-select[@name='patientPrefix']")
	WebElement prefix_drop_down;
	
	@FindBy(xpath = "(//span[@class='ng-option-label'])[1]")
	WebElement prefix_mr;
	
	@FindBy(xpath = "//input[@name='firstName']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@name='age']")
	WebElement patient_age;
	
	@FindBy(xpath = "//button[contains(text(),'Register')]")
	WebElement register_btn;
	
	

	public NewRegistrationPage() throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public String newregistrationgetTitletest() {
		commonWaits(newregistrationtitle);
		return newregistrationtitle.getText();
	}
	
	public void selectprefix() throws InterruptedException {
		//shortSleep();
		Thread.sleep(4000);
		commonWaits(prefix_drop_down);
		prefix_drop_down.click();
		//Thread.sleep(2000);
		//commonWaits(prefix_mr);
		commonActions(prefix_mr);
		//prefix_mr.click();
		// prefix_mr.getText();
		
	}
	public void EnterPatientDetails(String firstname,String ptage) {
		commonWaits(firstName);
		firstName.sendKeys(firstname);
		commonWaits(patient_age);
		patient_age.sendKeys(ptage);
	}
	
	public void clickRegisterbutton() {
		commonWaits(register_btn);
		register_btn.click();
	}
	
	
	

}
