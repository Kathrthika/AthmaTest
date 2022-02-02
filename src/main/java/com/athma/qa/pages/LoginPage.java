package com.athma.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.athma.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(id = "username")
	WebElement userName;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(xpath = "//button[contains(text(),'Sign in')]")
	WebElement singIn_Btn;
	
	

	public LoginPage() throws IOException 
	{
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String un, String pwd) throws InterruptedException, IOException {
		userName.sendKeys(un);
		password.sendKeys(pwd);
		singIn_Btn.click();
		Thread.sleep(2000);
		return new HomePage();
	}
	
	
	

}
