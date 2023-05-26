package stepdefinitions;

import common.TestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CompareExcel;

import utils.ScenarioCache;


import java.io.IOException;

public class CompareStepdefs extends BaseSteps{
    TestContext testContext;
    public CompareStepdefs(TestContext context){
        super(context);testContext=context;
    }

    @Given("There are two files for comparing in equal data")
    public void thereAreTwoFilesForComparingInEqualData() {
        ScenarioCache.getCacheScenario().log("There are two files for comparing from  Lin Yang (Single phase meter) – DE Mapping" );
    }

    @When("Start comparing the data")
    public void startComparingTheData() throws IOException {
        CompareExcel.VerifyExcel();

    }

    @Then("The report generated")
    public void theReportGenerated() throws IOException {
        ScenarioCache.getCacheScenario().log("The report window appeared with expected result" );
    }
}
