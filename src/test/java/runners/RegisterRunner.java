package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/featurefiles/register.feature",
        glue = {"stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports/register"},
        monochrome = true
)
public class RegisterRunner extends AbstractTestNGCucumberTests {
}
