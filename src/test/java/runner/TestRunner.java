package runner;

import base.SetUp;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        plugin = {"pretty", "html:target/test-output/report.html", "json:target/cucumber-reports/cucumber.json", "junit:target/cucumber-reports/cucumber.xml"},
        monochrome = true

)
public class TestRunner extends SetUp {
    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }
}



