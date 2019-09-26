package rs.itbootcamp.humanity.start;

import java.util.Scanner;

import rs.itbootcamp.humanity.page.objects.HumanityHome;
import rs.itbootcamp.humanity.page.tests.TestAddNewEmpl;
import rs.itbootcamp.humanity.page.tests.TestSettingsOptions;
import rs.itbootcamp.humanity.page.tests.HumanityEditStaffTest;
import rs.itbootcamp.humanity.page.tests.HumanityLoginTests;
import rs.itbootcamp.humanity.page.tests.HumanitySettingsTest;

public class HumanityGlavna {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		int izbor;
		do {
			System.out.print(
					"Izaberite:\n1 - prikaz pristupa komandama\n2 - testiranje unosa zaposlenih\n3 - testiranje logina\n4 - prikaz komandi settings-a\n5 - dodavanje stavki profilu radnika\n6 - postavka Country, Default Language, Time Format\n0 - Izlaz\n");

//kod unosa zaposlenih dodati random no. u mail da se ne bi duplirao unos!

			izbor = sc.nextInt();
			switch (izbor) {
			case 1:
				HumanityHome.displayHome();
				break;
			case 2:
				TestAddNewEmpl.testAddNewEmpl();
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
			case 6:
				TestSettingsOptions.testSettingsOptions();
				break;
			case 0:
				System.out.println("Kraj programa.");
				break;
			default:
				System.out.println("Pogresan unos!");
			}
		} while (izbor != 0);
	}
}