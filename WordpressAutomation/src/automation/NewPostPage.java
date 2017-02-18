package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NewPostPage {

	public static void goTo() {
		WebElement postsItem = Driver.getInstance().findElement(By.className("posts"));
		WebElement addPostButton = postsItem.findElement(By.className("sidebar__button"));
		addPostButton.click();
	}

	public static CreatePostCommand createPost(String title) {
		return new CreatePostCommand(title);
	}

	public static void goToNewPost() {
		Driver.getInstance().findElement(By.className("notice__action")).click();
	}

	public static boolean isInEditMode() {
		return Driver.getInstance().findElement(By.className("post-editor")) != null;
	}

	public static String getTitle() {
		WebDriverWait wdw = new WebDriverWait(Driver.getInstance(), 5);
		wdw.until(ExpectedConditions.textToBe(By.className("editor-title"), "Sample page"));
		return Driver.getInstance().findElement(By.className("editor-title")).getText();
	}

}
