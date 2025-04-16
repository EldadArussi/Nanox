package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.PurchasePage;

import java.util.List;
import java.util.Map;

public class PurchaseStepDef {

    private final PurchasePage purchasePage = new PurchasePage();

    @And("Click on purchase")
    public void clickOnPurchase() {
        purchasePage.clickOnPurchaseBtn();
    }

    @And("Fill in purchase details:")
    public void fillInPurchaseDetails(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps();
        Map<String, String> row = rows.get(0);
        purchasePage.fillDetails(row);
    }

    @Then("^Verify Success message is (.+)$")
    public void verifySuccessMessage(String expectedMessage) {
        Assert.assertEquals(purchasePage.getSuccessMessage(), expectedMessage, "Wrong message");
    }
}
