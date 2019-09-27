package rs.itbootcamp.humanity.page.tests;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import rs.itbootcamp.humanity.page.objects.HumanityHome;
import rs.itbootcamp.humanity.page.objects.HumanityMenu;
import rs.itbootcamp.humanity.page.objects.HumanityStaff;
import rs.itbootcamp.humanity.utility.ExcelUtils;

public class TestAddNewEmpl {
	@Test
	public static void testAddNewEmpl() {

		try {
			System.setProperty("webdriver.chrome.driver", "chromedriver (2).exe");
			WebDriver driver = new ChromeDriver();
			driver.get(HumanityHome.URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			Actions acs = new Actions(driver);

			HumanityHome.clickLogin(driver);
			HumanityHome.clickLoginEmail(driver);
			HumanityHome.inputLoginEmail(driver, "nifibew@free-temp.net");
			HumanityHome.clickPassword(driver);
			HumanityHome.inputPassword(driver, "lozinka");
			HumanityHome.clickLogin2(driver);
			Thread.sleep(3000);
			HumanityMenu.clickStaffButton(driver);
			Thread.sleep(3000);
			HumanityStaff.clickAddStaffButton(driver);

			File src = new File("Data.xls");
			FileInputStream fis = new FileInputStream(src);
			HSSFWorkbook wbe = new HSSFWorkbook(fis);
			HSSFSheet sheet1 = wbe.getSheetAt(1);
			int rowcount = sheet1.getLastRowNum();
			Thread.sleep(3000);
//for je ogranicen na 1 da bih izbegao cesta brisanja zaposlenih, zbog gomilanja prilikom testiranja
			for (int i = 1; i <= 1 /*rowcount*/; i++) {
				HSSFRow r = sheet1.getRow((int) Math.ceil(Math.random()*9));
				if (r != null) {
					String ime = r.getCell(0).getStringCellValue();
					String prezime = r.getCell(1).getStringCellValue();
					String mail = r.getCell(2).getStringCellValue();

					HumanityStaff.setFirstNameField(driver, i, ime);
					HumanityStaff.setLastNameField(driver, i, prezime);
					HumanityStaff.setEmailField(driver, i, mail);
//					HumanityStaff.clickSaveEmplButton(driver);
//					Thread.sleep(3000);
				} else {
					System.out.println("<Prazan red>" + i);
				}
			}
			Thread.sleep(3000);
			HumanityStaff.clickSaveEmplButton(driver);
			Thread.sleep(3000);
			WebElement emplNo = HumanityStaff.getEmplNumber(driver);
			String brojZap = emplNo.findElement(By.tagName("span")).getText();
			StringBuilder sb = new StringBuilder();
			sb.append("Ukupan broj zaposlenih je ");
			sb.append(brojZap);
			sb.append(" + menadzer.");
			System.out.println(sb);
			
			wbe.close();
			Action a = acs.build();
			a.perform();
			Thread.sleep(5000);
			driver.quit();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}