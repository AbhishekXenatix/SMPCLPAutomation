package driver;


import org.openqa.selenium.WebDriver;
public class DriverManagers {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManagers() {
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driver) {
        DriverManagers.driver.set(driver);
    }

    public static void quit() {
        DriverManagers.driver.get().quit();
        driver.remove();
    }

    public static void close() {
        DriverManagers.driver.get().close();
    }
}
