package automation;

import org.openqa.selenium.By;

public class MenuSelector {

	public static void select(String topLevelMenuId, String submenuClass) {
		Driver.getInstance().findElement(By.className(topLevelMenuId)).findElement(By.className(submenuClass)).click();
	}

	public static void select(String topLevelMenuId) {
		Driver.getInstance().findElement(By.className(topLevelMenuId)).click();
	}

}
