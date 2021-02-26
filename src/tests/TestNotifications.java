package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objects.Home;
import objects.Notifications;
import objects.Settings;

public class TestNotifications {

	private static WebDriver driver;

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

	@Test
	public void testSettings() throws Exception {
		driver.navigate().to(Settings.URL1);
		driver.manage().window().maximize();

		Notifications.disableNotifications(driver);

		String current = driver.getCurrentUrl();
		String expected = "https://lego1.humanity.com/app/staff/notifications/";

		Assert.assertEquals(current, expected);
		driver.quit();
	}

}
