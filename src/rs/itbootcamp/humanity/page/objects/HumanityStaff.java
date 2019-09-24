package rs.itbootcamp.humanity.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HumanityStaff {
	public static final String URL_STAFF = "https://companero.humanity.com/app/staff/list/load/true/";
	private static final String ADD_STAFF_XPATH = "//button[@id='act_primary']";
	private static final String FIRST_NAME_XPATH = "//input[@id='_asf";
	private static final String LAST_NAME_XPATH = "//input[@id='_asl";
	private static final String EMAIL_XPATH = "//input[@id='_ase";
	private static final String ENDING_XPATH = "']";
	private static final String SAVE_EMPL_XPATH = "//button[@id='_as_save_multiple']";
	private static final String SEARCH_XPATH = "//input[@id='EmployeeStaffFilter']";

	// Add staff button:
	public static WebElement getAddStaffButton(WebDriver driver) {
		return driver.findElement(By.xpath(ADD_STAFF_XPATH));
	}

	public static void clickAddStaffButton(WebDriver driver) {
		getAddStaffButton(driver).click();
	}

	// geter i seter za first name polje
	public static WebElement getFirstNameField(WebDriver driver, int i) {
		return driver.findElement(By.xpath(FIRST_NAME_XPATH + i + ENDING_XPATH));
	}

	public static void setFirstNameField(WebDriver driver, int i, String ime) {
		getFirstNameField(driver, i).sendKeys(ime);
	}

	// geter i seter za last name polje
	public static WebElement getLastNameField(WebDriver driver, int i) {
		return driver.findElement(By.xpath(LAST_NAME_XPATH + i + ENDING_XPATH));
	}

	public static void setLastNameField(WebDriver driver, int i, String prezime) {
		getLastNameField(driver, i).sendKeys(prezime);
	}

	// geter i seter za email polje
	public static WebElement getEmailField(WebDriver driver, int i) {
		return driver.findElement(By.xpath(EMAIL_XPATH + i + ENDING_XPATH));
	}

	public static void setEmailField(WebDriver driver, int i, String email) {
		getEmailField(driver, i).sendKeys(email);
	}

	// Click save employees button:
	public static WebElement getSaveEmplButton(WebDriver driver) {
		return driver.findElement(By.xpath(SAVE_EMPL_XPATH));
	}

	public static void clickSaveEmplButton(WebDriver driver) {
		getSaveEmplButton(driver).click();
	}

	// search employee:
	public static WebElement getSearch(WebDriver driver) {
		return driver.findElement(By.xpath(SEARCH_XPATH));
	}

	public static void clickSearch(WebDriver driver) {
		getSearch(driver).click();
	}
	
	public static void inputSearch(WebDriver driver, String data) {
		getSearch(driver).sendKeys(data);
		getSearch(driver).sendKeys(Keys.ENTER);
	}
}