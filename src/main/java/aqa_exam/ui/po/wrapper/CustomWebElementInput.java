package aqa_exam.ui.po.wrapper;

import org.openqa.selenium.WebElement;

public class CustomWebElementInput extends Element {

    public CustomWebElementInput(WebElement webElement) {
        super(webElement);
    }

    @Override
    public WebElement waitUntilVisible() {
        return super.waitUntilVisible();
    }

    public void type(String text) {
        waitUntilVisible();
        webElement.sendKeys(text);
    }

    public void clearAndType(String text) {
        waitUntilVisible();
        webElement.clear();
        webElement.sendKeys(text);
    }
}