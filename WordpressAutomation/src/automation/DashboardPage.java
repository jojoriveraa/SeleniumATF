package automation;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

	public static boolean isAt() {
		WebDriverWait wdw = new WebDriverWait(Driver.getInstance(), 5);
		return wdw.until(ExpectedConditions.titleContains("Escritorio"));
	}

}
