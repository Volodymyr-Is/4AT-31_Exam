package aqa_exam.test12;

import aqa_course.task12.SubmitFormBusinessObject;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task12Test {
    WebDriver driver;

    @BeforeTest
    void setup() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }

    @Test
    void task12() {
//        SignUpBusinessObject signUpBusinessObject = new SignUpBusinessObject();
//        signUpBusinessObject.signup("admin", "admin", driver);

        SubmitFormBusinessObject submitFormBusinessObject = new SubmitFormBusinessObject();
        submitFormBusinessObject.submitForm(driver);
    }

    @AfterTest
    void teardown() {
        driver.quit();
    }



}
