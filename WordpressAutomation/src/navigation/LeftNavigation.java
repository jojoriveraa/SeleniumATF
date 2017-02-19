package navigation;

public class LeftNavigation {
	public static class Posts {
		public static class AddNew {
			public static void select() {
				MenuSelector.select("posts", "sidebar__button");
			}
		}
		public static class AllPosts {
			public static void select() {
				MenuSelector.select("posts");
			}
		}
	}

	public static class Pages {
		public static class Allpages {
			public static void select() {
				MenuSelector.select("pages");
			}
		}
	}
}
