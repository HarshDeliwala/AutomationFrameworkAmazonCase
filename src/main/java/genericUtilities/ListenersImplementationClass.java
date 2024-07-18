package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListener interface of testNG
 * @author harshdeliwala
 *
 */
public class ListenersImplementationClass implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+" ==== test script execution started ====");
		
		//create a test script - recognise each @Test
		test = report.createTest(testScriptName);
	
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+" ==== Passed ====");
		
		//Log the success
		test.log(Status.PASS, testScriptName+" == PASS ==");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		//ScreenShot
		//Exception for failure
		
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+" ==== Failed ====");
		
		//Exception for failure
		System.out.println(result.getThrowable());
		
		//log for failure
		test.log(Status.FAIL, testScriptName+" == Fail ==");
		test.log(Status.INFO, result.getThrowable());
		
		//Screenshot
		String screenShotName = testScriptName + new JavaUtility().getSystemDate();
		
		WebDriverUtility w = new WebDriverUtility();
		
		try {
			
			String path = w.captureScreenShot(BaseClass.sdriver, screenShotName);
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+" ==== Skipped ====");
		
		//Exception for failure
		System.out.println(result.getThrowable());
		
		//log for Skip
		test.log(Status.SKIP, testScriptName+" == skipped ==");
		test.log(Status.INFO, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("==== Suite Execution Started ====");
		
        //Basic Report configuration //Report-17-10-2023-20-04-20.html
		ExtentSparkReporter html = new ExtentSparkReporter(System.getProperty("user.dir")+"/ExtentReports-"+new JavaUtility().getSystemDate()+".html");
		html.config().setTheme(Theme.STANDARD);
		html.config().setDocumentTitle("Execution Report");
		html.config().setReportName("KGL Amazon Execution Report");
		
	    report = new ExtentReports();
		report.attachReporter(html);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base Platform", "Mac");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Reporter Name", "Harsh");
		
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("==== Suite Execution Finished ====");
		
		//Report generation
		report.flush();
		
		
	}

}
