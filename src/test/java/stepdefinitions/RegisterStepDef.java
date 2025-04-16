package stepdefinitions;

import common.seleniumutils.AlertUtil;
import context.TestContext;
import context.ScenarioContext;
import io.cucumber.java.en.And;
import pages.RegisterPage;

import java.util.Random;

public class RegisterStepDef {

    private final RegisterPage registerPage = new RegisterPage();
    private final ScenarioContext scenarioContext;

    public RegisterStepDef(TestContext testContext) {
        this.scenarioContext = testContext.getScenarioContext();
    }

    @And("Register with valid user details")
    public void registerWithValidUserDetails() {
        String uniqueUserName = generateUniqueUserName();
        scenarioContext.setContext("userName", uniqueUserName);
        registerPage.enterUserName(uniqueUserName);
        registerPage.enterPassword("ValidPassword123");
        registerPage.clickRegisterButton();
        AlertUtil.acceptAlert();
    }

    private String generateUniqueUserName() {
        String prefix = "test";
        int number = new Random().nextInt(90000000) + 10000000;
        return prefix + number;
    }
}
