package common;

import driver.DriverFactory;
import driver.DriverManagers;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ThreadGuard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stepdefinitions.Hooks;
import utils.ScenarioCache;

import java.util.HashMap;
import java.util.Map;



public class TestContext {

    private  WebDriver driver;
    private final Map<String, Object> contextList = new HashMap<>();
    public static Logger LOG = LoggerFactory.getLogger(TestContext.class);

    public TestContext() {
      //  driver = new BrowserFactory().createInstance("edge");
        ThreadGuard.protect(new DriverFactory().createDriver());
       // LOG.info("Driver in TestContext"  +getDriver());

    }

    public Object getContext(String key) {
        return contextList.get(key);
    }

    public WebDriver getDriver() {
        //return driver;
        return DriverManagers.getDriver();
    }
}

