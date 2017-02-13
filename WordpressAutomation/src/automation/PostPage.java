package automation;

import java.util.ArrayList;

import org.openqa.selenium.By;

public class PostPage {

	public static String getTitle() {
		String title;

		// As the new post is opened in a new tab is needed to switch to the
		// properly tab before finding the element
		ArrayList<String> tabs = new ArrayList<>(Driver.getInstance().getWindowHandles());
		Driver.getInstance().switchTo().window(tabs.get(1));

		// Get the text and after that switch the driver to default content to
		// avoid problems in future
		title = Driver.getInstance().findElement(By.className("entry-title")).getText();
		Driver.getInstance().switchTo().defaultContent();
		return title;

	}

}
