package aqa_exam.ui.po.wrapper;

import aqa_exam.DriverPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Date;

public class CustomInputElement {

    private static final Logger LOGGER = LogManager.getLogger(CustomInputElement.class);

    protected WebElement webElement;
    protected WebDriverWait wait = new WebDriverWait(DriverPool.getDriver(), Duration.ofSeconds(10));;

    public CustomInputElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public void waitForMeAndInput(String text) {
        LOGGER.debug("Attempting to input text into element: " + text);
        waitForMeInputable();
        sendKeys(text);
    }

    public void waitForMeInputable() {
        Date start = new Date();
        LOGGER.debug("Waiting for input element to be visible: " + webElement);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        long delay = new Date().getTime() - start.getTime();
        LOGGER.info("Input element became visible. Waiting time: " + delay + " ms.");
    }

    public void sendKeys(String text) {
        webElement.sendKeys(text);
        LOGGER.info("Sending keys to element: " + webElement + ". Text sent: " + text);
    }
}
