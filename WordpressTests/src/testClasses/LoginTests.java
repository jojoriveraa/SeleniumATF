package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.DashboardPage;

public class LoginTests extends WordpressTests {

	@Test
	public void loginTest() {
		Assert.assertTrue(DashboardPage.isAt(), "Failed to login");
	}
}
