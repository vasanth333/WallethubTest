package com.wallethub.wallethubTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.wallethub.testdata.TestData;
import com.wallethub.utils.Constants;
import com.wallethub.utils.PageActions;
import com.wallethub.utils.TestBase;
import com.wallethub.webpage.FacebookLoginPage;

public class FacebookPostMessage extends TestBase {
	TestData testData = new TestData();
	FacebookLoginPage fbPage = new FacebookLoginPage();
	PageActions pageActions = new PageActions();
	protected static Logger log = LogManager.getLogger();

	@Test()
	public void facebookPostMessage() throws Throwable {
		String email = testData.exceldata("Test_01", "email");
		String password = testData.exceldata("Test_01", "password");
		String postText = testData.exceldata("Test_01", "postMessage");
		log.info("Main Test Execution");
		fbPage.enterEmailid(email);
		fbPage.enterPassword(password);
		fbPage.clickSignin();
		fbPage.clickonFbLogo();
		fbPage.clickPostTextBox();
		fbPage.enterPostMessage(postText);
		fbPage.clickPostMessageButton();
	}

}
