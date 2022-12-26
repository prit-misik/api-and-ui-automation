package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import util.TestUtils;
import util.WebEventListener;

import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverSetUp {

    public static WebDriver driver;
    public static Properties prop = null;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener = null;
    public static Logger APP_LOGS = null;

    public static void intialize() {

        APP_LOGS = LogManager.getLogger(DriverSetUp.class);

        HashMap<String, String> map = TestUtils.getPropFileValues();
        if (map.get("browser").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (map.get("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (map.get("browser").equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        e_driver = new EventFiringWebDriver(driver);
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
        APP_LOGS.debug("Completed inialization");

    }

    public static void closeBrowser() {
        driver.quit();
        APP_LOGS.info("Killed browser Successfully.");
    }

}
