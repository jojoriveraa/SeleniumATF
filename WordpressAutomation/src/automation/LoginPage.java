package automation;

public class LoginPage {

	public static void goTo() {
		Driver.getInstance().get("http://localhost:2272/wp-login.php");
	}

	public static LoginCommand loginAs(String username) {
		return new LoginCommand(username);
	}
}