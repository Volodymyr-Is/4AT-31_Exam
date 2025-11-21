package aqa_exam.ui.po;

import aqa_exam.DriverPool;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    public WebDriverWait wait;

    public BasePage() {
        PageFactory.initElements(DriverPool.getDriver(), this);
        wait = new WebDriverWait(DriverPool.getDriver(), Duration.ofSeconds(5));
    }
}
