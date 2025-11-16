package aqa_exam.test11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxPage {
    public void clickSubmit(WebDriver driver) {
        WebElement clickOnTextBoxButton = driver.findElement(By.xpath("//ul/li[@id=\"item-0\"]"));
        clickOnTextBoxButton.click();
    }
}
