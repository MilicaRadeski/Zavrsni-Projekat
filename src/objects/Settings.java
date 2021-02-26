package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Settings {

	public static final String URL = "https://www.humanity.com/";
	public static final String URL1 = "https://lego1.humanity.com/app/dashboard/";
	public static final String SETTINGS_URL = "https://lego1.humanity.com/app/admin/settings/";
	public static final String SETTINGS_XPATH = "//*[@id=\"sn_admin\"]/span";
	public static final String LANGUAGE_BOX_XPATH = "//*[@id=\"adminSettingsForm\"]/div[1]/table/tbody/tr[3]/td[2]/select";
	public static final String SAVE_SETTINGS_BUTTON_XPATH = "//*[@id=\"_save_settings_button\"]";
	public static final String SETTINGS_BUTTON_XPATH = "//*[@id=\"sn_admin\"]/span";
	public static final String REFRESH_BUTTON_XPATH = "//*[@id=\"adminSettingsForm\"]/div[1]/table/tbody/tr[3]/td[1]/label/a";

	public static void setLanguage(WebDriver driver) {

		//driver.get(URL1);
		driver.findElement(By.xpath(SETTINGS_XPATH)).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath(LANGUAGE_BOX_XPATH)).click();
		driver.findElement(By.xpath(LANGUAGE_BOX_XPATH)).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath(LANGUAGE_BOX_XPATH)).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath(LANGUAGE_BOX_XPATH)).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath(LANGUAGE_BOX_XPATH)).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath(LANGUAGE_BOX_XPATH)).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath(LANGUAGE_BOX_XPATH)).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath(LANGUAGE_BOX_XPATH)).sendKeys(Keys.ARROW_DOWN);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath(LANGUAGE_BOX_XPATH)).sendKeys(Keys.RETURN);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath(SAVE_SETTINGS_BUTTON_XPATH)).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(SETTINGS_BUTTON_XPATH)).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath(REFRESH_BUTTON_XPATH)).click();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
