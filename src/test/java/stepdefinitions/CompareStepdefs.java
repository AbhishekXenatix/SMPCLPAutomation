package stepdefinitions;

import common.TestContext;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import utils.ReadWriteDataExcel;
import utils.ScenarioCache;
import utils.WebUI;


import java.io.FileInputStream;
import java.io.IOException;

public class CompareStepdefs extends BaseSteps{
    TestContext testContext;

    public static String exl01 = "AllFiles\\LP2-10001528.xlsx";
    public static String exl02 = "AllFiles\\Mtr_10001528_Hist.xlsx";
    public CompareStepdefs(TestContext context){
        super(context);testContext=context;
    }

    @Given("There are two files for comparing in equal data")
    public void thereAreTwoFilesForComparingInEqualData() {
        ScenarioCache.getCacheScenario().log("There are two files for comparing from  Lin Yang (Single phase meter) – DE Mapping" );
    }

    @When("Start comparing the data")
    public void startComparingTheData() throws IOException {
       // CompareExcel.VerifyExcel();

        FileInputStream fileInputStream1 = new FileInputStream(exl01);
        XSSFWorkbook wb1 = new XSSFWorkbook(fileInputStream1);
        FileInputStream fileInputStream2 = new FileInputStream(exl02);
        XSSFWorkbook wb2 = new XSSFWorkbook(fileInputStream2);

        ReadWriteDataExcel.verifyDataInExcelBookAll(wb1, wb2, 0, 6);
        WebUI.sleep(3);
        ReadWriteDataExcel.verifyDataInExcelBookAll(wb1, wb2, 2, 3);




    }

    @Then("The report generated")
    public void theReportGenerated() throws IOException {
        ScenarioCache.getCacheScenario().log("The report window appeared with expected result" );
    }




    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
