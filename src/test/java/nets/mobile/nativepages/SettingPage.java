package nets.mobile.nativepages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

//import nets.mobile.support.Log;
//import nets.mobile.support.WaitUtil;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import nets.mobile.support.BrowserActions;
import nets.mobile.support.Log;

public class SettingPage {

private MobileDriver<MobileElement> driver;
	
	@AndroidFindBy(id = "customer_id_label")
	MobileElement customerIdLabel;
	
	
	@AndroidFindBy(id = "change_customer_id")
	MobileElement changeCustomerBtn;
	
		
	@AndroidFindBy(xpath = "//android.widget.EditText")
	MobileElement editText;
	
	@AndroidFindBy(xpath = "android.widget.Button[@text='SAVE']")
	MobileElement saveBtn;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='CANCEL']")
	MobileElement cancelBtn;
			
	
	public SettingPage(MobileDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 500, TimeUnit.SECONDS), this);
	}
	
	/**
	 * Verify the customer ID from Setting Page
	 * @param user Name
	 */
	public boolean verifyCustomerID(String userName)
	{
		boolean status=false;
		String actual ="";
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			actual = customerIdLabel.getText();
			actual = actual.substring(3, 6);
			if(actual.equals(userName)) {
			Log.message("<b><font face='Comic Sans MS' color='#06014F'>Verified Customer ID successfully</font></b>",driver);
			status=true;}
		} catch (Exception e) {
	 		e.printStackTrace();
			Log.fail("unable to verify Customer ID", driver);
	  }
	return status;
	}
	
	/**
	 * Tab the Customer ID change Button from Setting Page
	 */
	public void tabChangeCustomerBtn()
	{
		try {
			BrowserActions.clickOnButton(changeCustomerBtn, driver, "Change Button");
		} catch (Exception e) {
	 		e.printStackTrace();
			Log.fail("Failed to tab change Customer id Btn", driver);
	  }
	}
	
	/**
	 * Edit the user name with new id from Setting Page
	 */
	public void enterNewUserId(String userName)
	{
		try {
			BrowserActions.typeOnTextField(editText, userName, driver, "Edit Text");
			} catch (Exception e) {
	 		e.printStackTrace();
			Log.fail("tap Edit text box is not available", driver);
	  }
	}

	/**
	 * Tab the cancel alter from Setting page
	 */
	public void tabCancelBtn(){
		try {
			BrowserActions.clickOnButton(cancelBtn, driver, "Cancel button");
			Log.message("<b><font face='Comic Sans MS' color='#06014F'>Tab Cancel Button</font></b>",driver);
			} catch (Exception e) {
	 		e.printStackTrace();
			Log.fail("tap Cancel button is not Visable", driver);
	  }
		
	}
		
}
