package com.eBankingAutomationV1.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eBankingAutomationV1.pageObjects.LoginPage;
import com.eBankingAutomationV1.pageObjects.LogoutPage;
import com.eBankingAutomationV1.utilities.XLUtils;

public class TC_LoginDDT_001 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		LogoutPage lop = new LogoutPage(driver);
		Thread.sleep(1000);
		lp.setUsername(user);
		Thread.sleep(1000);
		lp.setPassword(pwd);
		Thread.sleep(1000);
		lp.clickLogin();

		if (isAlertPresent() == true) {
			Thread.sleep(1000);
			driver.switchTo().alert().accept(); // close invalid credentials alert
			driver.switchTo().defaultContent(); // switch to main page
			Assert.assertTrue(false);
		} else {

			Assert.assertTrue(true);
			Thread.sleep(1000);
			lop.clickLogout();
			driver.switchTo().alert().accept(); // close logout alert
			driver.switchTo().defaultContent();

		}
	}

	public boolean isAlertPresent() // user defined method to check if alert present or not
	{
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}

	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = "./src/test/java/com/eBankingAutomationV1/testData/Test Data.xlsx";
		int rowcount = XLUtils.getRowCount(path, "LoginData");
		int colcount = XLUtils.getCellCount(path, "LoginData", rowcount);

		String logindata[][] = new String[rowcount][colcount];

		for (int i = 1; i <= rowcount; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "LoginData", i, j);
			}
		}
		return logindata;
	}
}
