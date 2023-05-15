package driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;


public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        System.out.println("ThreadLocal driver: " + driver.get());
        if (driver.get() == null) {
            setWebDriver(new BrowserFactory().createInstance(null));
        }
        System.out.println("Created driver: " + driver.get());
        return driver.get();
    }

    public static void setWebDriver(WebDriver _driver) {
        driver.set(_driver);
    }

 /*   public static String getBrowserInfo() {
        Capabilities cap = ((RemoteWebDriver) getDriver()).getCapabilities();
        String b = cap.getBrowserName();
     //   String os = cap.getPlatformName().toString();
      //  String v = cap.getBrowserVersion();
    //    return String.format("%s v:%s %s", b, v, os);
    }
    */
}
