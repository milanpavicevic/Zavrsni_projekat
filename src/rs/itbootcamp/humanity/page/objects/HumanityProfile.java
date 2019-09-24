package rs.itbootcamp.humanity.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HumanityProfile {
	private static final String PROFILE_OPTION_XPATH = "//a[contains(text(),'Profile')]";
	private static final String SETTINGS_OPTION_XPATH = "//div[@class='userm userm-mainPage']//a[contains(text(),'Settings')]";
	private static final String AVAILABILLITY_XPATH = "//div[@class='userm userm-mainPage']//a[contains(text(),'Availability')]";
	private static final String SIGN_OUT_XPATH = "//a[contains(text(),'Sign Out')]";
	private static final String VERSION_XPATH = "//b[contains(text(),'9.5.5')]";

	// Profile Option:
	public static WebElement getProfileOpt(WebDriver driver) {
		return driver.findElement(By.xpath(PROFILE_OPTION_XPATH));
	}

	public static void clickProfileOpt(WebDriver driver) {
		getProfileOpt(driver).click();
	}

	// Settings Option:
	public static WebElement getSettingsOpt(WebDriver driver) {
		return driver.findElement(By.xpath(SETTINGS_OPTION_XPATH));
	}

	public static void clickSettingsOpt(WebDriver driver) {
		getSettingsOpt(driver).click();
	}

	// Availabillity Option:
	public static WebElement getAvailabillity(WebDriver driver) {
		return driver.findElement(By.xpath(AVAILABILLITY_XPATH));
	}

	public static void clickAvailabillity(WebDriver driver) {
		getAvailabillity(driver).click();
	}

	// SignOut:
	public static WebElement getSignOut(WebDriver driver) {
		return driver.findElement(By.xpath(SIGN_OUT_XPATH));
	}

	public static void clickSignOut(WebDriver driver) {
		getSignOut(driver).click();
	}

	// Get version:
	public static String getVersion(WebDriver driver) {
		WebElement version = driver.findElement(By.xpath(VERSION_XPATH));
		return version.getText();
	}
}
