package com.wallethub.webpage;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.wallethub.utils.Constants;
import com.wallethub.utils.PageActions;
import com.wallethub.utils.UIMap;

public class WalletHubLoginPage extends PageActions {

	public static String workingDir = System.getProperty("user.dir");
	public static UIMap uimap = new UIMap(workingDir + "/resources/WalletHubLoginPage.properties");

	
	
	/**
	 * On the Wallethub website, click the Login| Signup button.
	 */

	public void clickLoginOrSignupButton() throws Exception {
		try {
			WebElement signinButton = driver.findElement(uimap.getLocator("click_login_Signup_button"));
			waitForVisibility(signinButton, Constants.WAIT_FIVE_SECONDS);
			click_custom(signinButton, Constants.WH_CLICK_LOGIN_OR_SIGNUP_BUTTON);
			log.info(Constants.WH_CLICK_LOGIN_OR_SIGNUP_BUTTON);
		} catch (NoSuchElementException e) {
			e.getMessage();
		}
	}

	
	
	/**
	 * Enter Email id On the Wallethub Login page
	 */

	public void enterUsername(String strUsername) throws Exception {
		try {
			WebElement email = driver.findElement(uimap.getLocator("email_field"));
			sendKeys_custom(email, Constants.WH_LOGIN_ENTER_EMAIL_ID, strUsername);
			log.info(Constants.WH_LOGIN_ENTER_EMAIL_ID + strUsername);
		} catch (NoSuchElementException e) {
			e.getMessage();
		}
	}

	
	/**
	 * Enter Password id On the Wallethub Login page
	 */

	public void enterPassword(String strPassword) throws Exception {
		try {
			WebElement email = driver.findElement(uimap.getLocator("password_field"));
			sendKeys_custom(email, Constants.WH_LOGIN_ENTER_PASSWORD, strPassword);
			log.info(Constants.WH_LOGIN_ENTER_PASSWORD + strPassword);
		} catch (NoSuchElementException e) {e.getMessage();
		}
	}

	/**
	 * On the Wallethub website, click on Login Button
	 */
	public void clickLogin() throws Exception {
		try {
			WebElement signinButton = driver.findElement(uimap.getLocator("click_login_button"));
			click_custom(signinButton, Constants.WH_CLICK_LOGIN_BUTTON);
			log.info(Constants.WH_CLICK_LOGIN_BUTTON);
			waitTime();
		}

		catch (NoSuchElementException e) {
			e.getMessage();
		}
	}

}