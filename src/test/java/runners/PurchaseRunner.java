package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/featurefiles/purchase.feature",
        glue = {"stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports/purchase"},
        monochrome = true
)
public class PurchaseRunner extends AbstractTestNGCucumberTests {
}
