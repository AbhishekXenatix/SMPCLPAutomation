package utils;



import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.concurrent.TimeUnit;

public class NotepadSession {
    @Test
    public void Check() throws MalformedURLException, InterruptedException {
        WindowsDriver driver;

        DesiredCapabilities capabilities =  new DesiredCapabilities();

        capabilities.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
        capabilities.setCapability("platformName" ,"Windows");
        capabilities.setCapability("deviceName","WindowsPC");

         driver = new WindowsDriver(new URL("http://127.0.0.1:4723") ,capabilities);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.name("Help")).click();

        driver.findElement(By.name("About Notepad")).click();Thread.sleep(3000);
        driver.findElement(By.name("OK")).click();Thread.sleep(3000);

    }


    



}
