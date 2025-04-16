package stepdefinitions;

import context.ScenarioContext;
import context.TestContext;
import io.cucumber.java.en.And;
import pages.LoginPage;

public class LoginStepDef {

    private final ScenarioContext scenarioContext;
    private final LoginPage loginPage = new LoginPage();

    public LoginStepDef(TestContext testContext) {
        this.scenarioContext = testContext.getScenarioContext();
    }

    @And("Log in with the same user")
    public void logInWithSameUser() {
        String username = scenarioContext.getContext("userName");
        loginPage.enterUserName(username);
        loginPage.enterPassword("ValidPassword123");
        loginPage.clickLoginButton();
    }
}
