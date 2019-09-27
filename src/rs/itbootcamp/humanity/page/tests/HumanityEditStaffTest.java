package rs.itbootcamp.humanity.page.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import rs.itbootcamp.humanity.page.objects.HumanityEditStaff;
import rs.itbootcamp.humanity.page.objects.HumanityHome;
import rs.itbootcamp.humanity.page.objects.HumanityMenu;

public class HumanityEditStaffTest {

	public static void testEditStaff() {
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
			HumanityMenu.clickStaffButton(driver);

			Thread.sleep(3000);
			HumanityEditStaff.clickFirstEmpl(driver);
			HumanityEditStaff.clickEditDetails(driver);
			HumanityEditStaff.clickEditNick(driver, "The Professor");
			HumanityEditStaff.clickUploadPic(driver);
			HumanityEditStaff.clickSaveEmpl(driver);
			System.out.println("Uspesno dodate stavke.");
			Thread.sleep(5000);
			driver.quit();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
