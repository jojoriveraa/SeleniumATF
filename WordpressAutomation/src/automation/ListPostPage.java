package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ListPostPage {

	public static void goTo(PostType postType) {
		switch (postType) {
		case PAGE:
			LeftNavigation.Pages.Allpages.select();
			break;

		default:
			break;
		}
	}

	public static void selectPost(String title) {
		WebElement postLink = Driver.getInstance().findElement(By.linkText("Sample page"));
		postLink.click();
	}

}
