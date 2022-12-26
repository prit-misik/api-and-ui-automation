package impl;

import base.BasePage;
import org.openqa.selenium.*;
import pages.DashBoardPage;
import util.WebDriverUtils;

public class DashBoardImpl extends BasePage {

    DashBoardPage dashPage = new DashBoardPage();


    public Boolean verifyDashBoardHeader() {
        try {
            return WebDriverUtils.isElementPresent(dashPage.dashboardHeader);
        } catch (NoSuchElementException e) {
            APP_LOGS.error("Could not find the element::" + e.getMessage());
        }
        return false;
    }

    public boolean verifySearchBoxVisible() {
        try {
            return WebDriverUtils.isElementVisible(dashPage.searchBox);
        } catch (ElementNotVisibleException e) {
            APP_LOGS.error("Could not find the element::" + e.getMessage());
        }
        return false;
    }

    public boolean verifySearchSubmitClickable() {
        try {
            return WebDriverUtils.isElementClickable(dashPage.searchButton);
        } catch (ElementNotInteractableException e) {
            APP_LOGS.error("Could not click element::" + e.getMessage());
        }
        return false;
    }

    public boolean verifyTablePresent() {
        try {
            return WebDriverUtils.isElementPresent(dashPage.tableForAllComputers);
        } catch (ElementNotVisibleException e) {
            APP_LOGS.error("Could not find the element::" + e.getMessage());
        }
        return false;
    }

    public boolean verifyTableHeaderPresent(String headerName) {
        try {
            return WebDriverUtils.isElementPresent(((String.format(dashPage.colHeader, headerName))));
        } catch (NoSuchElementException e) {
            APP_LOGS.error("Could not find the element::" + e.getMessage());
        }
        return false;
    }

    public boolean verifyAddNewCompClickable() {
        try {
            return WebDriverUtils.isElementClickable(dashPage.addNewCompLink);
        } catch (ElementNotInteractableException e) {
            APP_LOGS.error("Could not click element::" + e.getMessage());
        }
        return false;
    }

    public boolean verifyNextButton() {
        try {
            WebDriverUtils.isElementEnabled(dashPage.nextLink);
            WebDriverUtils.click(dashPage.nextLink);
            return true;
        } catch (ElementNotVisibleException e) {
            APP_LOGS.error("Could not find element::" + e.getMessage());
        }
        return false;
    }

    public boolean verifyPrevButton() {
        try {
            WebDriverUtils.isElementEnabled(dashPage.prevLink);
            WebDriverUtils.click(dashPage.prevLink);
            return true;
        } catch (ElementNotVisibleException e) {
            APP_LOGS.error("Could not find element::" + e.getMessage());
        }
        return false;
    }

    public void searchItem(String item) {
        try {
            WebDriverUtils.waitForElementToBePresent(dashPage.searchBox, 10);
            WebDriverUtils.setText(dashPage.searchBox, item);
            WebDriverUtils.waitForElementToBeClickable(dashPage.searchButton, 10);
            WebDriverUtils.click(dashPage.searchButton);
        } catch (ElementNotVisibleException e) {
            APP_LOGS.error("Could not find element::" + e.getMessage());
        }
    }

    public boolean verifyProdInTable(String product) {
        try {
            return WebDriverUtils.isElementPresent(((String.format(dashPage.prodInTable, product))));
        } catch (ElementNotVisibleException e) {
            APP_LOGS.error("Could not find element::" + e.getMessage());
        }
        return false;
    }

    public void clickOnProdInTable(String product) {
        try {
            WebDriverUtils.click(((String.format(dashPage.prodInTable, product))));
        } catch (ElementNotInteractableException e) {
            APP_LOGS.error("Could not click element::" + e.getMessage());
        }
    }

    public void clickOnAddNewComputer() {
        try {
            WebDriverUtils.click(dashPage.addNewCompLink);
        } catch (ElementNotInteractableException e) {
            APP_LOGS.error("Could not click element::" + e.getMessage());
        }
    }

    public Boolean verifyCreationSuccessMessage(String product) {
        try {
            return WebDriverUtils.isElementPresent(((String.format(dashPage.creationMessage, product))));
        } catch (ElementNotVisibleException e) {
            APP_LOGS.error("Could not find element::" + e.getMessage());
        }
        return false;
    }

    public Boolean verifyUpdationSuccessMessage(String product) {
        try {
            return WebDriverUtils.isElementPresent(((String.format(dashPage.updateMessage, product))));
        } catch (ElementNotVisibleException e) {
            APP_LOGS.error("Could not find element::" + e.getMessage());
        }
        return false;
    }

    public Boolean verifyDeleteMessage(String prod) {
        try {
            return WebDriverUtils.isElementPresent(((String.format(dashPage.deleteMessage, prod))));
        } catch (ElementNotVisibleException e) {
            APP_LOGS.error("Could not find element::" + e.getMessage());
        }
        return false;
    }

    public String getNoResultMsg() {
        try {
            return WebDriverUtils.getText(dashPage.noResultMsg);
        } catch (ElementNotVisibleException e) {
            APP_LOGS.error("Could not find element::" + e.getMessage());
        }
        return null;
    }
}
