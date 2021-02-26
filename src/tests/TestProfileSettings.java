package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objects.Home;
import objects.ProfileSettings;

public class TestProfileSettings {
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
	public void changeOfFirstParameter() {
		ProfileSettings.changeOfFirstParameter(driver);
		String actual = driver.getCurrentUrl();
		String expected = "https://lego1.humanity.com/app/staff/edit/6082949/";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 1)
	public void changeOfSecondParameter() {
		ProfileSettings.changeOfSecondParameter(driver);
		String actual = driver.getCurrentUrl();
		String expected = "https://lego1.humanity.com/app/staff/edit/6082949/";
		Assert.assertEquals(actual, expected);
		driver.quit();
	}

}