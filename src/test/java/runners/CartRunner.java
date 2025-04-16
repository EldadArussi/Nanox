package runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/featurefiles/cart.feature",
        glue = {"stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports/cart"},
        monochrome = true
)
public class CartRunner extends AbstractTestNGCucumberTests {
}
