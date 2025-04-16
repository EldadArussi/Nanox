package common.seleniumutils;

import common.driver.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitWrapper {

    private static final int TIMEOUT_SECONDS = 10;
    private static final WebDriver driver = DriverManager.getDriver();

    public static void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForAllElementsVisible(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public static Alert waitForAlertToBePresent() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.alertIsPresent());
        return DriverManager.getDriver().switchTo().alert();
    }
}
