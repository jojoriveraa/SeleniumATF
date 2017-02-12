package automation;

public class LoginPage {

	public static void goTo() {
		Driver.getInstance().get("https://wordpress.com/settings/general/atfselenium.wordpress.com");
	}

	public static LoginCommand loginAs(String username) {
		return new LoginCommand(username);
	}
}