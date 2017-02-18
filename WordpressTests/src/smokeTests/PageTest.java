package smokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ListPostPage;
import pages.NewPostPage;
import pages.PostType;
import utilities.WordpressTests;

public class PageTest extends WordpressTests {

	@Test
	public void openPageEditor() {

		ListPostPage.goTo(PostType.PAGE);
		ListPostPage.selectPost("Sample Page");

		Assert.assertTrue(NewPostPage.isInEditMode(), "Wasn't in edit mode");
		Assert.assertEquals("Sample page", NewPostPage.getTitle(), "Title did not match");

	}

}
