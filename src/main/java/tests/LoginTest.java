package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.Screenshots;

public class LoginTest extends BaseTest {
	@Parameters({"user","pass"})
	@Test
	public void loginTest(String username, String password) {
		app.click(app.menu.myAccountLink);
		app.myAccount.loginInApp(username, password);
		assertTrue(app.checkElementisDisplayed(app.myAccount.usernameGreetings));
		Screenshots.screenshot(driver);
		assertTrue(app.myAccount.usernameGreetings.isDisplayed());
	}

}
