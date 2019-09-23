package rs.itbootcamp.humanity.start;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import rs.itbootcamp.humanity.page.objects.HumanityHome;
import rs.itbootcamp.humanity.page.objects.HumanityMenu;
import rs.itbootcamp.humanity.page.objects.HumanityStaff;

public class HumanityGlavna {

	public static void main(String[] args) throws InterruptedException {
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

		HumanityMenu.clickShiftPl(driver);
		HumanityMenu.clickTimeClock(driver);
		HumanityMenu.clickLeave(driver);
		HumanityMenu.clickTraining(driver);
		HumanityMenu.clickPayroll(driver);
		HumanityMenu.clickReports(driver);
		HumanityMenu.clickStaffButton(driver);
		HumanityStaff.clickAddStaffButton(driver);

		try {
			File src = new File("Projekat.xls");
			FileInputStream fis = new FileInputStream(src);
			HSSFWorkbook wbe = new HSSFWorkbook(fis);
			HSSFSheet sheet1 = wbe.getSheetAt(0);
			int rowcount = sheet1.getLastRowNum();
			System.out.println("Ukupan broj zaposlenih je " + (rowcount + 1));
			for (int i = 0; i <= rowcount; i++) {
				HSSFRow r = sheet1.getRow(i);
				if (r != null) {
					String ime = r.getCell(0).getStringCellValue();
					String prezime = r.getCell(1).getStringCellValue();
					String mail = r.getCell(2).getStringCellValue();

					HumanityStaff.setFirstNameField(driver, i + 1, ime);
					HumanityStaff.setLastNameField(driver, i + 1, prezime);
					HumanityStaff.setEmailField(driver, i + 1, mail);

					if (r.getCell(0).getStringCellValue() == null) {
						System.out.print("U redu " + r);
						System.out.println("Nije uneto ime.");
					}
					if (r.getCell(1).getStringCellValue() == null) {
						System.out.print("U redu " + r);
						System.out.println("Nije uneto prezime.");
					}
					if (r.getCell(2).getStringCellValue() == null) {
						System.out.print("U redu " + r);
						System.out.println("Nije unet mail.");
					}
				} else {
					System.out.println("<Prazan red>" + i);
				}
			}
			HumanityStaff.clickSaveEmplButton(driver);
			wbe.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		Action a = acs.build();
		a.perform();
		Thread.sleep(2000);
		driver.quit();
	}

}
