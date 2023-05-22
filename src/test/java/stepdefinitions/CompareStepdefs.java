package stepdefinitions;

import common.TestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CompareExcel;

import java.io.IOException;

public class CompareStepdefs extends BaseSteps{

    TestContext testContext;
    public CompareStepdefs(TestContext context){
        super(context);
        testContext=context;
    }
    @Given("There are two files for comparing in equal data")
    public void thereAreTwoFilesForComparingInEqualData() {
    }

    @When("Start comparing the data")
    public void startComparingTheData() throws IOException {
        CompareExcel.VerifyExcel();
    }

    @Then("The report generated")
    public void theReportGenerated()  {
        System.out.println("The report window appeared with expected result");
    }
}
