package aqa_exam.ui.po.wrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomWebElementButton extends Element {

    public CustomWebElementButton(WebElement webElement) {
        super(webElement);
    }

    @Override
    public WebElement waitUntilVisible() {
        return super.waitUntilVisible();
    }

    public void click() {
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }
}

//{
//
//    private final ElementLocator locator;
//    private final WebDriverWait wait;
//
//    public CustomWebElementButton(ElementLocator locator, WebDriverWait wait) {
//        this.locator = locator;
//        this.wait = wait;
//    }
//
//    public void click() {
//        wait.until(ExpectedConditions.visibilityOf(locator.findElement()));
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator.findElement()));
//        element.click();
//    }
//
//    public WebElement getElement() {
//        return wait.until(ExpectedConditions.visibilityOf(locator.findElement()));
//    }
//}


