package aqa_exam.ui.po;

import aqa_exam.ui.po.wrapper.CustomWebElementButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static aqa_exam.DriverPool.driver;

public class PostPage extends BasePage {
    @FindBy(xpath = "//button[@type=\"button\"]")
    public WebElement deleteButton;
    @FindBy(xpath = "/html/body/main/div/div/div[2]/div[3]/div[2]/div/button[1]")
    public WebElement likeButton;
    @FindBy(xpath = "/html/body/main/div/div/div[2]/div[3]/div[2]/div/button[2]")
    public WebElement saveButton;

    public void openPostPage(String id) {
        WebElement postPageButton = getPostPageButton(id);
        wait.until(ExpectedConditions.visibilityOf(postPageButton)).click();
    }

    public WebElement getPostPageButton(String id) {
        String xpath = "//a[contains(@href, '" + id + "')]";
        By locator = By.xpath(xpath);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void deletePost() {
        wait.until(ExpectedConditions.visibilityOf(deleteButton)).click();
//        deleteButton.click();
    }

    public void likePost() {
        wait.until(ExpectedConditions.visibilityOf(likeButton)).click();
//        likeButton.click();
    }

    public void savePost() {
        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
//        saveButton.click();
    }
}
