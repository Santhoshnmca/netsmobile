package nets.mobile.testscripts;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
//import com.bankaudi.support.EmailReport;
import nets.mobile.support.EnvironmentPropertiesReader;
//import com.bankaudi.support.Log;

//@Listeners(EmailReport.class)
public class BaseTest {
	EnvironmentPropertiesReader properties = EnvironmentPropertiesReader.getInstance();
	String url;
	String searchSite;

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {		
		url = properties.getURL();
		System.getProperties().put("hubHost", properties.getDeviceHost());
		System.getProperties().put("devicePort", properties.getDevicePort());		
	}

	public MobileDriver<MobileElement> createDriverForAndroid()
	{
		MobileDriver<MobileElement> driver = null;	
		
		File path = new File("./src/main/resources/APK/pia-sdk-android-release-sample-2.4.0.apk"); 
			
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "AndroidSDKbuild");
		capabilities.setCapability("platformVersion", "10.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);
		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("app", path.getAbsolutePath());
		capabilities.setCapability("appWaitActivity", "SplashActivity, SplashActivity,OtherActivity, *, *.SplashActivity");
	
			
//		
//		// Created object of DesiredCapabilities class.
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//
//		// Set android deviceName desired capability. Set your device name.
//		capabilities.setCapability("deviceName", "42008156f0d61459");
//
//		// Set BROWSER_NAME desired capability. It's Android in our case here.
//		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
//
//		// Set android VERSION desired capability. Set your mobile device's OS version.
//		capabilities.setCapability(CapabilityType.VERSION, "6.0.1");
//
//		// Set android platformName desired capability. It's Android in our case here.
//		capabilities.setCapability("platformName", "Android");

		

		// Created object of RemoteWebDriver will all set capabilities.
		// Set appium server address and port number in URL string.
		// It will launch calculator app in android device.
		try {
			//Log.message("Navigating to Nets Login Screen..");
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		return driver;
	}

}
