package stepDefinitions;

import base.SetUp;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks extends SetUp {

    private static boolean flag = true;

    @Before("@ui")
    public void setUP() throws Exception {
        if (flag) {
            SetUp.intialize();
            flag = false;
        }
    }

    @After("@ui")
    public static void tearDown() {

        if (driver != null) {
            driver.quit();
        }

    }

}
