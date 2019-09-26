package rs.itbootcamp.humanity.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class HumanityMenu {
	private static final String DASHBOARD_XPATH = "//a[@id='sn_dashboard']//span[@class='primNavQtip__inner']";
	private static final String SHIFT_PLANNING_XPATH = "//a[@id='sn_schedule']//span[@class='primNavQtip__inner']";
	private static final String TIMECLOCK_XPATH = "//p[contains(text(),'Time Clock')]";
	private static final String LEAVE_XPATH = "//a[@id='sn_requests']//span[@class='primNavQtip__inner']";
	private static final String TRAINING_XPATH = "//i[@class='primNavQtip__icon icon-education']";
	private static final String STAFF_XPATH = "//p[contains(text(),'Staff')]";
	private static final String PAYROLL_XPATH = "//i[@class='primNavQtip__icon icon-payroll']";
	private static final String REPORTS_XPATH = "//a[@id='sn_reports']//span[@class='primNavQtip__inner']";
	private static final String SETTINGS_XPATH = "//i[@class='primNavQtip__icon icon-gear']";
	private static final String PROFILE_XPATH = "//img[@id='tr_avatar']";

	// Dashboard:
	public static WebElement getDashboard(WebDriver driver) {
		return driver.findElement(By.xpath(DASHBOARD_XPATH));
	}

	public static void clickDashboard(WebDriver driver) {
		getDashboard(driver).click();
	}

	// Shift planning:
	public static WebElement getShiftPl(WebDriver driver) {
		return driver.findElement(By.xpath(SHIFT_PLANNING_XPATH));
	}

	public static void clickShiftPl(WebDriver driver) {
		getShiftPl(driver).click();
	}

	// Time clock:
	public static WebElement getTimeClock(WebDriver driver) {
		return driver.findElement(By.xpath(TIMECLOCK_XPATH));
	}

	public static void clickTimeClock(WebDriver driver) {
		getTimeClock(driver).click();
	}

	// Leave:
	public static WebElement getLeave(WebDriver driver) {
		return driver.findElement(By.xpath(LEAVE_XPATH));
	}

	public static void clickLeave(WebDriver driver) {
		getLeave(driver).click();
	}

	// Training:
	public static WebElement getTraining(WebDriver driver) {
		return driver.findElement(By.xpath(TRAINING_XPATH));
	}

	public static void clickTraining(WebDriver driver) {
		getTraining(driver).click();
	}

	// Click staff button:
	public static WebElement getStaffButton(WebDriver driver) {
		return driver.findElement(By.xpath(STAFF_XPATH));
	}

	public static void clickStaffButton(WebDriver driver) {
		getStaffButton(driver).click();
	}

	// Payroll:
	public static WebElement getPayroll(WebDriver driver) {
		return driver.findElement(By.xpath(PAYROLL_XPATH));
	}

	public static void clickPayroll(WebDriver driver) {
		getPayroll(driver).click();
	}

	// Reports:
	public static WebElement getReports(WebDriver driver) {
		return driver.findElement(By.xpath(REPORTS_XPATH));
	}

	public static void clickReports(WebDriver driver) {
		getReports(driver).click();
	}

	// Settings:
	public static WebElement getSettings(WebDriver driver) {
		return driver.findElement(By.xpath(SETTINGS_XPATH));
	}

	public static void clickSettings(WebDriver driver) {
		getSettings(driver).click();
	}

	// Profile:
	public static WebElement getProfile(WebDriver driver) {
		return driver.findElement(By.xpath(PROFILE_XPATH));
	}

	public static void clickProfile(WebDriver driver) {
		getProfile(driver).click();
	}
	
	public static void displayMeny() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver (2).exe");
		WebDriver driver = new ChromeDriver();
		Actions acs = new Actions(driver);
		
		HumanityMenu.clickShiftPl(driver);
		HumanityMenu.clickTimeClock(driver);
		HumanityMenu.clickLeave(driver);
		HumanityMenu.clickTraining(driver);
		HumanityMenu.clickPayroll(driver);
		HumanityMenu.clickReports(driver);
		
		Action a = acs.build();
		a.perform();
		Thread.sleep(3000);
		driver.quit();
	}
}