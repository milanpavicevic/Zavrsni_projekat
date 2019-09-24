package rs.itbootcamp.humanity.page.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import rs.itbootcamp.humanity.page.objects.HumanityHome;

public class HumanityLoginTests {
	public static void testLogina() {
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
			if (driver.getCurrentUrl().equals("https://www.humanity.com/app/")) {
				System.out.println("Uspesan login!");
			} else
				System.out.println("Login je neuspesan.");
			Thread.sleep(2000);
			driver.quit();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
