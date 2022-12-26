package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import impl.AddComputerImpl;
import impl.DashBoardImpl;
import org.testng.Assert;

/**
 * Created by Pritam Sharma , on 31/01/21
 **/
public class AddComputerStepDefinition {

    AddComputerImpl addCompImpl = new AddComputerImpl();
    DashBoardImpl dashBoard = new DashBoardImpl();

    @Given("^User verifies the header of add computer page$")
    public void userVerifiesTheHeaderOfAddComputerPage() {

        Assert.assertTrue(addCompImpl.verifyAddCompTitle());
    }

    @Then("^User verifies name field$")
    public void userVerifiesNameField() {

        Assert.assertTrue(addCompImpl.verifyUserName());
    }

    @Then("^User verifies introduced field$")
    public void userVerifiesIntroducedField() {

        Assert.assertTrue(addCompImpl.verifyIntoduced());
    }

    @Then("^User verifies discontinued field$")
    public void userVerifiesDiscontinuedField() {

        Assert.assertTrue(addCompImpl.verifyDiscontinued());
    }

    @Then("^User verifies company field$")
    public void userVerifiesCompanyField() {

        Assert.assertTrue(addCompImpl.verifyCompany());
    }

    @Given("^user goes to add computer page$")
    public void userGoesToAddComputerPage() {
        addCompImpl.goToAddComputerPage();
    }

    @Then("^User verifies create computer button$")
    public void userVerifiesCreateComputerButton() {
        Assert.assertTrue(addCompImpl.verifyCreateCompButton());
    }

    @Then("^User verifies cancel button$")
    public void userVerifiesCancelButton() {
        Assert.assertTrue(addCompImpl.verifyCancelButton());
    }

    @Then("^User verifies failure mesage$")
    public void userVerifiesFailureMesage() {
        Assert.assertTrue(addCompImpl.verifyErrorMsg());
    }

    @Then("^User verifies error message for date$")
    public void userVerifiesErrorMessageForDate() {
        Assert.assertTrue(addCompImpl.verifyDateError());
    }

    @Then("^User clicks on cancel button$")
    public void userClicksOnCancelButton() {
        addCompImpl.clickCancel();
    }

    @Then("^verify user is on dashboard$")
    public void verifyUserIsOnDashboard() {
        Assert.assertTrue(dashBoard.verifyDashBoardHeader());
    }
}
