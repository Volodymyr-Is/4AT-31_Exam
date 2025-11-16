package aqa_exam.task11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OutputForm {
    public static String getOutputText(WebDriver driver, String option) {
        return driver.findElement(By.xpath(String.format("//*/div[@id=\"output\"]/div/p[@id=\"%s\"]", option))).getText();
    }
}
