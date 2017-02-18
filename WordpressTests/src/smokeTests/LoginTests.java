package smokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DashboardPage;
import utilities.WordpressTests;

public class LoginTests extends WordpressTests {

	@Test
	public void loginTest() {
		Assert.assertTrue(DashboardPage.isAt(), "Failed to login");
	}
}
