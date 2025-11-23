package aqa_exam.ui.bo;

import aqa_exam.DriverPool;
import aqa_exam.ui.po.PostPage;
import aqa_exam.ui.po.GeneratePostPage;
import aqa_exam.ui.po.LoginPage;
import aqa_exam.ui.po.SavoraHomePage;
import org.testng.Assert;

public class SavoraBO {
    SavoraHomePage savoraHomePage = new SavoraHomePage();

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

    public SavoraBO createPost(String prompt) {
        GeneratePostPage generatePostPage = new GeneratePostPage();
        generatePostPage.openPostGenerationPage();
        generatePostPage.inputPrompt(prompt);
        generatePostPage.generateButton.click();
        return this;
    }

    public SavoraBO deletePost(String id) {
        PostPage PostPage = new PostPage();
        PostPage.openPostPage(id);
        PostPage.deletePost();
        return this;
    }

    public SavoraBO likeAndSavePost(String id) {
        PostPage PostPage = new PostPage();
        PostPage.openPostPage(id);
        PostPage.likePost();
        PostPage.savePost();
        return this;
    }

    public SavoraBO verifyUserLogged() {
        DriverPool.getDriver().navigate().to("https://savora-sm.vercel.app/dashboard");
        String currentUrl = DriverPool.getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl,"https://savora-sm.vercel.app/dashboard", "User not Logged in");
        return this;
    }
}
