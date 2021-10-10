package nets.mobile.testscripts;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import nets.mobile.nativepages.HomePage;
import nets.mobile.nativepages.LoginPage;
import nets.mobile.nativepages.SettingPage;
import nets.mobile.support.EmailReport;
import nets.mobile.support.EnvironmentPropertiesReader;
import nets.mobile.support.Log;

@Listeners(EmailReport.class)
public class TestClassNative extends BaseTest{
	private static EnvironmentPropertiesReader configProperty = EnvironmentPropertiesReader.getInstance();

	@Test(description="Verify Nets Mobile Native Application Functionality")
	public void loginIntoNets() {
		
		Log.testCaseInfo("User able to sign up PiaSample Android app with Customer ID and Try to Change it");

		MobileDriver<MobileElement> driver = null;
		String userName = configProperty.getUsername();

		try {
			driver = createDriverForAndroid();	
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			LoginPage wp = new LoginPage(driver);
			wp.tabUserName(userName);
			HomePage hp = wp.tapSignUpBtn();
			Assert.assertTrue(hp.verifyCheckOutImage(),"Failed to Verify Checkout Image");
			SettingPage sp = hp.tapSettingsIcon();
			Assert.assertTrue(sp.verifyCustomerID(userName),"Failed to Verify Custumer ID");
			sp.tabChangeCustomerBtn();
			sp.enterNewUserId(userName+1);	
			sp.tabCancelBtn();
			Log.testCaseResult();
		} catch(Exception e){
 			Log.exception(e);
		} finally {			
			driver.quit();	
			Log.endTestCase();
		}
	}
	
}
