package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import factory.driverFactory;
import utils.ExtentManager;
import utils.Screenshotutils;

public class TestListener implements ITestListener {

    ExtentManager extentManager = new ExtentManager();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = ExtentManager.getExtentReport().createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        String testName = result.getName();

        String screenshotPath = Screenshotutils.captureScreenshot(
                driverFactory.getDriver(),
                testName
        );

        test.fail("Test Failed");

        try {
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {

        ExtentManager.getExtentReport().flush();
    }
}