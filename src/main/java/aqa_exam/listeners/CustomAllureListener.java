package aqa_exam.listeners;

import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static aqa_exam.DriverPool.getDriver;

public class CustomAllureListener implements ITestListener, IInvokedMethodListener {

    private static final Logger LOGGER = LogManager.getLogger(CustomAllureListener.class);

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("Test Success: " + result.getName() + ". Attaching screenshot and DOM to Allure report.");
        ITestListener.super.onTestSuccess(result);
        makeScreenshotAttachment();
        makeDOMAttachment();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.error("Test Failure: " + result.getName() + ". Attaching screenshot and DOM to Allure report.");
        ITestListener.super.onTestFailure(result);
        makeScreenshotAttachment();
        makeDOMAttachment();
    }

    @Attachment(value="Page screenshot", type="image/png")
    private byte[] makeScreenshotAttachment(){
        LOGGER.debug("Attempting to capture screenshot...");
        return ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value="{0}", type="text/plain")
    private String makeDOMAttachment() {
        LOGGER.debug("Attempting to capture DOM source.");
        return getDriver().getPageSource();
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        IInvokedMethodListener.super.afterInvocation(method, testResult);
        if(testResult.getStatus() == ITestResult.FAILURE){
            makeScreenshotAttachment();
            makeDOMAttachment();
        }
    }
}
