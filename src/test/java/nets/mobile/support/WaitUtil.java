package nets.mobile.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil  {
	private static EnvironmentPropertiesReader configProperty = EnvironmentPropertiesReader.getInstance();
	private static int maxElementWait = Integer.parseInt(configProperty.getProperty("maxElementWait"));
	
	public static boolean isElementPresent(WebElement element) {
		try {
			element.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * To wait for the specific element on the page
	 * 
	 * @param driver -
	 * @param element - mob element to wait for to appear
	 * @return boolean - return true if element is present else return false
	 */
	public static boolean waitForElement(WebDriver driver,  WebElement element) {
		return waitForElement(driver, element, maxElementWait);
	}

	/**
	 * To wait for the specific element on the page
	 * 
	 * @param driver -
	 * @param element - mob element to wait for to appear
	 * @param maxWait - how long to wait for
	 * @return boolean - return true if element is present else return false
	 */

	public static boolean waitForElement(WebDriver driver, WebElement element, int maxWait) {
		boolean statusOfElementToBeReturned = false;
		WebDriverWait wait = new WebDriverWait(driver, maxWait);
		try{
			WebElement waitElement = wait.until(ExpectedConditions.visibilityOf(element));
			if (waitElement.isDisplayed() && waitElement.isEnabled())
			{
				statusOfElementToBeReturned = true;
				Log.event("Element is displayed: " +  element.toString());
			}
		}catch (Exception ex)
		{
			statusOfElementToBeReturned = false;
		}
		return statusOfElementToBeReturned;
	}

	/**
	 * To wait for the specific Time delay on the page
	 * 
	 * @param time in sec -
	 */

	public static void sleep(int waitTimeInSec) {
		try {
			Thread.sleep(waitTimeInSec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
