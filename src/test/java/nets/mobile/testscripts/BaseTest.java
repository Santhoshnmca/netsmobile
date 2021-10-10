package nets.mobile.testscripts;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import nets.mobile.support.EmailReport;
import nets.mobile.support.EnvironmentPropertiesReader;
import nets.mobile.support.Log;

@Listeners(EmailReport.class)
public class BaseTest {
	EnvironmentPropertiesReader properties = EnvironmentPropertiesReader.getInstance();
	String url;
	String searchSite;

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {
		System.getProperties().put("hubHost", properties.getDeviceHost());
		System.getProperties().put("devicePort", properties.getDevicePort());
	}

	public MobileDriver<MobileElement> createDriverForAndroid() {
		MobileDriver<MobileElement> driver = null;

		File path = new File("./src/main/resources/APK/pia-sdk-android-release-sample-2.4.0.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "AndroidSDKbuild");
		capabilities.setCapability("platformVersion", "10.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);
		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("app", path.getAbsolutePath());
		capabilities.setCapability("appWaitActivity",
				"SplashActivity, SplashActivity,OtherActivity, *, *.SplashActivity");

		// Created object of RemoteWebDriver will all set capabilities.
		// Set appium server address and port number in URL string.
		// It will launch calculator app in android device.
		try {
			Log.message("Open to Nets Mobile App..");
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		return driver;
	}

}
