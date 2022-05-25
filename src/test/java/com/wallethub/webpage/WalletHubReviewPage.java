package com.wallethub.webpage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.wallethub.utils.Constants;
import com.wallethub.utils.PageActions;
import com.wallethub.utils.UIMap;

public class WalletHubReviewPage extends PageActions {

	public static String workingDir = System.getProperty("user.dir");
	public static UIMap uimap = new UIMap(workingDir + "/resources/WalletHubReviewPage.properties");

	/**
	 * On the Wallethub Review Page, click on Stars button
	 */

	public void selecteStarReview() throws Exception {
		// Locating the Main Menu (Parent element)
		try {
			WebElement mainMenu = driver.findElement(
					By.xpath("//review-star[@class='rvs-svg']//div[@class='rating-box-wrapper']//*[name()='svg']"));

			scrollElementIntoView(mainMenu);
			waitThreeSeconds();
			// Instantiating Actions class
			Actions actions = new Actions(driver);

			actions.moveToElement(mainMenu);
			waitThreeSeconds();

			// Locating the element from Sub Menu
			WebElement subMenu = driver.findElement(By.xpath(
					"/html[1]/body[1]/web-app[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[3]/section[1]/div[2]/div[3]/review-star[1]/div[1]/*[name()='svg'][4]"));

			// To mouseover on sub menu
			actions.moveToElement(subMenu);
			waitThreeSeconds();
			actions.click().build().perform();
			waitThreeSeconds();
		} catch (NoSuchElementException e) {
		}
	}

	/**
	 * On the Test Insurance Company Page, click on Dropdown button
	 */

	public void chooseHealthInsurance() throws Throwable {
		try {
			waitThreeSeconds();
			WebElement clickDropdown = driver.findElement(uimap.getLocator("click_healthInsurance_dd"));
			click_custom(clickDropdown, Constants.WH_CLICK_ON_HEALTHINSURANCE_DROPDOWN);
			log.info(Constants.WH_CLICK_ON_HEALTHINSURANCE_DROPDOWN);
			waitThreeSeconds();
			// selectDropDownByVisibleText_custom(dd, "Health Insurance");
			WebElement selectHealthInsurance = driver.findElement(uimap.getLocator("select_health_insurance_from_dd"));
			click_custom(selectHealthInsurance, Constants.WH_SELECT_HEALTHINSURANCE_FROM_DROPDOWN_LIST);
			log.info(Constants.WH_SELECT_HEALTHINSURANCE_FROM_DROPDOWN_LIST);
		} catch (NoSuchElementException e) {
			e.getMessage();
		}
	}

	/**
	 * Enter Review Message On the Test Insurance Company Page
	 */

	public void writeReview(String writeReviewText) throws Exception {
		try {
			WebElement reviewText = driver.findElement(uimap.getLocator("click_review_text_area"));
			click_custom(reviewText, Constants.WH_WRITE_REVIEW_MESSAGE);
			sendKeys_custom(reviewText, Constants.WH_WRITE_REVIEW_MESSAGE, writeReviewText);
		} catch (NoSuchElementException e) {
			e.getMessage();
		}
	}

	/**
	 * Click Submit review button
	 */

	public void clickReviewSubmitButton() throws Exception {
		try {
			WebElement submitButton = driver.findElement(uimap.getLocator("click_submit_button"));
			click_custom(submitButton, Constants.WH_CLICK_REVIEW_SUBMIT_BUTTON);
			log.info(Constants.WH_CLICK_REVIEW_SUBMIT_BUTTON);
			waitTime();
		} catch (NoSuchElementException e) {
			e.getMessage();
		}
	}

	/**
	 * Click Profile Menu on Confirn Review Page
	 */

	public void clickProfileMenu() throws Exception {
		try {
			WebElement profileName = driver.findElement(uimap.getLocator("click_profile_name"));
			Actions action = new Actions(driver);
			action.moveToElement(profileName).perform();
			WebElement clickProfile = driver.findElement(uimap.getLocator("click_profile"));
			action.moveToElement(clickProfile).click().perform();
		} catch (NoSuchElementException e) {
		}
	}

	/**
	 * Click Updated Review Link on Confirn Review Page
	 */
	public void clickUpdatedReviewLink() throws Throwable {
		try {
			WebElement updatedReviewLink = driver.findElement(uimap.getLocator("click_updated_review_link"));
			click_custom(updatedReviewLink, Constants.WH_CLICK_UPDATED_REVIEW_LINK);
			log.info(Constants.WH_CLICK_UPDATED_REVIEW_LINK);
		}

		catch (NoSuchElementException e) {
			e.getMessage();
		}

	}

	/**
	 * Verify Updated Review Message on Review home page
	 */
	public String verifyUpdatedReviewMessageOnMainPage() throws Throwable {
		try {
			WebElement updatedReviewMessage = driver
					.findElement(uimap.getLocator("get_updated_review_message_homepage"));

			String getupdatedReviewMessage = getText_custom(updatedReviewMessage,
					Constants.WH_GET_UPDATED_REVIEW_ON_HOMEPAGE);
			log.info(Constants.WH_CLICK_UPDATED_REVIEW_LINK + getupdatedReviewMessage);
			waitTime();
			return getupdatedReviewMessage;
		} catch (NoSuchElementException e) {
			e.getMessage();
		}
		return null;
	}

	/**
	 * Clear Updated Review Message on Review home page
	 */
	public void clearAddedReviewMessage() throws Throwable {
		try {
			WebElement clickEditReview = driver.findElement(uimap.getLocator("click_review_edit"));
			scrollElementIntoView(clickEditReview);
			waitThreeSeconds();
			click_custom(clickEditReview, Constants.WH_CLICK_EDIT_REVIEW_BUTTON);
			log.info(Constants.WH_CLICK_EDIT_REVIEW_BUTTON);

			WebElement reviewEditTextBox = driver.findElement(uimap.getLocator("select_updated_review"));
			reviewEditTextBox.sendKeys(Keys.chord(Keys.COMMAND, "A"));
			waitThreeSeconds();
			reviewEditTextBox.sendKeys(Keys.chord(Keys.DELETE));

		}

		catch (NoSuchElementException e) {
			e.getMessage();
		}

	}

	/**
	 * Click submit button after review edit
	 */
	public void clickSubmitButtonAfterReviewEdit() throws Throwable {
		try {
			WebElement clickEditReview = driver.findElement(uimap.getLocator("click_edit_review_submit_button"));
			waitThreeSeconds();
			click_custom(clickEditReview, Constants.WH_CLICK_SUBMIT_AFTER_REVIEW_EDIT);
			log.info(Constants.WH_CLICK_SUBMIT_AFTER_REVIEW_EDIT);

		}

		catch (NoSuchElementException e) {
			e.getMessage();
		}

	}

}
