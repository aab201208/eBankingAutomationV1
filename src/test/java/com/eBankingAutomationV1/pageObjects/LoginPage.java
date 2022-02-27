package com.eBankingAutomationV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver localdriver;

	public LoginPage(WebDriver remotedriver) {
		localdriver = remotedriver;
		PageFactory.initElements(remotedriver, this);
	}

	@FindBy(xpath = "//input[@name='uid']")
	@CacheLookup
	WebElement userName;

	@FindBy(xpath = "//input[@name='password']")
	@CacheLookup
	WebElement password;

	@FindBy(xpath = "//input[@name='btnLogin']")
	@CacheLookup
	WebElement button;

	public void setUsername(String uname) {
		userName.sendKeys(uname);
	}

	public void setPassword(String passwd) {
		password.sendKeys(passwd);
	}

	public void clickLogin() {
		button.click();
	}
}
