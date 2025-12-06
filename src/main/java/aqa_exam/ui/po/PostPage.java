package aqa_exam.ui.po;

import aqa_exam.DriverPool;
import aqa_exam.ui.po.wrapper.CustomButtonElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Date;
import java.util.List;

public class PostPage extends BasePage {
    @FindBy(xpath = "//button[@type=\"button\"]")
    public CustomButtonElement deleteButton;
    @FindBy(xpath = "/html/body/main/div/div/div[2]/div[3]/div[2]/div/button[1]")
    public CustomButtonElement likeButton;
    @FindBy(xpath = "/html/body/main/div/div/div[2]/div[3]/div[2]/div/button[2]")
    public CustomButtonElement saveButton;
    @FindBy(xpath = "//a[contains(@href, '/dashboard/post/')]")
    public List<CustomButtonElement> postList;

    public void openPostPage(String id) {
        WebElement postPageButton = getPostPageButton(id);
        wait.until(ExpectedConditions.visibilityOf(postPageButton)).click();
    }

    public WebElement getPostPageButton(String id) {
        String xpath = "//a[contains(@href, '" + id + "')]";
        By locator = By.xpath(xpath);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//        Date start = new Date();
//        int timeout = 5000;
//        int ping = 1000;
//        while (timeout > (new Date().getTime() - start.getTime())){
//            if (postList.size() > 0) {
//                break;
//            }
//            try {
//                Thread.sleep(ping);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        return postList.get(1);
    }

    public void deletePost() {
        deleteButton.waitForMeAndClick();

//        WebDriverWait wait = new WebDriverWait(DriverPool.getDriver(), Duration.ofSeconds(10));
//        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//        alert.accept();

        Alert alert = DriverPool.getDriver().switchTo().alert();
        alert.accept();
    }

    public void likePost() {
        likeButton.waitForMeAndClick();
    }

    public void savePost() {
        saveButton.waitForMeAndClick();
    }
}
