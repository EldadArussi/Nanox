package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;

public class HomePageStepDef {

    private final HomePage homePage = new HomePage();

    @When("Select random product")
    public void selectProduct() {
        homePage.selectRandomProduct();
    }

    @Given("Open home page")
    public void openHomePage() {
        homePage.openHomePage();
    }
}
