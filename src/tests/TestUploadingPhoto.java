package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objects.FirmHumanity;
import objects.Home;
import objects.UploadingPhoto;

public class TestUploadingPhoto {

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

	@Test(priority = 0)
	public void addEmployees() {
		driver.navigate().to("https://lego1.humanity.com/app/staff/list/load/true/");
		FirmHumanity.addEmployee(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 1)
	public void testUploadingPhoto() throws Exception {

		driver.navigate().to("https://lego1.humanity.com/app/staff/list/load/true/");
		driver.manage().window().maximize();

		UploadingPhoto.uploadingPhoto(driver);

		// String current = driver.getCurrentUrl();
		// String expected = UploadingPhoto.EMPLOYEE_URL;

		// Assert.assertEquals(current, expected);

		// driver.quit();
	}

}
