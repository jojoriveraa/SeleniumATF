package testClasses;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import automation.Driver;
import automation.LoginPage;
import automation.NewPostPage;
import automation.PostPage;

public class CreatePostTest {

	@BeforeClass
	public void setup() {
		Driver.initialize();
	}

	@Test
	public void createABasicPost() {

		String todayAsString = new SimpleDateFormat("ddMMyyyy").format(new Date());
		String title = "This is a test post title" + todayAsString;

		LoginPage.goTo();
		LoginPage.loginAs("atfselenium").withPassword("atfselenium123").login();

		NewPostPage.goTo();
		NewPostPage.createPost(title).withBody("Hello, this is the body!").publish();

		NewPostPage.goToNewPost();

		Assert.assertEquals(PostPage.getTitle(), title, "Title did not match new post.");
		
	}

	@AfterClass
	public void cleanup() {
		Driver.close();
	}

}
