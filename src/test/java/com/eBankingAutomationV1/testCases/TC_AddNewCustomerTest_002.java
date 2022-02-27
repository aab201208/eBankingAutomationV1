package com.eBankingAutomationV1.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eBankingAutomationV1.pageObjects.AddNewCustomer;
import com.eBankingAutomationV1.pageObjects.LoginPage;

public class TC_AddNewCustomerTest_002 extends BaseClass {

	LoginPage lp;
	AddNewCustomer anc;

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		lp = new LoginPage(driver);
		lp.setUsername(userName);
		lp.setPassword(password);
		lp.clickLogin();
		Thread.sleep(1000);
		anc = new AddNewCustomer(driver);
		anc.clickToAddNewCustomer();
		anc.customerName("Adam");
		anc.gender("male");
		anc.custdob("11", "02", "1995");
		Thread.sleep(1000);
		anc.custaddress("ABC India");
		anc.custcity("Mumbai");
		anc.custstate("Maha");
		anc.custpin("111100");
		anc.custtele("1111222233");
		anc.custemail(randomString() + "@gmail.com");
		anc.custpassword("ab1ab");
		anc.custsubmit();
		Thread.sleep(1000);

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (res == true) {
			Assert.assertTrue(true);
		} else {
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}

}
