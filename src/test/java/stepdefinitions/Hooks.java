package stepdefinitions;




import common.TestContext;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class Hooks extends BaseSteps{

    public Hooks(TestContext context) {
        super(context);
    }

   //public static String from= "C:\\Users\\Abhishek_Gupta3\\Downloads\\UAT Test Master for SMP_20230512.xlsx";
   // public static String  to="C:\\Users\\Abhishek_Gupta3\\IdeaProjects\\SMPCLPAutomation\\src\\test\\resources\\AllFiles";

    @Before
    public void beforeScenario(Scenario scenario) throws IOException {
        System.out.println("================ BEFORE ALL ================");
        System.out.println("Starting Driver: " + driver);

        File file = new File("C:\\Users\\Abhishek_Gupta3\\Downloads\\UAT Test Master for SMP_20230512.xlsx");
        if (file.exists())
            // Show if the file exists
            System.out.println("Exists");
        else
            // Show if the file does not exists
            System.out.println("Does not Exists");














    }

    @After
    public void afterScenario(Scenario scenario) {
        //validate if scenario has failed then Screenshot
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot Failed");
        }
        driver.quit();

    }

















}
