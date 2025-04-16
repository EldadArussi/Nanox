package pages;

import common.seleniumutils.ElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class PurchasePage extends BasePage {

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "card")
    private WebElement cardField;

    @FindBy(xpath = "//button[@onclick='purchaseOrder()']")
    private WebElement purchaseButton;

    @FindBy(xpath = "//div[contains(@class, 'sweet-alert')]//h2")
    private WebElement successMessage;

    public void clickOnPurchaseBtn() {
        ElementUtil.clickOnElement(purchaseButton);
    }

    public void fillDetails(Map<String, String> data) {
        data.forEach((field, value) -> {
            switch (field.toLowerCase()) {
                case "name":
                    ElementUtil.sendKeysToElement(nameField, value);
                    break;
                case "credit card":
                    ElementUtil.sendKeysToElement(cardField, value);
                    break;
                default:
                    throw new IllegalArgumentException("wrong field: " + field);
            }
        });
    }

    public String getSuccessMessage() {
        return ElementUtil.getTextOfElement(successMessage);
    }
}
