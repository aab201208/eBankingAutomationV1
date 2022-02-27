package com.eBankingAutomationV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {

	WebDriver localdriver;

	public AddNewCustomer(WebDriver remotedriver) {
		localdriver = remotedriver;
		PageFactory.initElements(remotedriver, this);
	}

	@FindBy(how = How.XPATH, using = "//*/a[@href='addcustomerpage.php']")
	@CacheLookup
	WebElement lnkNewCustomer;

	@FindBy(how = How.XPATH, using = "//*/input[@name='name']")
	@CacheLookup
	WebElement txtcustomername;

	@FindBy(how = How.XPATH, using = "//*/td/input[@name='rad1']")
	@CacheLookup
	WebElement rdgender;

	@FindBy(how = How.XPATH, using = "//*/input[@name='dob']")
	@CacheLookup
	WebElement txtdob;

	@FindBy(how = How.XPATH, using = "//*/textarea[@name='addr']")
	@CacheLookup
	WebElement txtaddress;

	@FindBy(how = How.XPATH, using = "//*/input[@name='city']")
	@CacheLookup
	WebElement txtcity;

	@FindBy(how = How.XPATH, using = "//*/input[@name='state']")
	@CacheLookup
	WebElement txtstate;

	@FindBy(how = How.XPATH, using = "//*/input[@name='pinno']")
	@CacheLookup
	WebElement txtpinno;

	@FindBy(how = How.XPATH, using = "//*/input[@name='telephoneno']")
	@CacheLookup
	WebElement txttelephoneno;

	@FindBy(how = How.XPATH, using = "//*/input[@name='emailid']")
	@CacheLookup
	WebElement txtemail;

	@FindBy(how = How.XPATH, using = "//*/input[@name='password']")
	@CacheLookup
	WebElement txtpassword;

	@FindBy(how = How.XPATH, using = "//*/input[@name='sub']")
	@CacheLookup
	WebElement btnsub;

	// Action methods
	public void clickToAddNewCustomer() {
		lnkNewCustomer.click();
	}

	public void customerName(String cname) {
		txtcustomername.sendKeys(cname);
	}

	public void gender(String cgender) {
		rdgender.click();
	}

	public void custdob(String dd, String mm, String yy) {
		txtdob.sendKeys(dd);
		txtdob.sendKeys(mm);
		txtdob.sendKeys(yy);

	}

	public void custaddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}

	public void custcity(String ccity) {
		txtcity.sendKeys(ccity);
	}

	public void custstate(String cstate) {
		txtstate.sendKeys(cstate);
	}

	public void custpin(String cpin) {
		txtpinno.sendKeys(String.valueOf(cpin));
	}

	public void custtele(String ctele) {
		txttelephoneno.sendKeys(ctele);
	}

	public void custemail(String cemail) {
		txtemail.sendKeys(cemail);
	}

	public void custpassword(String cpassword) {
		txtpassword.sendKeys(cpassword);
	}

	public void custsubmit() {
		btnsub.click();
	}

}
