package aqa_exam.task10;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Task10 {
//    1. Set up ChromeDriver using the driver file and properties.
//    2. Set up ChromeDriver using DriverManager.
//    3. Navigate to the page assigned to your variant.
//    4. Select any three different elements.
//    5. Interact with all the selected elements.
//    6. Verify the visibility of each element using assertions.
//    7. Wrap all these steps into a TestNG test case.

    public static void main(String[] args) throws InterruptedException {
//        File chromeDriverFile = new File("src/chromedriver/chromedriver.exe");
//
//        System.setProperty("webdriver.chrome.driver",
//                chromeDriverFile.getAbsoluteFile().getAbsolutePath());
//
//        WebDriver driver = new ChromeDriver();
//
//        driver.get("https://www.google.com");


        File chromeDriverFile = new File("src/chromedriver/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chromeDriverFile.getAbsoluteFile().getAbsolutePath());

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/elements");

        WebElement clickOnTextBoxButton = driver.findElement(By.xpath("//ul/li[@id=\"item-0\"]"));

        clickOnTextBoxButton.click();

        Thread.sleep(5000);

        driver.quit();

    }
}
