package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.Driver;

public class CreatePostCommand {

	private String title;
	private String body;

	public CreatePostCommand(String title) {
		this.title = title;
	}

	public CreatePostCommand withBody(String body) {
		this.body = body;
		return this;
	}

	public void publish() {
		Driver.getInstance().findElement(By.className("editor-title__input")).sendKeys(title);

		Driver.getInstance().switchTo().frame("tinymce-1_ifr");
		Driver.getInstance().switchTo().activeElement().sendKeys(body);

		Driver.getInstance().switchTo().defaultContent();

		WebElement publishControl = Driver.getInstance()
				.findElement(By.className("editor-ground-control__action-buttons"));
		WebElement publishButton = publishControl.findElement(By.className("editor-publish-button"));

		publishButton.click();

	}
}
