package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends SetUp {

    public BasePage() {

        PageFactory.initElements(driver, this);
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
