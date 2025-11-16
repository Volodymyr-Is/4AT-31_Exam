package aqa_exam.test14;

import aqa_course.task11.DriverProvider;
import aqa_course.task12.SubmitFormBusinessObject;
import aqa_course.task13.CustomListener;
import aqa_course.task14.CustomAllureListener;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners({CustomListener.class, CustomAllureListener.class})
public class Task14Test {
    WebDriver driver;

    @BeforeClass
    void setup() {
//        ChromeDriverManager.getInstance().setup();
        driver = DriverProvider.getDriver();
        System.out.println("Setup Done");
    }

    @Test
    void task14() {
        SubmitFormBusinessObject submitFormBusinessObject = new SubmitFormBusinessObject();
        submitFormBusinessObject.submitForm(driver);
    }

    @Test
    void task14fail() {
        SubmitFormBusinessObject submitFormBusinessObject = new SubmitFormBusinessObject();
        submitFormBusinessObject.submitForm(driver);
        Assert.fail("Test Fail Message");
    }

    @AfterClass
    void teardown() {
        System.out.println("Driver Quit");
        driver.quit();
    }
}

