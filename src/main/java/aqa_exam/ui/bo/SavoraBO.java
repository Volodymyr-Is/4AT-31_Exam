package aqa_exam.ui.bo;

import aqa_exam.DriverPool;
import aqa_exam.ui.po.PostPage;
import aqa_exam.ui.po.GeneratePostPage;
import aqa_exam.ui.po.LoginPage;
import aqa_exam.ui.po.SavoraHomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class SavoraBO {
    private static final Logger LOGGER = LogManager.getLogger(SavoraBO.class);

    SavoraHomePage savoraHomePage = new SavoraHomePage();

    public SavoraBO login(String email, String password) {
        LOGGER.info("Starting login sequence for user: " + email);

//        if (savoraHomePage.isUserLoggedIn()) {
//            LOGGER.warn("User is already logged in. Performing forced logout first.");
//            logout();
//            LOGGER.warn("Forced logout complete.");
//        }

        savoraHomePage.openPage();
        LOGGER.debug("Opened Savora Home Page.");

        savoraHomePage.goToLoginPage();
        LOGGER.debug("Navigated to Login Page.");

        LoginPage loginPage = new LoginPage();
        loginPage.inputEmail(email);
        loginPage.passwordInput.waitForMeAndInput(password);
        loginPage.loginButton.waitForMeAndClick();
        loginPage.homeButton.waitForMeAndClick();

        LOGGER.info("Login sequence completed for user: " + email);
        return this;
    }

    public SavoraBO createPost(String prompt) {
        LOGGER.info("Starting post creation with prompt: " + prompt);
        GeneratePostPage generatePostPage = new GeneratePostPage();
        generatePostPage.openPostGenerationPage();

        LOGGER.debug("Navigated to Post Generation Page.");
        generatePostPage.inputPrompt(prompt);
        generatePostPage.generateButton.waitForMeAndClick();

        LOGGER.info("Post creation completed. Post generated using prompt.");
        return this;
    }

    public SavoraBO deletePost(String id) {
        LOGGER.info("Starting post deletion for ID: " + id);
        PostPage PostPage = new PostPage();
        PostPage.openPostPage(id);

        LOGGER.debug("Opened Post Page for ID: " + id);
        PostPage.deletePost();

        LOGGER.info("Post with ID " + id + " successfully deleted.");
        return this;
    }

    public SavoraBO likeAndSavePost(String id) {
        LOGGER.info("Attempting to Like and Save Post with ID: " + id);
        PostPage PostPage = new PostPage();
        PostPage.openPostPage(id);
        PostPage.likePost();
        LOGGER.debug("Post " + id + " liked.");

        PostPage.savePost();
        LOGGER.info("Post " + id + " saved.");
        return this;
    }

    public SavoraBO verifyUserLogged() {
        final String expectedUrl = "https://savora-sm.vercel.app/dashboard";

        LOGGER.info("Verifying user is logged in and on the Dashboard.");

        DriverPool.getDriver().navigate().to(expectedUrl);
        String currentUrl = DriverPool.getDriver().getCurrentUrl();

        if (!currentUrl.equals(expectedUrl)) {
            LOGGER.error("Verification FAILED! Expected URL: " + expectedUrl + ", but found URL: " + currentUrl);
        } else {
            LOGGER.info("Verification SUCCESS! User is correctly logged in on Dashboard (" + currentUrl + ").");
        }

        Assert.assertEquals(currentUrl, expectedUrl, "User not Logged in");
        return this;
    }

    public SavoraBO logout() {

        savoraHomePage.openPage();
        LOGGER.debug("Opened Savora Home Page.");

        savoraHomePage.logoutUser();
        LOGGER.debug("Logout User.");

        return this;
    }
}
