package com.wallethub.webpage;

import org.openqa.selenium.WebElement;

import com.wallethub.utils.Constants;
import com.wallethub.utils.PageActions;
import com.wallethub.utils.UIMap;

public class FacebookLoginPage extends PageActions {

	public static String workingDir = System.getProperty("user.dir");

	public static UIMap uimap = new UIMap(workingDir + "/resources/FBPostPage.properties");

	/**
	 * Enter Email in Facebook login page
	 */
	public void enterEmailid(String strUsername) throws Exception {
		try {
			WebElement email = driver.findElement(uimap.getLocator("email_field"));
			waitForVisibility(email, Constants.WAIT_FIVE_SECONDS);
			sendKeys_custom(email, Constants.FB_LOGIN_ENTER_EMAIL_ID, strUsername);
			log.info(Constants.FB_LOGIN_ENTER_EMAIL_ID + strUsername);
		} catch (Exception e) {
			e.getMessage();

		}
	}

	/**
	 * Enter Password in Facebook login page
	 */
	public void enterPassword(String strPassword) throws Exception {
		try {
			WebElement password = driver.findElement(uimap.getLocator("password_field"));
			waitForVisibility(password, Constants.WAIT_TWO_SECONDS);
			sendKeys_custom(password, Constants.FB_LOGIN_ENTER_PASSWORD, strPassword);
			log.info(Constants.FB_LOGIN_ENTER_PASSWORD + strPassword);

		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * Click Signin button in Facebook login page
	 */
	public void clickSignin() throws Exception {
		try {
			WebElement signinButton = driver.findElement(uimap.getLocator("signin_button"));
			click_custom(signinButton, Constants.FB_CLICK_ON_SIGNIN_BUTTON);
			log.info(Constants.FB_CLICK_ON_SIGNIN_BUTTON);

		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * Click on Facebook logo icon on home page
	 */
	public void clickonFbLogo() throws Exception {
		try {
			WebElement clickonFbLogo = driver.findElement(uimap.getLocator("click_fb_logo"));
			waitTime();
			click_custom(clickonFbLogo, Constants.FB_CLICK_ON_FB_LOGO);
			log.info(Constants.FB_CLICK_ON_FB_LOGO);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * Click PostMessage text box on Fb home page
	 */
	public void clickPostTextBox() throws Exception {
		try {

			WebElement clickPostTextBox = driver.findElement(uimap.getLocator("click_post_textBox"));
			waitForVisibility(clickPostTextBox, Constants.WAIT_TEN_SECONDS);
			click_custom(clickPostTextBox, Constants.FB_CLICK_ON_POST_TEXT_BOX_AREA);
			log.info(Constants.FB_CLICK_ON_POST_TEXT_BOX_AREA);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * Enter Message on Post Message on fb home page
	 */
	public void enterPostMessage(String strPostmsg) throws Exception {
		try {
			WebElement postmsg = driver.findElement(uimap.getLocator("enter_post_message"));
			waitForVisibility(postmsg, Constants.WAIT_FIVE_SECONDS);
			sendKeys_custom(postmsg, Constants.FB_ENTER_POST_MESSAGE, strPostmsg);
			log.info(Constants.FB_ENTER_POST_MESSAGE);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * Click Post Message button on fb home page
	 */

	public void clickPostMessageButton() throws Exception {
		try {
			WebElement clickonFbLogo = driver.findElement(uimap.getLocator("click_post_message_button"));
			waitForVisibility(clickonFbLogo, Constants.WAIT_FIVE_SECONDS);
			click_custom(clickonFbLogo, Constants.FB_CLICK_ON_POST_MESSAGE_BUTTON);
			log.info(Constants.FB_CLICK_ON_POST_MESSAGE_BUTTON);
			waitTime();
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
