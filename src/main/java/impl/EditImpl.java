package impl;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import pages.EditPage;
import util.WebDriverUtils;

public class EditImpl extends BasePage {

    EditPage editPg = new EditPage();

    public boolean verifyEditPageTitle() {
        try {
            return WebDriverUtils.isElementPresent(editPg.editCompHeader);
        } catch (ElementNotVisibleException e) {
            APP_LOGS.error("Could not find element::" + e.getMessage());

        }
        return false;
    }

    public boolean verifyDeleteComputerButton() {
        try {
            return WebDriverUtils.isElementPresent(editPg.deleteComputer);
        } catch (ElementNotVisibleException e) {
            APP_LOGS.error("Could not find element::" + e.getMessage());

        }
        return false;
    }

    public String verifyItemDetails(String product) {
        try {
            WebDriverUtils.waitForElementToBePresent(editPg.prodName, 5);
            return driver.findElement(By.name("name")).getAttribute("value");
        } catch (ElementNotVisibleException e) {
            APP_LOGS.error("Could not find element::" + e.getMessage());

        }
        return null;
    }

    public void clickOnDeleteButton() {
        try {
            WebDriverUtils.waitForElementToBePresent(editPg.deleteComputer, 5);
            WebDriverUtils.click_js(editPg.deleteComputer);
        } catch (ElementNotInteractableException e) {
            APP_LOGS.error("Could not click element::" + e.getMessage());

        }
    }
}
