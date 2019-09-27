package rs.itbootcamp.humanity.page.tests;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import rs.itbootcamp.humanity.page.objects.HumanityHome;
import rs.itbootcamp.humanity.page.objects.HumanityStaff;

public class HumanityLoginTests {
	public static void testLogina() {
		try {
			System.setProperty("webdriver.chrome.driver", "chromedriver (2).exe");
			WebDriver driver = new ChromeDriver();
			driver.get(HumanityHome.URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			
			File src = new File("login.xls");
			FileInputStream fis = new FileInputStream(src);
			HSSFWorkbook wbe = new HSSFWorkbook(fis);
			HSSFSheet sheet1 = wbe.getSheetAt(0);
			HSSFRow r = sheet1.getRow(0);
			String mail = r.getCell(0).getStringCellValue();
			String password = r.getCell(1).getStringCellValue();
			HumanityHome.clickLogin(driver);
			HumanityHome.clickLoginEmail(driver);
			HumanityHome.inputLoginEmail(driver, mail);
			HumanityHome.clickPassword(driver);
			HumanityHome.inputPassword(driver, password);
			HumanityHome.clickLogin2(driver);
			if (driver.getCurrentUrl().equals("https://www.humanity.com/app/")) {
				System.out.println("Uspesan login!");
			} else
				System.out.println("Login je neuspesan.");
			Thread.sleep(5000);
			driver.quit();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}	
}