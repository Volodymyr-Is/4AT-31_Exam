package aqa_exam.test10;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;

public class Task10_Test {

    WebDriver driver;

    void setup() {
        File chromeDriverFile = new File("src/chromedriver/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chromeDriverFile.getAbsoluteFile().getAbsolutePath());

        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }


    @Test
    void Task10Test(){
        setup();
        driver.get("https://demoqa.com/elements");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement clickOnTextBoxButton = driver.findElement(By.xpath("//ul/li[@id=\"item-0\"]"));
        clickOnTextBoxButton.click();

        Assert.assertTrue(clickOnTextBoxButton.isDisplayed());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterTest
    void close(){
        driver.quit();
    }

}
