package aqa_exam.task12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SubmitFormPageObject {
    WebDriver driver;

    @FindBy(xpath="//ul/li[@id=\"item-0\"]")
    WebElement textBoxMenuButton;

    @FindBy(id="userName")
    WebElement userNameInput;

    @FindBy(id="userEmail")
    WebElement userEmailInput;

    @FindBy(id="currentAddress")
    WebElement currentAddressInput;

    @FindBy(id="permanentAddress")
    WebElement permanentAddressInput;

    @FindBy(xpath="//button[text()='Submit']")
    WebElement SubmitFormButton;

    WebDriverWait wait;

    public void waitForSubmitForm()
    {
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
    }

    public SubmitFormPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickTextBoxMenuButton() {
        textBoxMenuButton.click();
    }

    public void inputUserName(String userName) {
        userNameInput.sendKeys(userName);
    }

    public void inputUserEmail(String userEmail) {
        userEmailInput.sendKeys(userEmail);
    }

    public void inputCurrentAddressInput(String currentAddress) {
        currentAddressInput.sendKeys(currentAddress);
    }

    public void inputPermanentAddress(String permanentAddress) {
        permanentAddressInput.sendKeys(permanentAddress);
    }

    public void clickSubmitButton() {
        SubmitFormButton.click();
    }
}
