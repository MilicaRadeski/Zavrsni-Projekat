package tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objects.ExcelApachePOI;
import objects.FirmHumanity;
import objects.Home;

public class TestExcelApachePOI {

	public static WebDriver driver;

	@BeforeClass
	public void createDriver() {

		System.setProperty("webdriver.chrome.driver", "C:\\driver1\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeClass
	public void loggingIn() {
		driver.navigate().to(Home.URL);
		driver.manage().window().maximize();

		Home.logIn(driver);
	}

	@Test(priority = 0)
	public void addNewEmployees() {
		driver.navigate().to("https://lego1.humanity.com/app/staff/list/load/true/");

		ExcelApachePOI.fiveEmployeesInput(driver);

	}

}
