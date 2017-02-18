package testClasses;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import automation.Driver;
import automation.LoginPage;

public class WordpressTests {
	@BeforeTest
	public void setup() {
		Driver.initialize();
		loginWordpressAsAdmin();
	}
	
	public void loginWordpressAsAdmin() {
		LoginPage.goTo();
		LoginPage.loginAs("atfselenium").withPassword("atfselenium123").login();
	}

	@AfterTest
	public void cleanup() {
		Driver.close();
	}

}
