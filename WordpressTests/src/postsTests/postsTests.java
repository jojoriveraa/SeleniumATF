package postsTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.ListPostPage;
import utilities.WordpressTests;
import workflows.PostCreator;

public class postsTests extends WordpressTests {

	@Test
	public void addedPostShowUp() throws InterruptedException, NoSuchMethodException, SecurityException {
		ListPostPage.storeCount();
		PostCreator.createPost();
		DashboardPage.goTo();
		Assert.assertEquals(ListPostPage.getPreviousPostCount() + 1, ListPostPage.getCurrentPostCount(),
				"Count of posts did not increase");
		Assert.assertTrue(ListPostPage.doesPostExistsWithTitle(PostCreator.getTitle()));

	}

	@Test
	public void searchPosts() throws NoSuchMethodException, SecurityException, InterruptedException {
		PostCreator.createPost();
		DashboardPage.goTo();
		ListPostPage.searchForPost(PostCreator.getTitle());
		Assert.assertTrue(ListPostPage.doesPostExistsWithTitle(PostCreator.getTitle()));
	}

}
