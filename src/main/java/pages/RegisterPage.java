package pages;

import common.seleniumutils.ElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy(id = "sign-username")
    private WebElement userNameInput;

    @FindBy(id = "sign-password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@onclick='register()']")
    private WebElement registerButton;

    public void enterUserName(String userName) {
        ElementUtil.sendKeysToElement(userNameInput, userName);
    }

    public void enterPassword(String password) {
        ElementUtil.sendKeysToElement(passwordInput, password);
    }

    public void clickRegisterButton() {
        ElementUtil.clickOnElement(registerButton);
    }
}
