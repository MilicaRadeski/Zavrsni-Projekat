package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import objects.Home;
import objects.FirmHumanity;

public class TestFirmHumanity {
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
	public void dashboardOption() {

		FirmHumanity.dashboardClick(driver);
		String actual = driver.getCurrentUrl();
		String expected = "https://lego1.humanity.com/app/dashboard/";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 1)
	public void shiftPlanningOption() {
		FirmHumanity.shiftplanningClick(driver);
		String actual = driver.getCurrentUrl();
		String expected = "https://lego1.humanity.com/app/schedule/employee/week/overview/overview/26%2c1%2c2021/";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 2)
	public void timeClockOption() {
		FirmHumanity.timeclockClick(driver);
		String actual = driver.getCurrentUrl();
		String expected = "https://lego1.humanity.com/app/timeclock/";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 3)
	public void leaveOption() {
		FirmHumanity.leaveClick(driver);
		String actual = driver.getCurrentUrl();
		String expected = "https://lego1.humanity.com/app/requests/vacation/";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 4)
	public void trainingOption() {
		FirmHumanity.trainingClick(driver);
		String actual = driver.getCurrentUrl();
		String expected = "https://lego1.humanity.com/app/training/";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 5)
	public void staffOption() {
		FirmHumanity.staffClick(driver);
		String actual = driver.getCurrentUrl();
		String expected = "https://lego1.humanity.com/app/staff/list/load/true/";
	}

	@Test(priority = 6)
	public void availabilityOption() {
		FirmHumanity.availabilityClick(driver);
		String actual = driver.getCurrentUrl();
		String expected = "https://lego1.humanity.com/fe/availability/#/requests/week/2021-02-21/1";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 7)
	public void payrollOption() {
		FirmHumanity.payrollClick(driver);
		String actual = driver.getCurrentUrl();
		String expected = "https://lego1.humanity.com/app/payroll/scheduled-hours/";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 8)
	public void reportsOption() {
		FirmHumanity.reportsClick(driver);
		String actual = driver.getCurrentUrl();
		String expected = "https://lego1.humanity.com/app/reports/dashboard/";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 9)
	public void addEmployees() {
		driver.navigate().to("https://lego1.humanity.com/app/staff/list/load/true/");
		FirmHumanity.addEmployee(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 10)
	public void changeName() {
		driver.navigate().to("https://lego1.humanity.com/app/staff/list/load/true/");
		FirmHumanity.changeName(driver);
		String actual = driver.getCurrentUrl();
		String expected = "https://lego1.humanity.com/app/staff/list/load/true/";
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 10)
	public void uploadPhoto() {
		driver.navigate().to("https://lego1.humanity.com/app/staff/list/load/true/");
		FirmHumanity.uploadPhoto(driver);
		String actual = driver.getCurrentUrl();
		String expected = "https://lego1.humanity.com/app/staff/list/load/true/";
		Assert.assertEquals(actual, expected);
		driver.quit();

	}

}
