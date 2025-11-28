package aqa_exam.ui.po;

import aqa_exam.ui.po.wrapper.CustomButtonElement;
import aqa_exam.ui.po.wrapper.CustomInputElement;
import org.openqa.selenium.support.FindBy;

public class GeneratePostPage extends BasePage {
    @FindBy(xpath = "//a[@href=\"/dashboard/create-post/ai\"]")
    public CustomButtonElement generatePostPageButton;
    @FindBy(id = "prompt")
    public CustomInputElement promptInput;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    public CustomButtonElement generateButton;

    public void inputPrompt(String prompt) {
        promptInput.waitForMeAndInput(prompt);
    }

    public void openPostGenerationPage() {
        generatePostPageButton.waitForMeAndClick();
    }
}
