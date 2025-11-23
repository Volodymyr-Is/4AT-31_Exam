package aqa_exam.ui.po;

import aqa_exam.ui.po.wrapper.CustomWebElementButton;
import aqa_exam.ui.po.wrapper.CustomWebElementInput;
import aqa_exam.ui.po.wrapper.CustomWebElementLinkButton;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static aqa_exam.DriverPool.driver;

public class GeneratePostPage extends BasePage {
//    @FindBy(xpath = "/html/body/main/div/div/div[1]/div/a[2]")
    @FindBy(xpath = "//a[@href=\"/dashboard/create-post/ai\"]")
    public WebElement generatePostPageButton;
    @FindBy(id = "prompt")
    public WebElement promptInput;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement generateButton;
//    public CustomWebElementButton generateButton;

    public void inputPrompt(String prompt) {
        wait.until(ExpectedConditions.visibilityOf(promptInput)).sendKeys(prompt);
//        promptInput.type(prompt);
    }

    public void openPostGenerationPage() {
        wait.until(ExpectedConditions.visibilityOf(generatePostPageButton)).click();
//        generatePostPageButton.click();
    }
}
