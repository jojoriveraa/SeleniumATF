package pages;

import automation.Driver;

public class LoginPage {

	public static void goTo() {
		Driver.getInstance().get(Driver.getBaseAddress() + "settings/general/atfselenium.wordpress.com");
	}

	public static LoginCommand loginAs(String username) {
		return new LoginCommand(username);
	}
}