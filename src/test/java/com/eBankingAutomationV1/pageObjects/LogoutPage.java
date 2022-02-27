package com.eBankingAutomationV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	WebDriver localdriver;

	public LogoutPage(WebDriver remotedriver) {
		localdriver = remotedriver;
		PageFactory.initElements(remotedriver, this);
	}

	@FindBy(xpath = "//*/a[@href='Logout.php']")
	WebElement logout;

	public void clickLogout() {
		logout.click();
	}
}
