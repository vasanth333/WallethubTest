package com.wallethub.testlisteners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.wallethub.utils.UIMap;

public class Retry implements IRetryAnalyzer {

	public static String workingDir = System.getProperty("user.dir");
	public static UIMap maxRetryCount = new UIMap(workingDir + "/src/test/resources/config.properties");

	private int count = 0;
	private static int maxRetry = 1;

	@Override
	public boolean retry(ITestResult iTestResult) {
		if (!iTestResult.isSuccess()) {
			if (count < maxRetry) {
				count++;
				iTestResult.setStatus(ITestResult.FAILURE);
				return true;
			} else {
				iTestResult.setStatus(ITestResult.FAILURE);
			}
		} else {
			iTestResult.setStatus(ITestResult.SUCCESS);
		}
		return false;
	}
}