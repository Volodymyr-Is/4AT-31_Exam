package aqa_exam.ui.po;

import aqa_exam.ui.po.wrapper.CustomButtonElement;
import aqa_exam.ui.po.wrapper.CustomInputElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "email")
    public CustomInputElement emailInput;
    @FindBy(id = "password")
    public CustomInputElement passwordInput;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    public CustomButtonElement loginButton;
    @FindBy(xpath = "/html/body/header/nav/a/div/img")
    public CustomButtonElement homeButton;


    public void inputEmail(String email) {
        emailInput.waitForMeAndInput(email);
    }
}
