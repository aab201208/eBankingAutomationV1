package com.eBankingAutomationV1.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.eBankingAutomationV1.utilities.ReadConfig;

public class BaseClass {
	ReadConfig read = new ReadConfig();
	public String baseURL = read.getApplicationURL();
	public String userName = read.getUsername();
	public String password = read.getPassword();
	public static WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", read.getChromePath());
			driver = new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", read.getEdgePath());
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(baseURL);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String name) throws IOException
	{
		TakesScreenshot shot = (TakesScreenshot) driver;
		File src = shot.getScreenshotAs(OutputType.FILE);
		File tgt = new File(System.getProperty("user.dir")+"/Screenshots/" + name+ ".png");
		FileUtils.copyFile(src,tgt);
		System.out.println("Screenshot taken");
	}
	
	public String randomString()
	{
		return RandomStringUtils.randomAlphabetic(10);
	}
	
	public String randomNumber()
	{
		return RandomStringUtils.randomNumeric(10);
	}
}
