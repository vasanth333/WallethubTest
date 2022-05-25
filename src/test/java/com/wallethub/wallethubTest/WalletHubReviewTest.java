package com.wallethub.wallethubTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wallethub.testdata.TestData;
import com.wallethub.utils.TestBase;
import com.wallethub.webpage.FacebookLoginPage;
import com.wallethub.webpage.WalletHubLoginPage;
import com.wallethub.webpage.WalletHubReviewPage;

public class WalletHubReviewTest extends TestBase {
	TestData testData = new TestData();
	FacebookLoginPage fbPage = new FacebookLoginPage();
	WalletHubLoginPage walletHubLoginPage = new WalletHubLoginPage();
	WalletHubReviewPage walletHubReviewPage = new WalletHubReviewPage();

	@Test()
	public void walletHubReviewTest() throws Throwable {
		String email = testData.exceldata("Test_01", "walletHubEmail");
		String password = testData.exceldata("Test_01", "walletHubPassword");
		String postText = testData.exceldata("Test_01", "postMessage");
		String reviewText = testData.exceldata("Test_01", "reviewMessage");

		walletHubLoginPage.clickLoginOrSignupButton();
		walletHubLoginPage.enterUsername(email);
		walletHubLoginPage.enterPassword(password);
		walletHubLoginPage.clickLogin();
		walletHubReviewPage.selecteStarReview();
		walletHubReviewPage.chooseHealthInsurance();
		walletHubReviewPage.writeReview(reviewText);
		walletHubReviewPage.clickReviewSubmitButton();
		walletHubReviewPage.clickProfileMenu();
		walletHubReviewPage.clickUpdatedReviewLink();
		String updatedReviewMessage = walletHubReviewPage.verifyUpdatedReviewMessageOnMainPage();
		Assert.assertEquals(updatedReviewMessage, reviewText);

		// the Review stars are no longer present after the Review has been updated,
		// additional steps added to clear the added review for the next Test iteration
		// have been added.

		walletHubReviewPage.clearAddedReviewMessage();
		walletHubReviewPage.clickSubmitButtonAfterReviewEdit();

	}

}
