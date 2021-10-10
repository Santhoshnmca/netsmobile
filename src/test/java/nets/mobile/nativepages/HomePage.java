package nets.mobile.nativepages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

//import nets.mobile.support.Log;
//import nets.mobile.support.WaitUtil;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import nets.mobile.support.Log;

public class HomePage {

	private MobileDriver<MobileElement> driver;

	@AndroidFindBy(id = "products_imgv")
	MobileElement checkoutImage;

	@AndroidFindBy(id = "settings_item")
	MobileElement settingsIcon;

	public HomePage(MobileDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 500, TimeUnit.SECONDS), this);
	}

	/**
	 * Tab the Setting Icon from Home page
	 * 
	 * @return: Setting page - text from web element
	 */
	public SettingPage tapSettingsIcon() {
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			settingsIcon.click();
			Log.message("Clicked settings Icon..");
		} catch (Exception e) {
			e.printStackTrace();
			Log.fail("tap settings Icon not available", driver);
		}
		return new SettingPage(driver);
	}

	/**
	 * Verify Checkout Image from Home page
	 * 
	 * @return: Boolean value if Yes true or false
	 */
	public boolean verifyCheckOutImage() {
		boolean status = false;
		try {
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			if (status = checkoutImage.isDisplayed())
				Log.message("<b><font face='Comic Sans MS' color='#06014F'>Verified Checkout Image</font></b>", driver);
		} catch (Exception e) {
			e.printStackTrace();
			Log.fail("Failed to Verify Checkout Image", driver);
		}
		return status;
	}

}
