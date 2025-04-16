package listener;

import common.driver.DriverManager;
import configuration.SuiteConfiguration;
import context.ScenarioContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import common.storage.CartStorage;

public class Listener implements ITestListener, ISuiteListener {

    public static ScenarioContext testContext = new ScenarioContext();

    @Override
    public void onStart(ISuite suite) {
        SuiteConfiguration.init(suite);
    }

    @Override
    public void onTestStart(ITestResult result) {
        CartStorage.clear();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        closeDriver();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        closeDriver();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        closeDriver();
    }

    private void closeDriver() {
        DriverManager.quitDriver();
    }

    public static ScenarioContext getTestContext() {
        return testContext;
    }
}
