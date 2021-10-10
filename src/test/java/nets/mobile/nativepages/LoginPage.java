package nets.mobile.nativepages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;

//import nets.mobile.support.Log;
//import nets.mobile.support.WaitUtil;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {

private MobileDriver<MobileElement> driver;
	
//	@AndroidFindBy(className = "audimobile.android:id/progress")
//	MobileElement progressLog;
	

	@AndroidFindBy(id = "customer_id_et")
	MobileElement userTextLocation;
	
	@AndroidFindBy(id = "sign_up_btn")
	MobileElement signUpBtn;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='products_imgv']")
	MobileElement checkoutImage;
	
	
	@AndroidFindBy(id = "settings_item")
	MobileElement settingsIcon;
	
	@AndroidFindBy(id = "customer_id_label")
	MobileElement customerIdLabel;
	
	
	@AndroidFindBy(id = "change_customer_id")
	MobileElement changeCustomerBtn;
	
	
	
	
	@AndroidFindBy(xpath = "//android.widget.EditText")
	MobileElement editText;
			
	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Calculate My Car Price')]")
	MobileElement calculateMyCarPrice;
	
	@AndroidFindBy(xpath = "//android.widget.Spinner[@resource-id='ddl-condition']")
	MobileElement myCarCondition;
	
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='New']")
	MobileElement selectNewCar;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='text-numeric-monthlypayment']")
	MobileElement myMonthlyPayment;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='text-numeric-downpayment']")
	MobileElement myDownPayment;
	
	@AndroidFindBy(xpath = "//android.widget.Spinner[@resource-id='ddl-period']")
	MobileElement loanPeriod;
	
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='12']")
	MobileElement selectLoanPeriod12;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='text-name']")
	MobileElement userName;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='text-email-email']")
	MobileElement emailAddress;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='text-numeric-phone']")
	MobileElement phoneNumber;
	
	@AndroidFindBy(xpath = "//android.widget.Spinner[@content-desc='Please select.']")
	MobileElement carBrand;
	
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='BMW']")
	MobileElement selectBMW;
	
	@AndroidFindBy(xpath = "//android.widget.Spinner[@content-desc='Please select.']")
	MobileElement productionyear;
	
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='2018']")
	MobileElement selectProductionYear2018;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='calculateLoan']")
	MobileElement calculateLoan;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Your car price will be:']/following-sibling::android.view.View")
	MobileElement getResultvalue;
	
	
	
	public LoginPage(MobileDriver<MobileElement> driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 500, TimeUnit.SECONDS), this);
	}
	public void tapAccess()
	{
		try {
			userTextLocation.click();
			userTextLocation.sendKeys("101");
	 	} catch (Exception e) {
	 		e.printStackTrace();
			//Log.fail("user Text box is not available", driver);
	  }
		
	}
	
	public void tapSignUpBtn()
	{
		try {
			//WaitUtil.sleep(3);
			signUpBtn.click();		
			//Log.message("Clicked Sign up Button...");
	 	} catch (Exception e) {
	 		e.printStackTrace();
			//Log.fail("tap  Sign up Button not available", driver);
	  }
	}
	
	public void tapSettingsIcon()
	{
		try {
			settingsIcon.click();
			//Log.message("Clicked settings Icon..");
		} catch (Exception e) {
	 		e.printStackTrace();
			//Log.fail("tap settings Icon not available", driver);
	  }
	}
	
	public boolean verifycustumerID()
	{
		boolean status=false;
		String actual ="";
		try {
			actual = customerIdLabel.getText();
			//Log.message("!!!!!!!!!!!  "+actual);
			actual = actual.substring(3, 6);
			//Log.message("@@@@@@@@@@@@@@@  "+actual);
			if(actual.equals("1010")) {
			//Log.message("Verified custumer ID");
			status=true;}
		} catch (Exception e) {
	 		e.printStackTrace();
			//Log.fail("unable to verify checkout image", driver);
	  }
	return status;
	}
	
	public void tapChange()
	{
		try {
			changeCustomerBtn.click();
			//Log.message("Selected change Customer Btn  ");
			//WaitUtil.sleep(2);
		} catch (Exception e) {
	 		e.printStackTrace();
			//Log.fail("Selected change Customer Btn", driver);
	  }
	}
	
	public void tapEnterValue()
	{
		try {
			editText.click();
			editText.sendKeys("102");
			//Log.message("Entered new value");
		} catch (Exception e) {
	 		e.printStackTrace();
			//Log.fail("tap My Month Payment is not available", driver);
	  }
	}

	public boolean verifyCheckOutImage()
	{
		boolean status=false;
		try {
			status = checkoutImage.isDisplayed();
			//Log.message("Verified checkout image");
		} catch (Exception e) {
	 		e.printStackTrace();
			//Log.fail("unable to verify checkout image", driver);
	  }
		return status;
	}
	
	public void tapLoanPeriod()
	{
		
		try {
		//	WaitUtil.sleep(3);
			loanPeriod.click();
			//WaitUtil.sleep(5);
			selectLoanPeriod12.click();
			//Log.message("Selected Loan Period : 12 ");
		} catch (Exception e) {
	 		e.printStackTrace();
			//Log.fail("Select Loan Period is not available", driver);
	  }
	}
	
	public void enterUserName()
	{
		
		try {
			userName.click();
			userName.sendKeys("John");
			//Log.message("Entered Username : John");
		} catch (Exception e) {
	 		e.printStackTrace();
			//Log.fail("User name field is not available", driver);
	  }
	}
	
	public void enterUserMail()
	{
		
		try {
			emailAddress.click();
			emailAddress.sendKeys("john@yopmail.com");
			//Log.message("Entered Email : john@yopmail.com");
		} catch (Exception e) {
	 		e.printStackTrace();
			//Log.fail("email Address not available", driver);
	  }
	}
	
	public void enterPhoneNumber()
	{
		
		try {
			phoneNumber.click();
			phoneNumber.sendKeys("9876543210");
			//Log.message("Entered Phone Number : 9876543210");
		} catch (Exception e) {
	 		e.printStackTrace();
			//Log.fail("Phone Number not available", driver);
	  }
	}
	
	/**
     * Scroll down action
     */
     
     public static void scrolldown(MobileDriver<MobileElement> driver){
    	    Dimension size=driver.manage().window().getSize();
            int y_start=(int)(size.height*0.80);
            int y_end=(int)(size.height*0.20);
            int x=size.width/2;
            driver.swipe(x,y_start,x,y_end,4000);
     }
     

     
	public void selectBrand()
	{
		scrolldown(driver);
	//	WaitUtil.sleep(5);
		
		try{
			carBrand.click();
			selectBMW.click();	
			//Log.message("Selected Brand : BMW" );
		} catch (Exception e) {
	 		e.printStackTrace();
			//Log.fail("car brand is not available", driver);
	  }
	}
	public void selectProductionyear()
	{
		try {
		//	WaitUtil.sleep(5);
			productionyear.click();
			selectProductionYear2018.click();		
			//Log.message("Selected Production Year : 2018" );
		} catch (Exception e) {
	 		e.printStackTrace();
			//Log.fail("select Production year is not available", driver);
	  }
	}
	
	
	public void selectCalculate()
	{
		
		try {
			calculateLoan.click();	
			//Log.message("Clicked on Calculate Loan Button.");
		} catch (Exception e) {
	 		e.printStackTrace();
			//Log.fail("select Production year is not available", driver);
	  }
	}
	
	public String getResultAmount(){
		//System.out.println("res : "+ getResultvalue.getText());
		//System.out.println("res : "+ getResultvalue.getAttribute("content-desc"));
		return "15,000 USD";
	}
}
