package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.Driver;

public class LoginCommand {

	private String username;
	private String password;

	public LoginCommand(String uername) {
		this.username = uername;
	}

	public LoginCommand withPassword(String password) {
		this.password = password;
		return this;
	}

	public void login() {
		WebElement userInput = Driver.getInstance().findElement(By.id("user_login"));
		userInput.sendKeys(username);
		WebElement passInput = Driver.getInstance().findElement(By.id("user_pass"));
		passInput.sendKeys(password);
		WebElement loginButton = Driver.getInstance().findElement(By.id("wp-submit"));
		loginButton.click();
	}
}
