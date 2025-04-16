package pages;

import common.seleniumutils.ElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "loginusername")
    private WebElement userNameInput;

    @FindBy(id = "loginpassword")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@onclick='logIn()']")
    private WebElement loginButton;

    public void enterUserName(String userName) {
        ElementUtil.sendKeysToElement(userNameInput,userName);
    }

    public void enterPassword(String password) {
        ElementUtil.sendKeysToElement(passwordInput,password);
    }

    public void clickLoginButton() {
        ElementUtil.clickOnElement(loginButton);
    }
}
