package pages;

import org.openqa.selenium.By;

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
		Driver.wait(5);

		Driver.getInstance().switchTo().frame("tinymce-1_ifr");
		Driver.getInstance().findElement(By.id("tinymce")).sendKeys(body);
		Driver.getInstance().switchTo().defaultContent();
		Driver.wait(5);

		Driver.getInstance().findElement(By.className("editor-ground-control__publish-combo")).click();
		Driver.wait(5);

	}
}
