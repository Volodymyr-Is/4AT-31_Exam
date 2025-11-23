package aqa_exam.ui.po;

import aqa_exam.ui.po.wrapper.CustomWebElementButton;
import aqa_exam.ui.po.wrapper.CustomWebElementInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @FindBy(id = "email")
    public WebElement emailInput;
    @FindBy(id = "password")
    public WebElement passwordInput;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement loginButton;
    @FindBy(xpath = "/html/body/header/nav/a/div/img")
    public WebElement homeButton;


    public void inputEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailInput)).sendKeys(email);
//        emailInput.type(email);
    }
}
