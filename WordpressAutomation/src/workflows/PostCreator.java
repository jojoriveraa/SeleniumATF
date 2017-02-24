package workflows;

import java.util.Random;

import pages.ListPostPage;
import pages.NewPostPage;

public class PostCreator {

	private static String title;

	private static String body;
	
	private static String[] words = new String[] { "boy", "cat", "dog", "rabbit", "baseball", "give", "find", "scary",
			"mustard", "car" };
	
	private static String[] articles = new String[] { "the", "an", "and", "a", "of", "to", "it", "as" };

	public static void createPost() {
		title = createTitle();
		body = createBody();
		createPost(title, body);
	}

	private static String createBody() {
		return createTandomString() + ", body";
	}

	private static String createTitle() {
		return createTandomString() + ", title";
	}

	public static void createPost(String title, String body) {
		NewPostPage.goTo();
		NewPostPage.createPost(title).withBody(body).publish();
	}

	public static String getTitle() {
		return title;
	}

	private static String createTandomString() {
		String str = "";
		Random r = new Random();
		int i = r.nextInt(3);

		for (int j = 0; j < i; j++) {
			str += words[r.nextInt(words.length)] + " ";
			str += articles[r.nextInt(articles.length)] + " ";
			str += words[r.nextInt(words.length)] + " ";
		}

		return str;
	}

	public static void initialize() {
		title = null;
		body = null;
	}

	public static void cleanup() {
		if(hasCreatedAPost()){
			try {
				thrashPost();
			} catch (NoSuchMethodException | SecurityException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void thrashPost() throws NoSuchMethodException, SecurityException, InterruptedException {
		ListPostPage.trashPostWithTitle(title);
		initialize();
		
	}

	private static boolean hasCreatedAPost() {
		return !(title.isEmpty() || title == null);
	}


}
