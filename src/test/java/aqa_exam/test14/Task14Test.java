package aqa_exam.test14;

import aqa_exam.task11.DriverProvider;
import aqa_exam.task12.SubmitFormBusinessObject;
import aqa_exam.task14.CustomAllureListener;
import aqa_exam.task14.CustomListener;
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

