package common.seleniumutils;

import org.openqa.selenium.WebElement;

public class ElementUtil {

    public static void clickOnElement(WebElement element) {
        WaitWrapper.waitForElementToBeVisible(element);
        element.click();
    }

    public static String getTextOfElement(WebElement element) {
        WaitWrapper.waitForElementToBeVisible(element);
        return element.getText();
    }

    public static void sendKeysToElement(WebElement element, String text) {
        WaitWrapper.waitForElementToBeVisible(element);
        element.sendKeys(text);
    }
}
