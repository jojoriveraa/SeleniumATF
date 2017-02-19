package smokeTests;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.NewPostPage;
import pages.PostPage;
import utilities.WordpressTests;

public class CreatePostTest extends WordpressTests {

	@Test
	public void createABasicPost() throws InterruptedException {

		String todayAsString = new SimpleDateFormat("ddMMyyyy").format(new Date());
		String title = "This is a test post title" + todayAsString;

		NewPostPage.goTo();
		NewPostPage.createPost(title).withBody("Hello, this is the body!").publish();

		NewPostPage.goToNewPost();

		Assert.assertEquals(PostPage.getTitle(), title, "Title did not match new post.");
	}

}
