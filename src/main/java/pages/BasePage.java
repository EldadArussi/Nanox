package pages;

import common.driver.DriverManager;
import configuration.SuiteConfiguration;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected static SuiteConfiguration suiteConfig;

    static {
        suiteConfig = SuiteConfiguration.getInstance();
    }

    public BasePage(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }
}
