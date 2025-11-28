package aqa_exam.ui.po;

import aqa_exam.DriverPool;
import aqa_exam.ui.po.wrapper.CustomFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    public WebDriverWait wait = new WebDriverWait(DriverPool.getDriver(), Duration.ofSeconds(20));

    public BasePage() {
        PageFactory.initElements(new CustomFieldDecorator(DriverPool.getDriver()), this);
    }
}