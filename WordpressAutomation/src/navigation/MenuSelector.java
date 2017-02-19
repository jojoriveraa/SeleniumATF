package navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.Driver;

public class MenuSelector {

	public static void select(String topLevelMenuId, String submenuClass) {
		WebElement sidebar = Driver.getInstance().findElement(By.className("sidebar"));
		WebElement postsLabel = sidebar.findElement(By.className(topLevelMenuId));
		WebElement addButton = postsLabel.findElement(By.className("sidebar__button"));
		addButton.click();
	}

	public static void select(String topLevelMenuId) {
		Driver.getInstance().findElement(By.className(topLevelMenuId)).click();
	}

}
