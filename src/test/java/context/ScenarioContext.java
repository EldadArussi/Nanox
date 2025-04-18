package context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private final Map<String, Object> scenarioContext;

    public ScenarioContext() {
        scenarioContext = new HashMap<>();
    }

    public void setContext(String key, Object value) {
        scenarioContext.put(key, value);
    }

    public String getContext(String key) {
        return scenarioContext.get(key).toString();
    }

    public Boolean isContains(String key) {
        return scenarioContext.containsKey(key);
    }
}
