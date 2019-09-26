package rs.itbootcamp.humanity.page.tests;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import rs.itbootcamp.humanity.page.objects.HumanityHome;
import rs.itbootcamp.humanity.page.objects.HumanityMenu;
import rs.itbootcamp.humanity.page.objects.HumanityProfile;

public class HumanitySettingsTest {
	public static void testPrikazaSetingsa() {
		try {
			System.setProperty("webdriver.chrome.driver", "chromedriver (2).exe");
			WebDriver driver = new ChromeDriver();
			driver.get(HumanityHome.URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

			HumanityHome.clickLogin(driver);
			HumanityHome.clickLoginEmail(driver);
			HumanityHome.inputLoginEmail(driver, "nifibew@free-temp.net");
			HumanityHome.clickPassword(driver);
			HumanityHome.inputPassword(driver, "lozinka");
			HumanityHome.clickLogin2(driver);

			// prikaz settings-a:
			HumanityMenu.clickProfile(driver);
			HumanityProfile.clickProfileOpt(driver);
			Thread.sleep(1000);
			HumanityMenu.clickProfile(driver);
			HumanityProfile.clickSettingsOpt(driver);
			Thread.sleep(1000);
			HumanityMenu.clickProfile(driver);
			HumanityProfile.clickAvailabillity(driver);
			Thread.sleep(1000);
			HumanityMenu.clickProfile(driver);
			System.out.println("Trazena verzija aplikacije je " + HumanityProfile.getVersion(driver));
			Thread.sleep(1000);
			HumanityProfile.clickSignOut(driver);

			if (driver.getCurrentUrl().equals("https://companero.humanity.com/app/staff/availability/5093081/")) {
				System.out.println("Uspesan prikaz settings-a!");
			} else
				System.out.println("Neuspesan prikaz settings-a!");
			Thread.sleep(2000);
			driver.quit();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}