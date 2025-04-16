package pages;

import common.driver.DriverManager;
import common.seleniumutils.ElementUtil;
import common.seleniumutils.WaitWrapper;
import common.seleniumutils.collectionutils.ListUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(css = ".card-title")
    private List<WebElement> productTitles;

    public void selectRandomProduct() {
        WaitWrapper.waitForAllElementsVisible(productTitles);
        ElementUtil.clickOnElement(ListUtil.getRandomElement(productTitles));
    }

    public void openHomePage() {
        DriverManager.getDriver().get(suiteConfig.getUrl());

    }
}
