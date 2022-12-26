package runner;

import base.DriverSetUp;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        plugin = {"pretty", "html:target/test-output", "json:target/cucumber-reports/cucumber.json", "junit:target/cucumber-reports/cucumber.xml"},
        monochrome = true,
        strict = true,
        dryRun = false
        //tags = {"@Smoke"}
)
public class TestRunner extends DriverSetUp {

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }
}



