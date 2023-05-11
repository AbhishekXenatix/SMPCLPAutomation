package stepdefinitions;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import common.TestContext;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;





public class Hooks extends BaseSteps{

    public Hooks(TestContext context) {
        super(context);
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("================ BEFORE ALL ================");
        System.out.println("Starting Driver: " + driver);



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
