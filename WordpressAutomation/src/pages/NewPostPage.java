package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.Driver;
import navigation.LeftNavigation;

public class NewPostPage {

	public static void goTo() {
		LeftNavigation.Posts.AddNew.select();
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

	public static void goBack() {
		Driver.getInstance().findElement(By.className("editor-ground-control__publish-combo")).click();
		Driver.getInstance().findElement(By.className("editor-sidebar__close")).click();
	}

}
