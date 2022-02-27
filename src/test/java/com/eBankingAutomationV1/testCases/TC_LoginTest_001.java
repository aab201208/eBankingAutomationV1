package com.eBankingAutomationV1.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eBankingAutomationV1.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	LoginPage lp;

	@Test
	public void loginTest() throws IOException {
		lp = new LoginPage(driver);
		lp.setUsername(userName);
		lp.setPassword(password);
		lp.clickLogin();

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
		} else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
		}
	}
}
