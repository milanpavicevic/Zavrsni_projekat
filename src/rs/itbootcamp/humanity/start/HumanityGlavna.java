package rs.itbootcamp.humanity.start;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import rs.itbootcamp.humanity.page.objects.HumanityHome;
import rs.itbootcamp.humanity.page.objects.HumanityMenu;
import rs.itbootcamp.humanity.page.objects.HumanityProfile;
import rs.itbootcamp.humanity.page.objects.HumanityStaff;
import rs.itbootcamp.humanity.page.tests.HumanityAddNewEmployeeTests2;
import rs.itbootcamp.humanity.page.tests.HumanityEditStaffTest;
import rs.itbootcamp.humanity.page.tests.HumanityLoginTests;
import rs.itbootcamp.humanity.page.tests.HumanitySettingsTest;

public class HumanityGlavna {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		int izbor;
		do {
			System.out.print(
					"Izaberite:\n1 - prikaz pristupa komandama\n2 - testiranje unosa zaposlenih\n3 - testiranje logina\n4 - prikaz komandi settings-a\n5 - dodavanje stavki profilu radnika\n0 - Izlaz\n");
			izbor = sc.nextInt();
			switch (izbor) {
			case 1:
				System.setProperty("webdriver.chrome.driver", "chromedriver (2).exe");
				WebDriver driver = new ChromeDriver();
				Actions acs = new Actions(driver);
				driver.get(HumanityHome.URL);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//				HumanityHome.clickLogin(driver);
//				HumanityHome.clickLoginEmail(driver);
//				HumanityHome.inputLoginEmail(driver, "nifibew@free-temp.net");
//				HumanityHome.clickPassword(driver);
//				HumanityHome.inputPassword(driver, "lozinka");
//				HumanityHome.clickLogin2(driver);
				HumanityHome.displayHome();
				HumanityMenu.displayMeny();

//				HumanityMenu.clickShiftPl(driver);
//				HumanityMenu.clickTimeClock(driver);
//				HumanityMenu.clickLeave(driver);
//				HumanityMenu.clickTraining(driver);
//				HumanityMenu.clickPayroll(driver);
//				HumanityMenu.clickReports(driver);

				HumanityMenu.clickStaffButton(driver);
				HumanityStaff.clickSearch(driver);
				HumanityStaff.inputSearch(driver, "Zlaja");
				HumanityStaff.clickAddStaffButton(driver);
				
//				Action a = acs.build();
//				a.perform();
//				Thread.sleep(3000);
//				driver.quit();
				break;
			case 2:
				HumanityAddNewEmployeeTests2.testAddNewEmpl();
				break;
			case 3:
				HumanityLoginTests.testLogina();
				break;
			case 4:
				HumanitySettingsTest.testPrikazaSetingsa();
				break;
			case 5:
				HumanityEditStaffTest.testEditStaff();
				break;
			case 0:
				System.out.println("Kraj programa.");
				Thread.sleep(2000);
				break;
			default:
				System.out.println("Pogresan unos!");
			}
		} while (izbor != 0);
	}
}