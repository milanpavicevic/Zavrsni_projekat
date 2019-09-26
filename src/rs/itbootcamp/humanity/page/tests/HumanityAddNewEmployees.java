package rs.itbootcamp.humanity.page.tests;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import rs.itbootcamp.humanity.page.objects.HumanityHome;
import rs.itbootcamp.humanity.page.objects.HumanityMenu;
import rs.itbootcamp.humanity.page.objects.HumanityStaff;
import rs.itbootcamp.humanity.utility.ExcelUtils;

public class HumanityAddNewEmployees {

	@Test
	public static void testAddNewEmpl() {

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
			HumanityStaff.clickAddStaffButton(driver);

			File src = new File("Projekat.xls");
			FileInputStream fis = new FileInputStream(src);
			HSSFWorkbook wbe = new HSSFWorkbook(fis);
			HSSFSheet sheet1 = wbe.getSheetAt(0);
			int rowcount = sheet1.getLastRowNum();
			StringBuilder sb = new StringBuilder();
			sb.append("Ukupan broj zaposlenih je ");
			sb.append(rowcount + 1);
			sb.append(" + menadzer.");
			System.out.println(sb);
			for (int i = 0; i <= rowcount; i++) {
				HSSFRow r = sheet1.getRow(i);
				if (r != null) {
					String ime = r.getCell(0).getStringCellValue();
					String prezime = r.getCell(1).getStringCellValue();
					String mail = r.getCell(2).getStringCellValue();

					HumanityStaff.setFirstNameField(driver, i + 1, ime);
					HumanityStaff.setLastNameField(driver, i + 1, prezime);
					HumanityStaff.setEmailField(driver, i + 1, mail);
				} else {
					System.out.println("<Prazan red>" + i);
				}
			}
			HumanityStaff.clickSaveEmplButton(driver);
			for (int i = 0; i <= rowcount; i++) {
				SoftAssert sa = new SoftAssert();
				sa.assertEquals(HumanityStaff.getFirstNameField(driver, (i + 1)).getText(), ExcelUtils.getDataAt(i, 0),
						"U redu " + i + " je pogresan unos u polju za ime.");
				sa.assertEquals(HumanityStaff.getLastNameField(driver, (i + 1)).getText(), ExcelUtils.getDataAt(i, 1),
						"U redu " + i + " je pogresan unos u polju za prezime.");
				sa.assertEquals(HumanityStaff.getEmailField(driver, (i + 1)).getText(), ExcelUtils.getDataAt(i, 2),
						"U redu " + i + " je pogresan unos u polju za mejl.");
				sa.assertAll("Pala je neka provera.");
			}
			wbe.close();

			Thread.sleep(2000);
			driver.quit();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println(ExcelUtils.getDataAt(0, 0));
	}
}
