package resources;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Utilities {
	
	public static String getScreenshot(WebDriver driver, String testName) throws IOException
	{
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File screenshot = takeScreenshot.getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir") + "\\reports\\" + testName + ".png";
		FileUtils.copyFile(screenshot, new File(screenshotPath));
		return screenshotPath;
	}
	
	public static void configureExtentReport(ExtentReports extentReport)
	{
		// Configure path in which extent report should be stored
		String reportPath = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter extentReportConfig = new ExtentSparkReporter(reportPath);
		
		// Configure extent report name
		extentReportConfig.config().setReportName("RS Academy Extent Report");
		
		// Configure extent report document name
		extentReportConfig.config().setDocumentTitle("RS Academy Test Report");
		
		// Instantiate ExtentReports object
		//ExtentReports extentReport = new ExtentReports();
		
		// Assign config to extent report
		extentReport.attachReporter(extentReportConfig);
		
		// Set 'Tester' property to extent report
		extentReport.setSystemInfo("Tester", "Khalid N");
		
		//return extentReport;
	}
}
