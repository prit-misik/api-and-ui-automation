package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import dataProvider.ComputerDetails;
import impl.AddComputerImpl;
import impl.DashBoardImpl;
import impl.EditImpl;
import org.testng.Assert;
import util.WebDriverUtils;

import java.util.List;

/**
 * Created by Pritam Sharma , on 30/01/21
 **/
public class DashboardStepDefinition {

    DashBoardImpl dashImpl = new DashBoardImpl();
    EditImpl editPgImpl = new EditImpl();
    AddComputerImpl addCompImpl = new AddComputerImpl();

    @Given("^User verifies the header of add computer page $")
    public void userOpensTheProvidedURL(String url) throws Throwable {
        WebDriverUtils.openURL(url);
    }

    @Given("^User verifies the header of the dashboard page$")
    public void userVerifiesTheHeaderOfTheDashboardPage() {
        Assert.assertTrue(dashImpl.verifyDashBoardHeader());
    }

    @Then("^User verifies searchBox is visible$")
    public void userVerifiesSearchBoxIsVisible() {
        Assert.assertTrue(dashImpl.verifySearchBoxVisible());
    }

    @Then("^User verifies search submit is clickable$")
    public void userVerifiesSearchSubmitIsClickable() {
        Assert.assertTrue(dashImpl.verifySearchSubmitClickable());
    }

    @Then("^User verifies table is present$")
    public void userVerifiesTableIsPresent() {
        Assert.assertTrue(dashImpl.verifyTablePresent());
    }

    @Then("^user verifies table header \"([^\"]*)\"$")
    public void userVerifiesTableHeader(String headerName) {
        Assert.assertTrue(dashImpl.verifyTableHeaderPresent(headerName));
    }

    @Then("^User verifies add new computer link clickable$")
    public void userVerifiesAddNewComputerLinkClickable() {
        Assert.assertTrue(dashImpl.verifyAddNewCompClickable());
    }

    @Then("^User verifies next button$")
    public void userVerifiesNextButton() {
        Assert.assertTrue(dashImpl.verifyNextButton());
    }

    @Then("^User verifies prev button$")
    public void userVerifiesPrevButton() {
        Assert.assertTrue(dashImpl.verifyPrevButton());
    }

    @Given("^User searches the productName \"([^\"]*)\"$")
    public void userSearchesTheProductName(String product) {
        dashImpl.searchItem(product);
    }

    @Then("^User verifies \"([^\"]*)\" present in table$")
    public void userVerifiesPresentInTable(String product) {
        Assert.assertTrue(dashImpl.verifyProdInTable(product));
    }

    @Then("^User clicks on \"([^\"]*)\"$")
    public void userClicksOn(String product) {
        dashImpl.clickOnProdInTable(product);
    }

    @Then("^User Verifies details \"([^\"]*)\"$")
    public void userVerifiesDetails(String product)  {
        String actualProd = editPgImpl.verifyItemDetails(product);
        Assert.assertEquals(actualProd, product);
    }

    @Given("^User adds a new computer$")
    public void userAddsANewComputer() {
        dashImpl.clickOnAddNewComputer();
    }

    @Then("^User verifies page header$")
    public void userVerifiesPageHeader() {
        Assert.assertTrue(addCompImpl.verifyAddCompTitle());
    }

    @Then("^user submits following computer details$")
    public void userSubmitsFollowingComputerDetails(List<ComputerDetails> computerDetails) {
          addCompImpl.addComputerDetails(computerDetails);
    }

    @Then("^User verifies success message for product \"([^\"]*)\"$")
    public void userVerifiesSuccessMessageForProduct(String prod)  {
        Assert.assertTrue(dashImpl.verifyCreationSuccessMessage(prod));
    }

    @Then("^User Verifies text \"([^\"]*)\"$")
    public void userVerifiesText(String expected)  {
        Assert.assertEquals(expected,dashImpl.getNoResultMsg());
    }
}
