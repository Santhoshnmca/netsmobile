package nets.mobile.support;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;

/**
 * Wrapper for Selenium WebDriver actions which will be performed on browser
 * 
 * Wrappers are provided with exception handling which throws Skip Exception on occurrence of NoSuchElementException
 * 
 */
public class BrowserActions {

	/**
	 * Wrapper to type a text in browser text field
	 * 
	 * @param txt
	 *            : WebElement of the Text Field
	 * @param txtToType
	 *            : Text to type [String]
	 * @param driver
	 *            : WebDriver Instances
	 * @param elementDescription
	 *            : Description about the WebElement
	 */
	public static void typeOnTextField(WebElement txt, String txtToType, WebDriver driver, String elementDescription) {
		if (!WaitUtil.waitForElement(driver, txt))
			throw new SkipException(elementDescription + " field not found in page!!");

		try {
			Log.event("Entering value into textfield: " + elementDescription);
			Log.message("Entering text : "+ txtToType);
			txt.clear();
			txt.click();
			txt.sendKeys(txtToType);
			Log.event("Entered text : "+ txtToType);
		}
		catch (NoSuchElementException e) {
			throw new SkipException(elementDescription + " field not found in page!!");
		}
	}

	/**
	 * Wrapper to click on button/text/radio/checkbox in browser
	 * 
	 * @param btn
	 *            : WebElement of the Button Field
	 * @param driver
	 *            : WebDriver Instances
	 * @param elementDescription
	 *            : Description about the WebElement
	 */
	public static void clickOnButton(WebElement btn, WebDriver driver, String elementDescription) {
		if (!WaitUtil.waitForElement(driver, btn))
			throw new SkipException(elementDescription + " not found in page!!");

		try {
			Log.event("Clicking on element - " + elementDescription);
			btn.click();
			Log.event(elementDescription + " is clicked!");
		} catch (NoSuchElementException e) {
			throw new SkipException(elementDescription + " not found in page!!");
		}

	}


	/**
	 * Wrapper to check element visibility
	 * 
	 * @param driver
	 *            : WebDriver Instance
	 * @param cssSelectorForWebElement
	 *            : CSS Selector of the WebElement which visibility to check in String format
	 * @return: Boolean form - True if element visible/ False if element not visible
	 */
	public static boolean elementDisplayed(WebDriver driver, String cssSelectorForWebElement) {
		boolean displayed = false;

		try {
			displayed = driver.findElement(By.cssSelector(cssSelectorForWebElement)).isDisplayed();
		} catch (NoSuchElementException e) {
		}
		return displayed;
	}

	/**
	 * Wrapper to get a text from the provided WebElement
	 * 
	 * @param driver
	 *            : WebDriver Instance
	 * @param fromWhichTxtShldExtract
	 *            : WebElement from which text to be extract in String format
	 * @return: String - text from web element
	 * @param elementDescription
	 *            : Description about the WebElement
	 */
	public static String getText(WebDriver driver, WebElement fromWhichTxtShldExtract, String elementDescription) {
		String textFromHTMLAttribute = "";

		try {
			textFromHTMLAttribute = fromWhichTxtShldExtract.getText();

			if (textFromHTMLAttribute.isEmpty())
				textFromHTMLAttribute = fromWhichTxtShldExtract.getAttribute("textContent");

		} catch (NoSuchElementException e) {
			throw new SkipException(elementDescription + " not found in page!!");
		}
		return textFromHTMLAttribute;
	}

	/**
	 * Wrapper to get a text from the provided WebElement
	 * 
	 * @param driver
	 *            : WebDriver Instance
	 * @param fromWhichTxtShldExtract
	 *            : String Input (CSS Locator) [from which text to be extract in String format]
	 * @return: String - text from web element
	 * @param elementDescription
	 *            : Description about the WebElement
	 */
	public static String getText(WebDriver driver, String fromWhichTxtShldExtract, String elementDescription) {
		String textFromHTMLAttribute = "";
		WebElement element = driver.findElement(By.cssSelector(fromWhichTxtShldExtract));

		try {
			textFromHTMLAttribute = element.getText();

			if (textFromHTMLAttribute.isEmpty())
				textFromHTMLAttribute = element.getAttribute("textContent");

		} catch (NoSuchElementException e) {
			throw new SkipException(elementDescription + " not found in page!!");
		}
		return textFromHTMLAttribute;
	}


}
