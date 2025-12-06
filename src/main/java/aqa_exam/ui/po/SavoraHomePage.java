package aqa_exam.ui.po;

import aqa_exam.DriverPool;
import aqa_exam.ui.po.wrapper.CustomButtonElement;
import org.openqa.selenium.support.FindBy;

public class SavoraHomePage extends BasePage{
    @FindBy(xpath = "//div/span[.=\"User menu\"]/..")
    CustomButtonElement userMenuIcon;

    @FindBy(xpath = "//div/span[.=\"Login\"]/..")
    CustomButtonElement loginButton;

    @FindBy(xpath = "//div/span[.=\"Log out\"]/..")
    CustomButtonElement logoutButton;

    public void openPage() {
        DriverPool.getDriver().get("https://savora-sm.vercel.app");
    }

    public void goToLoginPage() {
        userMenuIcon.waitForMeAndClick();
        loginButton.waitForMeAndClick();
    }

    public void logoutUser() {
        userMenuIcon.waitForMeAndClick();
        logoutButton.waitForMeAndClick();
    }

    public boolean isUserLoggedIn() {
        openPage();
        userMenuIcon.waitForMeAndClick();

        boolean isLogged = logoutButton.isDisplayed();

        userMenuIcon.waitForMeAndClick();
        return isLogged;
    }
}
