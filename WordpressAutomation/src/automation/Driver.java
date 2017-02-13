package automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

	private static WebDriver Instance;
	
	public static void initialize() {
		System.setProperty("webdriver.gecko.driver", "res\\drivers\\geckodriver.exe");
		Instance = new FirefoxDriver();
		Instance.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	}

	public static WebDriver getInstance() {
		return Instance;
	}

	public static void setInstance(WebDriver instance) {
		Instance = instance;
	}

	public static void close() {
//		Instance.close();
	}

}
