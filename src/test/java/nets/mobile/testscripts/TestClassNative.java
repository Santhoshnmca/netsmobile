package nets.mobile.testscripts;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

//import nets.mobile.nativepages.HomePage;
//import nets.mobile.support.DataProviderUtils;
//import nets.mobile.support.WaitUtil;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import nets.mobile.nativepages.LoginPage;

public class TestClassNative extends BaseTest{

	@Test(description="Verify Nets Mobile Native Application Functionality")
	public void loginNetsAPP() {
		
	//	Log.testCaseInfo("Sample Nets App..");

		MobileDriver<MobileElement> driver = null;
		
		try {
			//driver = WebDriverFactory.get(browser);
			driver = createDriverForAndroid();	
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			LoginPage wp = new LoginPage(driver);
			wp.tapAccess();
			wp.tapSignUpBtn();
			//assertTrue(wp.verifyCheckOutImage(),"true");
			wp.tapSettingsIcon();
			//Assert.assertTrue(wp.verifycustumerID(),"Failed");
			
			wp.tapChange();
			wp.tapEnterValue();
			
		//	WaitUtil.sleep(5);
//			Log.message("<b><font face='Comic Sans MS' color='#06014F'>Expected Result:</font></b>");
//			Log.message("<font face='Calibri' color='black'>Monthly payment should be calculated properly as expected.</font>");
//			Log.message("<b><font face='Comic Sans MS' color='#06014F'>Actual Result:</font></b>");
//			Log.message("<font face='Calibri' color='black'>Monthly Payment(in USD) : <b>"+ wp.getResultAmount()+"</b> is disaplayed!</font>", driver);
//			Log.testCaseResult();
		} catch(Exception e){
 			//Log.exception(e);
		} finally {
			
			driver.quit();	
		//	Log.endTestCase();
		}
	}
}
