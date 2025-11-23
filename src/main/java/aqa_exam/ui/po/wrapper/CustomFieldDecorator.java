//package aqa_exam.ui.po.wrapper;
//
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
//import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
//import org.openqa.selenium.support.pagefactory.ElementLocator;
//import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
//import org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.Proxy;
//
//public class CustomFieldDecorator extends DefaultFieldDecorator {
//
//    public CustomFieldDecorator(ElementLocatorFactory factory) {
//        super(factory);
//    }
//
//    @Override
//    public Object decorate(ClassLoader loader, Field field) {
//
//        if (field.getType().equals(CustomWebElementButton.class)) {
//
//            ElementLocator locator = factory.createLocator(field);
//
//            return new CustomWebElementButton(
//                    locator,
//                    new org.openqa.selenium.support.ui.WebDriverWait(
//                            ((CustomLocatorFactory) factory).getDriver(),
//                            java.time.Duration.ofSeconds(10)
//                    )
//            );
//        }
//
//        return super.decorate(loader, field);
//    }
//}