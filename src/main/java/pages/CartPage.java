package pages;

import common.model.Product;
import common.seleniumutils.ElementUtil;
import common.seleniumutils.WaitWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    @FindBy(css = "#tbodyid tr")
    private List<WebElement> cartRows;

    @FindBy(css = ".btn-success")
    private WebElement placeOrder;

    public List<Product> getProducts() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (cartRows.isEmpty()) {
            return new ArrayList<>();
        }
        List<Product> cartItems = new ArrayList<>();

        for (WebElement row : cartRows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));

            String name = ElementUtil.getTextOfElement(columns.get(1));
            String price = ElementUtil.getTextOfElement(columns.get(2));

            Product product = new Product(name, price);
            cartItems.add(product);
        }
        return cartItems;
    }

    public void deleteProductByName(String name) {
        WaitWrapper.waitForAllElementsVisible(cartRows);
        for (WebElement row : cartRows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            String productName = ElementUtil.getTextOfElement(columns.get(1));

            if (productName.equalsIgnoreCase(name)) {
                ElementUtil.clickOnElement(columns.get(3).findElement(By.tagName("a")));
                return;
            }
        }
        throw new RuntimeException("Product with name '" + name + "' was not found in the cart.");
    }

    public void clickOnPlaceOrder(){
        ElementUtil.clickOnElement(placeOrder);
    }
}
