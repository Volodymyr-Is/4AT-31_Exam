package aqa_exam.ui.po.wrapper;

import aqa_exam.DriverPool;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWebElementLinkButton extends Element {

    public CustomWebElementLinkButton(WebElement webElement) {
        super(webElement);
    }

    @Override
    public WebElement waitUntilVisible() {
        return super.waitUntilVisible();
    }

    public void click() {
        waitUntilVisible();
        webElement.click();
    }

    public String getText() {
        waitUntilVisible();
        return webElement.getText();
    }

    public boolean isEnabled() {
        return webElement.isEnabled() && webElement.getAttribute("class").contains("disabled") == false;
    }
}
