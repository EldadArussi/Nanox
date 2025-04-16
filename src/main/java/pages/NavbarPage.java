package pages;

import common.seleniumutils.ElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NavbarPage extends BasePage{

    @FindBy(xpath = "//*[@class='nav-link' and not(contains(@style, 'display:none'))]")
    private List<WebElement> navbarLinks;

    @FindBy(id = "nameofuser")
    private WebElement userName;

    public void openLink(String popupName) {
        for (WebElement link : navbarLinks) {
            if (ElementUtil.getTextOfElement(link).equalsIgnoreCase(popupName)) {
                ElementUtil.clickOnElement(link);
                break;
            }
        }
    }

    public String getUserName(){
        return ElementUtil.getTextOfElement(userName);
    }
}
