package stepdefinitions;

import common.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.WebUI;


import java.io.IOException;

public class PingStepdefs extends BaseSteps{
      TestContext testContext;
    public PingStepdefs(TestContext context){
        super(context);
        testContext=context;
    }

    @Given("open the site url")
    public void openTheSiteUrl() {

        System.out.println("Driver on Steps class: " + driver);
        driver.get("https://google.com");
        WebUI.sleep(2);
    }

    @When("send issue command")
    public void sendIssueCommand() throws IOException {

        System.out.println("Verify the Column from Excel sheet ...>");
    }

    @Then("The report window appeared with expected result")
    public void theReportWindowAppearedWithExpectedResult() {

        System.out.println("The report window appeared with expected result");
    }
}
