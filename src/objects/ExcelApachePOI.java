package objects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelApachePOI {

	public static final String URL = "https://lego1.humanity.com/app/dashboard/";
	private static final String STAFF_XPATH = "//*[@id=\"sn_staff\"]/span";
	private static final String ADD_EMPLOYEES_XPATH = "//*[@id=\"act_primary\"]";
	private static final String ADD_FIRSTNAME_XPATH = "//*[@id=\"_asf1\"]";
	private static final String ADD_LASTNAME_XPATH = "//*[@id=\"_asl1\"]";
	private static final String ADD_EMAIL_XPATH = "//*[@id=\"_ase1\"]";
	private static final String SAVE_NEW_EMPLOYEE_XPATH = "//*[@id=\"_as_save_multiple\"]";
	public static final String LOGIN_XPATH = "//*[@id=\"navbarSupportedContent\"]/div/a[2]/p";
	public static final String LOGIN_EMAIL_XPATH = "//*[@id=\"email\"]";
	public static final String LOGIN_PASS_XPATH = "//*[@id=\"password\"]";
	public static final String LOGIN_BUTTON_XPATH = "//*[@id=\"LoginForm\"]/div[3]/div/button[1]";
	public static final String ANNOUNCMENT_XPATH = "//*[@id=\"tcp-modal\"]/div/div/div[1]/button";
	public static final String DENY_COOKIES_XPATH = "//*[@id=\"cf-root\"]/div/div/div/div[2]/div[2]/div[2]/button";

	public static void fiveEmployeesInput(WebDriver driver) {

		File f = new File("data.xlsx");
		try {
			InputStream inp = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(inp);
			Sheet sheet = wb.getSheetAt(0);
			Row row;
			for (int i = 0; i < 6; i++) {
				row = sheet.getRow(i);
				String name = row.getCell(0).toString();
				String surname = row.getCell(1).toString();
				String email = row.getCell(2).toString();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				driver.findElement(By.xpath(ADD_EMPLOYEES_XPATH)).click();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				driver.findElement(By.xpath(ADD_FIRSTNAME_XPATH)).sendKeys(name);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				driver.findElement(By.xpath(ADD_LASTNAME_XPATH)).sendKeys(surname);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				driver.findElement(By.xpath(ADD_EMAIL_XPATH)).sendKeys(email);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				driver.findElement(By.xpath(SAVE_NEW_EMPLOYEE_XPATH)).click();
				wb.close();
				driver.findElement(By.xpath(STAFF_XPATH)).click();
			}
		} catch (IOException e) {
			System.out.println("File not foundl!");
			e.printStackTrace();
		}
	}
}