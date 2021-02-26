package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objects.Home;

public class TestLogIn {

		private static WebDriver driver;
		@BeforeClass
		public void createDriver() {
			System.setProperty("webdriver.chrome.driver", "C:\\driver1\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		@Test
		public void logIn() {
			driver.navigate().to(Home.URL);
			driver.manage().window().maximize();

			Home.logIn(driver);

			String actual = driver.getCurrentUrl();
			String expected = "https://www.humanity.com/app/";
			Assert.assertEquals(actual, expected);
		}
	}
