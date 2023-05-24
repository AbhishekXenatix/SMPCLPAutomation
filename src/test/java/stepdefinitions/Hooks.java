package stepdefinitions;






import common.TestContext;
import io.cucumber.java.*;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.cucumber.java.Scenario;

import utils.Log;
import utils.ScenarioCache;


public class Hooks extends BaseSteps{
    public Hooks(TestContext context) {
        super(context);
    }
    public static Logger LOG = LoggerFactory.getLogger(Hooks.class);
    public static Scenario scenario;

    @Before
    public void beforeScenario(Scenario scenario) {
        LOG.info("================ BEFORE ALL ================");
        LOG.info("Starting Edge Driver: ");
        LOG.info("******************************************************");
        LOG.info("Scenario"   + scenario.getName());
        ScenarioCache.cacheScenario(scenario);

     /*   File file = new File("C:\\Users\\Abhishek_Gupta3\\Downloads\\TestDataDemo\\Mtr_10001528_Hist.xlsx");
        if (file.exists())
            // Show if the file exists
            System.out.println("Exists");
        else
            // Show if the file does not exists
            System.out.println("Does not Exists");

        AT.copy(fromCommandCenterExcelFiles, toAzureCloud);
        AT.copy(fromLogsColumn, toAzureCloud);
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
        LOG= LoggerFactory.getLogger(Hooks.class);
        LOG.info("Scenario"     + scenario.getName());
        LOG.info("==============Test Completed============");
        LOG.info("Scenario : '"+scenario.getName() + "' has status " + scenario.getStatus());
        LOG.info(" Scenario : "+scenario.getName());

    }



















}
