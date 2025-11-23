package aqa_exam.ui.po.wrapper;

import aqa_exam.DriverPool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Element {

    protected WebElement webElement;
    protected WebDriver driver;
    protected WebDriverWait wait;

    public Element(WebElement webElement) {
        this.webElement = webElement;
        this.driver = DriverPool.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement waitUntilVisible() {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}
