package tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objects.Home;

public class TestAboutUs {
	private static WebDriver driver;
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\driver1\\chromedriver.exe");
		driver = new ChromeDriver();
	}

@Test(priority = 0)
public void testAboutUs() throws Exception {
	driver.navigate().to(Home.URL);
	driver.manage().window().fullscreen();
	Home.aboutUs(driver);
	
	TakesScreenshot ts = (TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source,  new File("./Screenshots/aboutUs.png"));
	

	
	String actual = driver.getCurrentUrl();
	String expected = Home.ABOUT_US_URL;
	Assert.assertEquals(actual, expected);
	driver.quit();
}
}