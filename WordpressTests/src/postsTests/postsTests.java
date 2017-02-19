package postsTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.ListPostPage;
import pages.NewPostPage;
import pages.PostType;
import utilities.WordpressTests;

public class postsTests extends WordpressTests {

	@Test
	public void addedPostShowUp() throws InterruptedException, NoSuchMethodException, SecurityException {
		String title = "Added post show up, title";

		// Go to posts, get posts count, store
		ListPostPage.goTo(PostType.POSTS);
		ListPostPage.storeCount();

		// Add a new post
		NewPostPage.goTo();
		NewPostPage.createPost(title).withBody("Added post show up, body").publish();
		DashboardPage.goTo();

		// Go to posts, get posts count
		ListPostPage.goTo(PostType.POSTS);
		Assert.assertEquals(ListPostPage.getPreviousPostCount() + 1, ListPostPage.getCurrentPostCount(),
				"Count of posts did not increase");

		// Check for added post
		Assert.assertTrue(ListPostPage.doesPostExistsWithTitle(title));

		// trash post (cleanup)
		ListPostPage.trashPostWithTitle(title);
		Assert.assertEquals(ListPostPage.getPreviousPostCount(), ListPostPage.getCurrentPostCount(),
				"Couldnt trash post");
	}

}
