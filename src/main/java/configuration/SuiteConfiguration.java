package configuration;

import org.testng.ISuite;

public class SuiteConfiguration {

    private static SuiteConfiguration instance;

    private String environment;
    private String url;

    private SuiteConfiguration(ISuite suite) {
        this.environment = suite.getParameter("environment");
        this.url = suite.getParameter("url");
    }

    public static void init(ISuite suite) {
        if (instance == null) {
            instance = new SuiteConfiguration(suite);
        }
    }

    public static SuiteConfiguration getInstance() {
        if (instance == null) {
            throw new IllegalStateException("SuiteConfiguration has not been initialized. Call init(ISuite) first.");
        }
        return instance;
    }

    public String getEnvironment() {
        return environment;
    }

    public String getUrl() {
        return url;
    }
}
