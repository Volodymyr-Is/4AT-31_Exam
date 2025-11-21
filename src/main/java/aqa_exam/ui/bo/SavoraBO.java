package aqa_exam.ui.bo;

import aqa_exam.DriverPool;
import aqa_exam.ui.po.LoginPage;
import aqa_exam.ui.po.SavoraHomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SavoraBO {
    SavoraHomePage savoraHomePage = new SavoraHomePage();

    public SavoraBO createPost(String postText) {
//        todo
        return this;
    }

    public SavoraBO login(String email, String password) {
        savoraHomePage.openPage();
        savoraHomePage.goToLoginPage();
        LoginPage loginPage = new LoginPage();


        loginPage.inputEmail(email);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();
        loginPage.homeButton.click();
        return this;
    }

    public SavoraBO verifyUserLogged() {
        DriverPool.getDriver().navigate().to("https://savora-sm.vercel.app/dashboard");
        String currentUrl = DriverPool.getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl,"https://savora-sm.vercel.app/dashboard", "User not Logged in");
        return this;
    }
}
