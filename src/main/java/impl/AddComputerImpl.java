package impl;

import base.BasePage;
import dataProvider.ComputerDetails;
import org.openqa.selenium.ElementNotVisibleException;
import pages.AddComputerPage;
import pages.DashBoardPage;
import util.WebDriverUtils;

import java.util.List;

public class AddComputerImpl extends BasePage {

    AddComputerPage addComputerPage = new AddComputerPage();
    DashBoardPage dashBoardPage = new DashBoardPage();

    public boolean verifyAddCompTitle() {
        try {
            WebDriverUtils.waitForElementToBePresent(addComputerPage.addComputerHeader, 2);
            return WebDriverUtils.isElementPresent(addComputerPage.addComputerHeader);
        } catch (ElementNotVisibleException e) {
            APP_LOGS.error("Could not find element::" + e.getMessage());

        }
        return false;
    }

    public void addComputerDetails(List<ComputerDetails> computerDetails) {

        try {

            for (ComputerDetails details : computerDetails) {
                if (details.getName() != null)
                    WebDriverUtils.setText_js(addComputerPage.prodName, details.getName());
                if (details.getIntroduced() != null)
                    WebDriverUtils.setText_js(addComputerPage.introduced, details.getIntroduced());
                if (details.getDiscontinued() != null)
                    WebDriverUtils.setText_js(addComputerPage.discontinued, details.getDiscontinued());
                if (details.getCompany() != null)
                    WebDriverUtils.selectValueFromList(addComputerPage.company, details.getCompany());
            }
            WebDriverUtils.click(addComputerPage.createComputerButton);
        } catch (ElementNotVisibleException e) {
            APP_LOGS.error("Could not find element::" + e.getMessage());

        }

    }

    public boolean verifyUserName() {
        try {
            return WebDriverUtils.isElementPresent(addComputerPage.prodName);
        } catch (ElementNotVisibleException e) {
            APP_LOGS.error("Could not find element::" + e.getMessage());
        }
        return false;
    }

    public boolean verifyIntoduced() {
        try {
            return WebDriverUtils.isElementPresent(addComputerPage.introduced);
        } catch (ElementNotVisibleException e) {
            APP_LOGS.error("Could not find element::" + e.getMessage());
        }
        return false;
    }

    public boolean verifyDiscontinued() {
        try {
            return WebDriverUtils.isElementPresent(addComputerPage.discontinued);
        } catch (ElementNotVisibleException e) {
            APP_LOGS.error("Could not find element::" + e.getMessage());
        }
        return false;
    }

    public boolean verifyCompany() {
        try {
            return WebDriverUtils.isElementPresent(addComputerPage.company);
        } catch (ElementNotVisibleException e) {
            APP_LOGS.error("Could not find element::" + e.getMessage());
        }
        return false;
    }

    public void goToAddComputerPage() {
        try {
            WebDriverUtils.click_js(dashBoardPage.addNewCompLink);
            WebDriverUtils.waitForElementToBePresent(addComputerPage.addComputerHeader, 2);
        } catch (ElementNotVisibleException e) {
            APP_LOGS.error("Could not find element::" + e.getMessage());
        }
    }

    public boolean verifyCreateCompButton() {
        try {
            return WebDriverUtils.isElementPresent(addComputerPage.createComputerButton);
        } catch (ElementNotVisibleException e) {
            APP_LOGS.error("Could not find element::" + e.getMessage());
        }
        return false;
    }

    public boolean verifyCancelButton() {
        try {
            return WebDriverUtils.isElementPresent(addComputerPage.cancelbutton);
        } catch (ElementNotVisibleException e) {
            APP_LOGS.error("Could not find element::" + e.getMessage());
        }
        return false;
    }

    public boolean verifyErrorMsg() {
        try {
            return WebDriverUtils.isElementPresent(addComputerPage.errorMsg);
        } catch (ElementNotVisibleException e) {
            APP_LOGS.error("Could not find element::" + e.getMessage());
        }
        return false;
    }

    public boolean verifyDateError() {
        try {
            return WebDriverUtils.isElementPresent(addComputerPage.dateErrorMsg);
        } catch (ElementNotVisibleException e) {
            APP_LOGS.error("Could not find element::" + e.getMessage());
        }
        return false;
    }

    public boolean clickCancel() {
        try {
            return WebDriverUtils.isElementPresent(addComputerPage.cancelbutton);
        } catch (ElementNotVisibleException e) {
            APP_LOGS.error("Could not find element::" + e.getMessage());
        }
        return false;
    }
}
