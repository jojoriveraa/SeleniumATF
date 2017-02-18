package pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.Driver;

public class DashboardPage {

	public static boolean isAt() {
		WebDriverWait wdw = new WebDriverWait(Driver.getInstance(), 5);
		return wdw.until(ExpectedConditions.titleContains("Site Settings"));
	}

}
