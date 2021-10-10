package nets.mobile.nativepages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import nets.mobile.support.BrowserActions;
import nets.mobile.support.Log;

public class LoginPage {

	private MobileDriver<MobileElement> driver;

	@AndroidFindBy(id = "customer_id_et")
	MobileElement userTextLocation;

	@AndroidFindBy(id = "sign_up_btn")
	MobileElement signUpBtn;

	public LoginPage(MobileDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 500, TimeUnit.SECONDS), this);
	}
	/**
	 * Tab the user name text box and enter the username in textbox
	 * @param username String
	 */
	public void tabUserName(String userName) {
		try {
			BrowserActions.typeOnTextField(userTextLocation, userName, driver, "Username Element");
		} catch (Exception e) {
			e.printStackTrace();
			Log.fail("user Text box is not available", driver);
		}

	}

	/**
	 * Tab the SignUp Button from Login Page
	 * @return: Home page driver
	 */
	public HomePage tapSignUpBtn() {
		try {
			BrowserActions.clickOnButton(signUpBtn, driver, "Click Sign Up");
		} catch (Exception e) {
			e.printStackTrace();
			Log.fail("tap  Sign up Button not available", driver);
		}
		return new HomePage(driver);
	}

}
