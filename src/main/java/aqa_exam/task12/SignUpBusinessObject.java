package aqa_exam.task12;

import org.openqa.selenium.WebDriver;

public class SignUpBusinessObject {
    public void signup(String username, String password, WebDriver driver) {
        driver.get("https://www.demoblaze.com/");

        SignUpPageObject signUpPageObject = new SignUpPageObject(driver);
        signUpPageObject.clickSignUpMenuButton();
        signUpPageObject.waitForSubmitForm();
        signUpPageObject.inputUsername(username);
        signUpPageObject.inputPassword(password);
        signUpPageObject.clickSubmitButton();
        signUpPageObject.validateSignUpMessage("This user already exist.");
    }
}
