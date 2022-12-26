package util;

import base.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class TestUtils extends BasePage {

    public static long PAGE_LOAD_TIMEOUT=20;
    public static long IMPLICIT_WAIT = 20;
    public static Properties prop = null;
    public static HashMap<String, String> propMap = new HashMap<String, String>();


    /**
     * Takes screen shot where failure occured, and names it with current time in milliseconds
     */

    public static void takeScreenShot() {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String currentDir = System.getProperty("user.dir");

            FileUtils.copyFile(srcFile, new File(currentDir + "/screenShots/" + System.currentTimeMillis() + ".png"));
        } catch (Exception e) {

            APP_LOGS.error("Couldn't take screen shot:: " + e);
        }
    }

    public static HashMap<String, String> getPropFileValues() {
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + "//src//main//java//config//config.properties");

            prop.load(ip);
            propMap.putAll((Map) prop);
            return propMap;

        } catch (
                FileNotFoundException e) {

            e.printStackTrace();
        } catch (
                IOException e) {

            e.printStackTrace();
        }


        return propMap;
    }
}
