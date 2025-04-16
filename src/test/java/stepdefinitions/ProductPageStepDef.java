package stepdefinitions;

import io.cucumber.java.en.And;
import pages.ProductPage;

public class ProductPageStepDef {

    private final ProductPage productPage = new ProductPage();
    @And("Add product to the cart")
    public void addProductToTheCart() {
        productPage.addProduct();
    }
}
