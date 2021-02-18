package e2e_tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Utilities;

public class Listeners implements ITestListener {

	public ExtentReports extentReport = new ExtentReports();
	public String testName;
	public ThreadLocal<String> testNamePool = new ThreadLocal<String>();
	public ExtentTest extentTest;
	public ThreadLocal<ExtentTest> extentTestPool = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		Utilities.configureExtentReport(extentReport);
		testName = result.getMethod().getMethodName();
		testNamePool.set(testName);
		extentTest = extentReport.createTest(testNamePool.get());
		extentTestPool.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTestPool.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTestPool.get().fail(result.getThrowable());
		WebDriver driver = null;
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			extentTestPool.get().addScreenCaptureFromPath(Utilities.getScreenshot(driver, testNamePool.get()), testNamePool.get());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extentReport.flush();
	}

}
