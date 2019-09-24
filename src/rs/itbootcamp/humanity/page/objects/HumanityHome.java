package rs.itbootcamp.humanity.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HumanityHome {
	public static final String URL = "https://www.humanity.com";
	private static final String START_TRIAL_XPATH = "//a[@class='button pale']";
	private static final String LOGIN_XPATH = "//p[contains(text(),'LOGIN')]";
	private static final String ABOUT_US_XPATH = "//a[@class='nav-link no-before'][contains(text(),'About us')]";
	private static final String FULL_NAME_XPATH = "//div[@class='input-wrapper']//input[@placeholder='Full Name']";
	private static final String EMAIL_XPATH = "//div[@class='input-wrapper']//input[@placeholder='Work Email']";
	private static final String START_TRIAL2_XPATH = "//input[@id='free-trial-link-01']";
	private static final String LOGIN_EMAIL_XPATH = "//input[@id='email']";
	private static final String PASSWORD_XPATH = "//input[@id='password']";
	private static final String LOGIN2_XPATH = "//button[contains(text(),'Log in')]";

	// START_TRIAL:
	public static WebElement getStartTrial(WebDriver driver) {
		return driver.findElement(By.xpath(START_TRIAL_XPATH));
	}

	public static void clickStartTrial(WebDriver driver) {
		getStartTrial(driver).click();
	}

	// Login:
	public static WebElement getLogin(WebDriver driver) {
		return driver.findElement(By.xpath(LOGIN_XPATH));
	}

	public static void clickLogin(WebDriver driver) {
		getLogin(driver).click();
	}

	// About us:
	public static WebElement getAboutUs(WebDriver driver) {
		return driver.findElement(By.xpath(ABOUT_US_XPATH));
	}

	public static void clickAboutUs(WebDriver driver) {
		getAboutUs(driver).click();
	}

	// Full name:
	public static WebElement getFullName(WebDriver driver) {
		return driver.findElement(By.xpath(FULL_NAME_XPATH));
	}

	public static void clickFullName(WebDriver driver) {
		getFullName(driver).click();
	}

	public static void inputFullName(WebDriver driver, String data) {
		getFullName(driver).sendKeys(data);
	}

	// Email:
	public static WebElement getEmail(WebDriver driver) {
		return driver.findElement(By.xpath(EMAIL_XPATH));
	}

	public static void clickEmail(WebDriver driver) {
		getEmail(driver).click();
	}

	public static void inputEmail(WebDriver driver, String data) {
		getEmail(driver).sendKeys(data);
	}

	// START_TRIAL2:
	public static WebElement getStartTrial2(WebDriver driver) {
		return driver.findElement(By.xpath(START_TRIAL2_XPATH));
	}

	public static void clickStartTrial2(WebDriver driver) {
		getStartTrial2(driver).click();
	}

	// Login email:
	public static WebElement getLoginEmail(WebDriver driver) {
		return driver.findElement(By.xpath(LOGIN_EMAIL_XPATH));
	}

	public static void clickLoginEmail(WebDriver driver) {
		getLoginEmail(driver).click();
	}

	public static void inputLoginEmail(WebDriver driver, String data) {
		getLoginEmail(driver).sendKeys(data);
	}

	// Login email:
	public static WebElement getPassword(WebDriver driver) {
		return driver.findElement(By.xpath(PASSWORD_XPATH));
	}

	public static void clickPassword(WebDriver driver) {
		getPassword(driver).click();
	}

	public static void inputPassword(WebDriver driver, String data) {
		getPassword(driver).sendKeys(data);
	}
	
	//Login2:
	public static WebElement getLogin2(WebDriver driver) {
		return driver.findElement(By.xpath(LOGIN2_XPATH));
	}

	public static void clickLogin2(WebDriver driver) {
		getLogin2(driver).click();
	}
	
	public static void displayHome() {
		System.setProperty("webdriver.chrome.driver", "chromedriver (2).exe");
		WebDriver driver = new ChromeDriver();
		Actions acs = new Actions(driver);
		
		HumanityHome.clickLogin(driver);
		HumanityHome.clickLoginEmail(driver);
		HumanityHome.inputLoginEmail(driver, "nifibew@free-temp.net");
		HumanityHome.clickPassword(driver);
		HumanityHome.inputPassword(driver, "lozinka");
		HumanityHome.clickLogin2(driver);
	}
}