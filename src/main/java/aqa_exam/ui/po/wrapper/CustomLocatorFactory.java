//package aqa_exam.ui.po.wrapper;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.pagefactory.DefaultElementLocator;
//import org.openqa.selenium.support.pagefactory.ElementLocator;
//import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
//
//import java.lang.reflect.Field;
//
//public class CustomLocatorFactory implements ElementLocatorFactory {
//
//    private final WebDriver driver;
//
//    public CustomLocatorFactory(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    @Override
//    public ElementLocator createLocator(Field field) {
//        return new DefaultElementLocator(driver, field);
//    }
//
//    public WebDriver getDriver() {
//        return driver;
//    }
//}
