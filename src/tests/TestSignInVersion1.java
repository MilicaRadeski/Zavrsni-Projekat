package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objects.Home;

public class TestSignInVersion1 {

	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\driver1\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void testNewUser() {
		driver.navigate().to(Home.URL);
		driver.manage().window().maximize();
		Home.newUser(driver);

		String actual = driver.getCurrentUrl();
		String expected = "https://www.humanity.com/wizard-setup2/";

		Assert.assertEquals(actual, expected);
	}
}