package aqa_exam;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverPool {
    public static WebDriver driver;

    public static synchronized WebDriver getDriver() {
        String browserType = ConfigReader.getProp("browserType");
        if (driver == null) {
            switch (browserType) {
                case "Chrome": {
                    ChromeDriverManager.getInstance().setup();
                    driver = new ChromeDriver();
                    break;
                }
                case "Edge": {
                    EdgeDriverManager.getInstance().setup();
                    driver = new EdgeDriver();
                    break;
                }
                default: {
                    throw new RuntimeException("Invalid Browser: " + browserType);
                }
            }
        }
        return driver;
    }

    public static void main(String[] args) {
        getDriver().get("https://www.google.com/");
    }
}
