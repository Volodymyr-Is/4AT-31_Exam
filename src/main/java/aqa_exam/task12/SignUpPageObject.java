package aqa_exam.task12;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SignUpPageObject {
    WebDriver driver;

    @FindBy(xpath="//li/a[text()=\"Sign up\"]")
    WebElement signUpMenuButton;

    @FindBy(id="sign-username")
    WebElement usernameInput;

    @FindBy(id="sign-password")
    WebElement passwordInput;

    @FindBy(xpath="//div/button[text()=\"Sign up\"]")
    WebElement signUpSubmitButton;

    WebDriverWait wait;

    public void waitForSubmitForm()
    {
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-username")));
    }


    public SignUpPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void clickSignUpMenuButton() {
        signUpMenuButton.click();
    }

    public void inputUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void inputPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickSubmitButton() {
        signUpSubmitButton.click();
    }

    public void validateSignUpMessage(String expectedMessage) {

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        //        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();

        Assert.assertEquals(actualMessage, expectedMessage);
        alert.accept();
    }
}