package common.seleniumutils;

import org.openqa.selenium.Alert;

public class AlertUtil {

    public static void acceptAlert() {
        Alert alert = WaitWrapper.waitForAlertToBePresent();
        alert.accept();
    }
}
