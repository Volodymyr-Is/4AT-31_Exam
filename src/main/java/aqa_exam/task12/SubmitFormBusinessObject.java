package aqa_exam.task12;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SubmitFormBusinessObject {
    @Step
    public void submitForm(WebDriver driver){
        driver.get("https://demoqa.com/elements");

        SubmitFormPageObject submitFormPageObject = new SubmitFormPageObject(driver);
        submitFormPageObject.clickTextBoxMenuButton();
        submitFormPageObject.waitForSubmitForm();

        String userName = Generator.generateText(0, 10);
        String userEmail = Generator.generateText(0, 10) + "@mail.com";
        String currentAddress = Generator.generateText(0, 10);
        String permanentAddress = Generator.generateText(0, 10);

        submitFormPageObject.inputUserName(userName);
        submitFormPageObject.inputUserEmail(userEmail);
        submitFormPageObject.inputCurrentAddressInput(currentAddress);
        submitFormPageObject.inputPermanentAddress(permanentAddress);
        submitFormPageObject.clickSubmitButton();
        validateSubmitMessage(userName, userEmail, currentAddress, permanentAddress, driver);

    }

    @Step
    public void validateSubmitMessage(String expectedUserName, String expectedUserEmail, String expectedCurrentAddress, String expectedPermanentAddress, WebDriver driver) {
        String userNameOutput = OutputForm.getOutputText(driver, "name");
        String userEmailOutput = OutputForm.getOutputText(driver, "email");
        String currentAddressOutput = OutputForm.getOutputText(driver, "currentAddress");
        String permanentAddressOutput = OutputForm.getOutputText(driver, "permanentAddress");

        Assert.assertEquals(userNameOutput, "Name:"+expectedUserName, "Invalid Name");
        Assert.assertEquals(userEmailOutput, "Email:"+expectedUserEmail, "Invalid Email");
        Assert.assertEquals(currentAddressOutput, "Current Address :"+expectedCurrentAddress, "Invalid Current Address");
        Assert.assertEquals(permanentAddressOutput, "Permananet Address :"+expectedPermanentAddress, "Invalid Permanent Address");
    }
}
