package rs.itbootcamp.humanity.page.tests;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import rs.itbootcamp.humanity.page.objects.HumanityHome;
import rs.itbootcamp.humanity.page.objects.HumanityMenu;
import rs.itbootcamp.humanity.page.objects.HumanityProfile;
import rs.itbootcamp.humanity.page.objects.HumanitySettings;

public class TestSettingsOptions {

	public static void testSettingsOptions() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver (2).exe");
		WebDriver driver = new ChromeDriver();

//		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
//		
		Actions acs = new Actions(driver);
		driver.get(HumanityHome.URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		HumanityHome.clickLogin(driver);
		HumanityHome.clickLoginEmail(driver);
		HumanityHome.inputLoginEmail(driver, "nifibew@free-temp.net");
		HumanityHome.clickPassword(driver);
		HumanityHome.inputPassword(driver, "lozinka");
		HumanityHome.clickLogin2(driver);
		HumanityMenu.clickSettings(driver);

		HumanitySettings.inputCountry(driver, "Serbia");
		HumanitySettings.inputLanguage(driver, "Serbian (machine)");
		HumanitySettings.inputTimeFormat(driver, "24 hour");

		Action a = acs.build();
		a.perform();
		Thread.sleep(3000);
		driver.quit();
	}
}
