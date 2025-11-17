package aqa_exam.ui.po;

import aqa_exam.DriverPool;
import aqa_exam.ui.po.wrapper.CustomWebElementButton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SavoraHomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"radix-«ri»\"]")
    WebElement userMenuIcon;

    @FindBy(xpath = "//*[@id=\"radix-«rj»\"]/div[1]")
    WebElement loginButton;
//    CustomWebElementButton loginButton;

    public SavoraHomePage() {
        driver = DriverPool.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        DriverPool.getDriver().get("https://savora-sm.vercel.app");
    }

    public void goToLoginPage() {
//        userMenuIcon.click();
//        loginButton.click();

        wait.until(ExpectedConditions.visibilityOf(userMenuIcon)).click();
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }
}
