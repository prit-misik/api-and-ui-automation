package stepDefinitions;

import cucumber.api.PendingException;
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
public class EditPageStepDefinition {

    DashBoardImpl dashImpl = new DashBoardImpl();
    EditImpl editPgImpl = new EditImpl();
    AddComputerImpl addCompImpl = new AddComputerImpl();

    @Given("^User verifies updation success message for product $")
    public void userAddsANewComputer() {
        dashImpl.clickOnAddNewComputer();
    }

    @Then("^User verifies updation success message for product \"([^\"]*)\"$")
    public void userVerifiesUpdationSuccessMessageForProduct(String product)   {
        dashImpl.verifyUpdationSuccessMessage(product);
    }

    @Then("^User verifies the header of edit computer page$")
    public void userVerifiesTheHeaderOfEditComputerPage() {
        editPgImpl.verifyEditPageTitle();
    }

    @Then("^Usr veries delete computer button$")
    public void usrVeriesDeleteComputerButton() {
       Assert.assertTrue(editPgImpl.verifyDeleteComputerButton());
    }

    @Then("^User deletes the product$")
    public void userDeletesTheProduct() {
        editPgImpl.clickOnDeleteButton();
    }

    @Then("^User verifies deletion message for product \"([^\"]*)\"$")
    public void userVerifiesDeletionMessageForProduct(String prod)  {
       dashImpl.verifyDeleteMessage(prod);
    }
}
