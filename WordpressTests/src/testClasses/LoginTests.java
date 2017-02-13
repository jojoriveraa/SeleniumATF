package testClasses;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import automation.*;

public class LoginTests {
	
	@BeforeClass
	private void setup() {
		Driver.initialize();
	}

	@Test
	public void loginTest() {
		LoginPage.goTo();
		LoginPage.loginAs("atfselenium").withPassword("atfselenium123").login();
		
		Assert.assertTrue(DashboardPage.isAt(), "Failed to login");
	}

	@AfterClass
	public void cleanup(){
		Driver.close();
	}
}
