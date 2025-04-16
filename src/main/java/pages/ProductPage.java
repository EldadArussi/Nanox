package pages;

import common.model.Product;
import common.seleniumutils.AlertUtil;
import common.seleniumutils.ElementUtil;
import common.storage.CartStorage;
import common.textutils.TextUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class ProductPage extends BasePage {

    @FindBy(css = ".btn-success")
    private WebElement addToCartBtn;

    @FindBy(css = ".name")
    private WebElement productName;

    @FindBy(css = ".price-container")
    private WebElement productPrice;

    public void addProduct() {
        ElementUtil.clickOnElement(addToCartBtn);
        AlertUtil.acceptAlert();

        String name = ElementUtil.getTextOfElement(productName);
        String price = extractPrice(ElementUtil.getTextOfElement(productPrice));

        Product product = new Product(name, price);
        CartStorage.addProduct(product);
    }

    private String extractPrice(String fullPrice) {
        String priceRegex = "\\$\\d+";
        return TextUtil.extractTextByRegex(fullPrice, priceRegex);
    }
}
