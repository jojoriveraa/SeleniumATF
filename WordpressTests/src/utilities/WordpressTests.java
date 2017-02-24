package utilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import automation.Driver;
import pages.LoginPage;
import workflows.PostCreator;

public class WordpressTests {
	@BeforeTest
	public void setup() {
		Driver.initialize();
		PostCreator.initialize();
		loginWordpressAsAdmin();
	}

	public void loginWordpressAsAdmin() {
		LoginPage.goTo();
		LoginPage.loginAs("atfselenium").withPassword("atfselenium123").login();
	}

	@AfterTest
	public void cleanup() {
		PostCreator.cleanup();
		Driver.close();
	}

}
