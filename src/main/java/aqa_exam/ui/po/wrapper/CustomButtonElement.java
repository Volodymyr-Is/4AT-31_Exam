package aqa_exam.ui.po.wrapper;

import aqa_exam.DriverPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Date;

public class CustomButtonElement {

    private static final Logger LOGGER = LogManager.getLogger(CustomButtonElement.class);

    protected WebElement webElement;
    protected WebDriverWait wait = new WebDriverWait(DriverPool.getDriver(), Duration.ofSeconds(10));;

    public CustomButtonElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public void waitForMeAndClick() {
        LOGGER.debug("Attempting to click button element.");
        waitForMeClickable();
        click();
    }

    public void waitForMeClickable() {
        Date start = new Date();
        LOGGER.debug("Waiting for element to be visible: " + webElement);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        long delay = new Date().getTime() - start.getTime();
        LOGGER.info("Element became visible. Waiting time: " + delay + " ms.");
    }

    public void click() {
        webElement.click();
        LOGGER.info("Clicked on element: " + webElement);
    }

    public boolean isDisplayed(){
        return webElement.isDisplayed();
    }
}
