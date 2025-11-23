package aqa_exam.ui.po;

import aqa_exam.DriverPool;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    public WebDriverWait wait;

    public BasePage() {
        PageFactory.initElements(DriverPool.getDriver(), this);
        wait = new WebDriverWait(DriverPool.getDriver(), Duration.ofSeconds(10));
    }
}


//package aqa_exam.ui.po;
//
//import aqa_exam.DriverPool;
////import aqa_exam.ui.po.wrapper.CustomFieldDecorator;
////import aqa_exam.ui.po.wrapper.CustomLocatorFactory;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public abstract class BasePage {
//    public WebDriverWait wait;
//
//    public BasePage() {
//        PageFactory.initElements(
//                new CustomFieldDecorator(
//                        new CustomLocatorFactory(DriverPool.getDriver()
//                        )
//                )
//                , this);
//        wait = new WebDriverWait(DriverPool.getDriver(), Duration.ofSeconds(10));
//    }
//}
