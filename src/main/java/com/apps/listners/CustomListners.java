package com.apps.listners;

import java.io.IOException;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.apps.base.Page;

import com.apps.utilities.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class CustomListners extends Page implements ITestListener {

	public void onTestStart(ITestResult result) {
		
		test=rep.startTest(result.getName().toUpperCase());
		
	}

	public void onTestSuccess(ITestResult result) {
			test.log(LogStatus.PASS, result.getName().toUpperCase()+": PASS");
			rep.endTest(test);
			rep.flush();
	}

	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false") ;
		
	try {
		TestUtil.captureScreenshot();
	} catch (IOException e) {
		e.printStackTrace();
	}
	test.log(LogStatus.FAIL, result.getName().toUpperCase()+"Failed with Exception : "+result.getThrowable());
	test.log(LogStatus.FAIL,test.addScreenCapture(TestUtil.screenShotName));
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenShotName+">screenshot</a>");
		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenShotName+"><img src="+TestUtil.screenShotName+" height=200 width=200></a>");
		
		
		rep.endTest(test);
		rep.flush();
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}

}
