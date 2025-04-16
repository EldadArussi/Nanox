package stepdefinitions;

import context.ScenarioContext;
import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.NavbarPage;


public class NavbarStepDef {

    private final ScenarioContext scenarioContext;
    private final NavbarPage navbarPage = new NavbarPage();

    public NavbarStepDef(TestContext testContext) {
        this.scenarioContext = testContext.getScenarioContext();
    }

    @And("^Move to (.+) page$")
    public void moveToCartPage(String page) {
        navbarPage.openLink(page);
    }

    @When("^Open (.+) pop up$")
    public void openPopUp(String popUp) {
        navbarPage.openLink(popUp);
    }

    @Then("Verify user is logged in")
    public void verifyUserIsLoggedIn() {
        String userNameLoggedIn = navbarPage.getUserName();
        String userRegistered = scenarioContext.getContext("userName");
        Assert.assertTrue(userNameLoggedIn.contains(userRegistered), "wrong user name");
    }
}
