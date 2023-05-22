package stepdefinitions;




import common.TestContext;
import io.cucumber.java.*;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.WebUI;

import java.io.File;

import static stepdefinitions.AT.*;


public class Hooks extends BaseSteps{

    public Hooks(TestContext context) {
        super(context);
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("================ BEFORE ALL ================");
        System.out.println("Starting Driver: " + driver);

     /*   File file = new File("C:\\Users\\Abhishek_Gupta3\\Downloads\\TestDataDemo\\Mtr_10001528_Hist.xlsx");
        if (file.exists())
            // Show if the file exists
            System.out.println("Exists");
        else
            // Show if the file does not exists
            System.out.println("Does not Exists");

        AT.copy(fromCC, to);
        AT.copy(fromLC, to);
        WebUI.sleep(1);*/


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
