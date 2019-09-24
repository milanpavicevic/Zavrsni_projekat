package rs.itbootcamp.humanity.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HumanityEditStaff {
	private static final String FIRST_EMPLOYEE_XPATH = "//a[contains(text(),'Dusan Bobicic')]";
	private static final String EDIT_DETAILS_XPATH = "//a[contains(text(),'Edit Details')]";
	private static final String UPLOAD_PIC_XPATH = "//input[@id='fileupload']";
	private static final String EDIT_NICK_XPATH = "//input[@id='nick_name']";
	private static final String SAVE_EMPL_XPATH = "//button[@id='act_primary']";

	// First employee:
	public static WebElement getFirstEmpl(WebDriver driver) {
		return driver.findElement(By.xpath(FIRST_EMPLOYEE_XPATH));
	}

	public static void clickFirstEmpl(WebDriver driver) {
		getFirstEmpl(driver).click();
	}

	// Edit details:
	public static WebElement getEditDetails(WebDriver driver) {
		return driver.findElement(By.xpath(EDIT_DETAILS_XPATH));
	}

	public static void clickEditDetails(WebDriver driver) {
		getEditDetails(driver).click();
	}

	// Upload picture:
	public static WebElement getUploadPic(WebDriver driver) {
		return driver.findElement(By.xpath(UPLOAD_PIC_XPATH));
	}

	public static void clickUploadPic(WebDriver driver) {
//		getUploadPic(driver).click();
		getUploadPic(driver).sendKeys("D:\\IT\\QA - IT Bootcamp\\automation\\Humanity\\bobicic.jpg");
	}

	// Edit nickname:
	public static WebElement getEditNick(WebDriver driver) {
		return driver.findElement(By.xpath(EDIT_NICK_XPATH));
	}

	public static void clickEditNick(WebDriver driver, String data) {
		getEditNick(driver).click();
		getEditNick(driver).sendKeys(data);
	}

	// Save employee:
	public static WebElement getSaveEmpl(WebDriver driver) {
		return driver.findElement(By.xpath(SAVE_EMPL_XPATH));
	}

	public static void clickSaveEmpl(WebDriver driver) {
		getSaveEmpl(driver).click();
	}
}
