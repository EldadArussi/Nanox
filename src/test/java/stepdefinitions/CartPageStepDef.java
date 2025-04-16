package stepdefinitions;

import common.model.Product;
import common.storage.CartStorage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.CartPage;

import java.util.ArrayList;
import java.util.List;

public class CartPageStepDef {

    private final CartPage cartPage = new CartPage();
    @Then("Verify product is in the cart")
    public void verifyTheProductsIsInTheCart() {

        List<Product> expectedProducts = CartStorage.getCartItems();
        List<Product> actualProducts = cartPage.getProducts();
        List<String> missingProducts = new ArrayList<>();

        for (Product expected : expectedProducts) {
            if (!actualProducts.contains(expected)) {
                missingProducts.add(expected.getName());
            }
        }
        if (!missingProducts.isEmpty()) {
            Assert.fail("The following expected products were not found in the cart: " + missingProducts);
        }
    }

    @And("Delete product from the cart")
    public void deleteProductFromTheCart() {
        List<Product> expectedProducts = CartStorage.getCartItems();
        Product productToDelete = expectedProducts.getFirst();
        cartPage.deleteProductByName(productToDelete.getName());
    }

    @Then("Verify product is not in the cart")
    public void verifyProductIsNotInTheCart() {
        List<Product> expectedProducts = CartStorage.getCartItems();
        Product deletedProduct = expectedProducts.getFirst();
        List<Product> currentProducts = cartPage.getProducts();
        boolean isStillInCart = currentProducts.stream()
                .anyMatch(p -> p.getName().equalsIgnoreCase(deletedProduct.getName()));

        Assert.assertFalse(isStillInCart, "Product '" + deletedProduct.getName() + "' not deleted");
        CartStorage.removeProduct(deletedProduct);
    }

    @And("Click on place order")
    public void clickOnPlaceOrder() {
        cartPage.clickOnPlaceOrder();
    }
}
