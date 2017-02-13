package testClasses;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import automation.Driver;
import automation.ListPostPage;
import automation.LoginPage;
import automation.NewPostPage;
import automation.PostType;

public class PageTest {

	@BeforeClass
	public void setup() {
		Driver.initialize();
	}

	@Test
	public void openPageEditor() {

		LoginPage.goTo();
		LoginPage.loginAs("atfselenium").withPassword("atfselenium123").login();

		ListPostPage.goTo(PostType.PAGE);
		ListPostPage.selectPost("Sample Page");

		Assert.assertTrue(NewPostPage.isInEditMode(), "Wasn't in edit mode");
		Assert.assertEquals("Sample page", NewPostPage.getTitle(), "Title did not match");

	}

	@AfterClass
	public void cleanup() {
		Driver.close();
	}
}
