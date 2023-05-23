package stepdefinitions;

import common.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.ExcelReader;
import utils.WebUI;


import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PingStepdefs extends BaseSteps{
      TestContext testContext;
    public PingStepdefs(TestContext context){
        super(context);
        testContext=context;
    }

    @Given("open the site url")
    public void openTheSiteUrl() {

        System.out.println("Driver on Steps class: " + driver);

    }

    @When("send issue command")
    public void sendIssueCommand() throws IOException {

        System.out.println("Verify the Column from Excel sheet ...>");
    }

    @Then("The report window appeared with expected result")
    public void theReportWindowAppearedWithExpectedResult() {

        System.out.println("The report window appeared with expected result");
    }

    @Given("open the browser")
    public void openTheBrowser() {
        System.out.println("Open the browser");

    }

    @When("search from {} and {} for meter number")
    public void searchFromAndForMeterNumber(String SheetName, Integer MeterRow) throws IOException, InvalidFormatException {
        ExcelReader reader = new ExcelReader();
        List<Map<String,String>> testData =
                reader.getData("FilesExcel\\Automation.xlsx",SheetName);

        String Mtr = testData.get(MeterRow).get("MeterRow");
        String MtrN = testData.get(MeterRow).get("MeterNumber");
        String MtrNm = testData.get(MeterRow).get("MeterName");

        System.out.println(Mtr);
        System.out.println(MtrN);
        System.out.println(MtrNm);
        driver.get("https://google.com");
        WebUI.sleep(1);
        WebElement ele = driver.findElement(By.name("q"));
        ele.sendKeys(MtrN);
        WebUI.sleep(2);
        ele.submit();
        WebUI.sleep(2);



    }

    @Then("Appeared with expected result")
    public void appearedWithExpectedResult() {
        System.out.println("Meter Information for meter number");
    }
}
