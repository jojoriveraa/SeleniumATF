package pages;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.Driver;
import navigation.LeftNavigation;

public class ListPostPage {

	private static int lastCount;
	private static Map<String, WebElement> elementsMap;

	public static void goTo(PostType postType) {
		switch (postType) {
		case PAGE:
			LeftNavigation.Pages.Allpages.select();
			break;
		case POSTS:
			LeftNavigation.Posts.AllPosts.select();
			break;
		default:
			break;
		}
	}

	public static void selectPost(String title) {
		WebElement postLink = Driver.getInstance().findElement(By.linkText("Sample page"));
		postLink.click();
	}

	public static void storeCount() {
		lastCount = getPostCount();
	}

	private static int getPostCount() {
		String countText = Driver.getInstance().findElement(By.className("is-publish"))
				.findElement(By.className("count")).getText();
		return Integer.parseInt(countText);
	}

	public static int getPreviousPostCount() {
		return lastCount;
	}

	public static Object getCurrentPostCount() {
		return getPostCount();
	}

	public static boolean doesPostExistsWithTitle(String title) {
		WebElement post = getCardWithTitle(title);
		return post != null;
	}

	public static void trashPostWithTitle(String title)
			throws InterruptedException, NoSuchMethodException, SecurityException {
		WebElement post = getCardWithTitle(title);
		WebElement trashIcon = post.findElement(By.className("post-controls__trash"));
		Method clickMethod = trashIcon.getClass().getDeclaredMethod("click");
		Driver.noWait(trashIcon, clickMethod); // This no wait was implemented
												// just for academic reasons by
												// now
		Driver.wait(5);
	}

	public static WebElement getCardWithTitle(String title) {
		fillPostCardsMap();
		return elementsMap.get(title);
	}

	public static void fillPostCardsMap() {
		List<WebElement> elementsList = Driver.getInstance().findElements(By.tagName("article"));

		elementsMap = new HashMap<String, WebElement>();

		for (WebElement webElement : elementsList) {
			elementsMap.put(webElement.findElement(By.className("post__title")).getText(), webElement);
		}
	}

	public static void searchForPost(String searchString) {
		WebElement searchContainer = Driver.getInstance().findElement(By.className("is-expanded-to-container"));
		WebElement searchIcon = searchContainer.findElement(By.className("search__open-icon"));
		searchIcon.click();
		Driver.wait(2);
		WebElement searchBox = Driver.getInstance().findElement(By.xpath("//*[starts-with(@id, 'search-component')]"));
		searchBox.sendKeys(searchString);
		Driver.wait(2);

	}

}
