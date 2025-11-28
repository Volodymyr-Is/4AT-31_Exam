package aqa_exam.ui.po.wrapper;

import aqa_exam.DriverPool;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Date;

public class CustomInputElement {

    protected WebElement webElement;
    protected WebDriverWait wait = new WebDriverWait(DriverPool.getDriver(), Duration.ofSeconds(10));;

    public CustomInputElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public void waitForMeAndInput(String text) {
        waitForMeInputable();
        sendKeys(text);
    }

    public void waitForMeInputable() {
        Date start = new Date();
        wait.until(ExpectedConditions.visibilityOf(webElement));
        long delay = new Date().getTime() - start.getTime();
        System.out.println("Visible [Waiting time:" + delay + "]");
    }

    public void sendKeys(String text) {
        webElement.sendKeys(text);
        System.out.println("Click");
        //todo logger
    }
}
