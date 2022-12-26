package util;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebDriverUtils extends BasePage {


    public static String getTitle() {
        String title = null;
        try {
            title = driver.getTitle();
            return title;
        } catch (Exception e) {
            APP_LOGS.error("Could not get the title of the page :: " + e);
        }
        return title;
    }


    /**
     * checks if the provided element is present, if not returns false
     *
     * @param el
     * @return boolean true/false
     */

    public static boolean isElementPresent(WebElement el) {
        try {
            waitForElementToBePresent(el, 5);
            el.isDisplayed();
            //implicitlyWait(10);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Overloaded method , takes String xpath as parameter
     *
     * @param xpathOfEl
     * @return
     */

    public static boolean isElementPresent(String xpathOfEl) {
        try {
            driver.findElement(By.xpath(xpathOfEl)).isDisplayed();
            //Thread.sleep(2000);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isElementClickable(WebElement el) {
        try {
            waitForElementToBeClickable(el, 10);
            return true;
        } catch (Exception e) {
            APP_LOGS.error("Could not click on the element::" + e);

        }
        return false;
    }

    public static boolean isElementEnabled(WebElement el) {
        try {
            boolean res = el.isEnabled();
            return res;
        } catch (Exception e) {
            APP_LOGS.error("Could not click on the element::" + e);
        }
        return false;
    }

    public static boolean isElementEditable(WebElement el) {

        boolean res = false;
        try {
            res = ((el.getAttribute("disabled") == null) || (el.getAttribute("readonly") == null));
            return res;
        } catch (Exception e) {
            APP_LOGS.error("Could not check if the element is editable ::" + e);
        }
        return res;
    }


    /**
     * checks if the provided element is visible, if not returns false
     *
     * @param
     * @return boolean true/false
     */

    public static boolean isElementVisible(WebElement el) {

        try {
            el.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * checks if the provided element is visible, if not returns false
     * Overlaoded method, takes xpath as input
     *
     * @param
     * @return boolean true/false
     */

    public static boolean isElementVisible(String xpath) {

        try {
            ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * checks if the provided element is not present, if not returns false
     *
     * @param
     * @return boolean true/false
     */

    public boolean isElementInvisible(By by) {
        try {
            ExpectedConditions.invisibilityOfElementLocated(by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Clicks on an item, waits for the specified amount of time waits for the item
     * to be validated
     *
     * @param clickItem
     * @param itemToValidate
     * @param timeout
     */

    public static void clickAndWait(WebElement clickItem, String itemToValidate, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            clickItem.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(itemToValidate)));
        } catch (Exception e) {
            APP_LOGS.error("Could not click on the element::" + e);
        }

    }

    /**
     * Clicks on the provided web element
     *
     * @param el
     */

    public static void click(WebElement el) {
        try {

            el.click();
        } catch (Exception e) {
            APP_LOGS.error("Couldn't click the element specified ::" + e);
        }
    }

    /**
     * @param xpath of the element to be clicked.
     */
    public static void click(String xpath) {

        try {
            driver.findElement(By.xpath(xpath)).click();

        } catch (Exception e) {
            APP_LOGS.error("Unable to perform click ::" + e.getMessage());

        }
    }


    public static void click_js(WebElement el) {
        try {
            JavascriptExecutor ex = (JavascriptExecutor) driver;
            ex.executeScript("arguments[0].click()", el);

        } catch (Exception e) {
            APP_LOGS.error("Unable to perform key Enter ::" + e.getMessage());

        }
    }

    /**
     * Waits for the element to be visible ,waits till the condition condition is
     * fulfilled.
     *
     * @param by
     * @param timeout
     */

    public static void waitForElementToBeVisible(By by, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            APP_LOGS.error("Element is not visible :: " + e);
        }
    }

    /**
     * Waits for the element to be present ,waits till the condition condition is
     * fulfilled.
     *
     * @param by
     * @param timeout
     */

    public static void waitForElementToBePresent(By by, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Exception e) {
            APP_LOGS.error("Element is not present :: " + e);
        }
    }

    /**
     * Overloaded method , waitForElementToBePresent
     *
     * @param el
     * @param timeout
     */

    public static void waitForElementToBePresent(WebElement el, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(el));
        } catch (Exception e) {
            APP_LOGS.error("Element is not present :: " + e);
        }
    }


    public static void waitForElementToBeClickable(By by, int timeout) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            APP_LOGS.error("Element is not clickable :: " + e.getMessage());
        }
    }

    public static void waitForElementToBeClickable(WebElement el, int timeout) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.elementToBeClickable(el));
        } catch (Exception e) {
            APP_LOGS.error("Element is not clickable :: " + e.getMessage());
        }
    }

    /**
     * Wait for element to be invisible
     *
     * @param el
     * @param timeout in seconds
     */

    public static void waitForElementToBeInvisible(WebElement el, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.invisibilityOf(el));
        } catch (Exception e) {
            APP_LOGS.error("Element is still present :: " + e);
        }
    }

    public static void waitForElementToBeInvisible(By by, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (Exception e) {
            APP_LOGS.error("Element is still present :: " + e);
        }
    }

    /**
     * Selects a value from a select list, pointed by the locator provided by the
     * user.
     *
     * @param value
     */

    public static void selectValueFromList(By by, String value) {
        try {
            Select select = new Select(driver.findElement(by));
            select.selectByValue(value);
        } catch (Exception e) {

            APP_LOGS.error("Could not select element ::" + e);
        }
    }

    /**
     * Overloaded method to select item
     * @param value
     */
    public static void selectValueFromList(WebElement el, String value) {
        try {
            Select select = new Select(el);
            select.selectByValue(value);
        } catch (Exception e) {

            APP_LOGS.error("Could not select element ::" + e);
        }
    }

    public static void selectValueFromList_js(WebElement el, String value) {
        try {
            WebDriverUtils.click(el);
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", el);
        } catch (Exception e) {

            APP_LOGS.error("Could not select element ::" + e);
        }
    }

    /**
     * Move the cursor to the provided locator and click, Action class is used.
     *
     * @param xpath
     * @throws InterruptedException
     */

    public static void clickAt(String xpath) throws InterruptedException {
        WebElement ele = driver.findElement(By.xpath(xpath));
        Actions act = new Actions(driver);
        act.moveToElement(ele).click().build().perform();

    }

    /**
     * Waits for the specified amount of time for the page to be loaded.
     *
     * @param timeout
     * @throws Exception
     */

    public static void waitForPageToBeLoaded(int timeout) throws Exception {

        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };

        try {
            implicitlyWait(timeout);


        } catch (Exception e) {
            APP_LOGS.error("Page load time expired ::" + e);
        }

    }

    /**
     * Switches from current frame to specified frame
     *
     * @param frameName
     */

    public void switchToFrame(String frameName) {

        try {

            driver.switchTo().frame(frameName);

        } catch (Exception e) {
            APP_LOGS.error("Couldn't switch to frame ::" + e);
        }
    }

    /**
     * Sets the specified text in a textfield.
     *
     * @param el
     * @param value
     */

    public static void setText(String el, String value) {

        try {
            driver.findElement(By.xpath(el)).sendKeys(value);

        } catch (Exception e) {
            APP_LOGS.error("Unable to set text ::" + e);
        }

    }

    /**
     * Sets the specified text in a textfield.
     *
     * @param el
     * @param value
     */

    public static void setText(WebElement el, String value) {

        try {
            el.sendKeys(value);

        } catch (Exception e) {
            APP_LOGS.error("Unable to set text ::" + e);
        }

    }

    public static void setText_js(WebElement el, String value) {

        try {
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].value='"+ value +"';", el);

        } catch (Exception e) {
            APP_LOGS.error("Unable to set text ::" + e);
        }

    }

    public static String getText(WebElement el) {

        String text = "";
        try {
            text = el.getText();

        } catch (Exception e) {
            APP_LOGS.error("Unable to get text ::" + e);
        }
        return text;
    }


    public static String getText(String xpath) {

        String text = "";
        try {
            text = driver.findElement(By.xpath(xpath)).getText();

        } catch (Exception e) {
            APP_LOGS.error("Unable to get text ::" + e);
        }
        return text;
    }


    public static String getCssAttribute(WebElement el, String attribute) {

        String res = "";
        try {
            res = el.getCssValue(attribute);

        } catch (Exception e) {
            APP_LOGS.error("Unable to set text ::" + e);
        }
        return res;
    }


    public static void keyDown(WebElement srcElement) {

        try {
            Actions action = new Actions(driver);

            action.keyDown(Keys.ARROW_DOWN).build().perform();
            action.keyUp(Keys.ARROW_DOWN).build().perform();

        } catch (Exception e) {
            APP_LOGS.error("Unable to perform keydown ::" + e);
        }
    }

    public static void keyEnter() {

        try {

            Actions action = new Actions(driver);
            action.keyDown(Keys.ENTER).build().perform();
            action.keyUp(Keys.ENTER).build().perform();

        } catch (Exception e) {
            APP_LOGS.error("Unable to perform key Enter ::" + e.getMessage());
        }
    }

    public static void hoverOnWebElementAndClick(WebElement el, WebElement topwear) {

        try {

            Actions action = new Actions(driver);
            action.moveToElement(el).perform();
            waitForElementToBePresent(topwear, 10);
            action.moveToElement(topwear).click().perform();

        } catch (Exception e) {
            APP_LOGS.error("Unable to perform key Enter ::" + e.getMessage());
        }

    }

    /**
     * Implicity wait for mentioned seconds
     *
     * @time it is the time you want to wait , in seconds
     */
    public static void implicitlyWait(int time) {

        try {
            driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

        } catch (Exception e) {
            APP_LOGS.error("Unable to perform Implicit wait ::" + e.getMessage());
        }

    }

    public static void reloadPage() {

        try {
            driver.navigate().refresh();

        } catch (Exception e) {
            APP_LOGS.error("Unable to perform page reload ::" + e.getMessage());
        }

    }


    public static void clearElement(WebElement el) {

        try {
            String value = "";
            Actions actions = new Actions(driver);
            actions.doubleClick(el).perform();

            Thread.sleep(2000);
            el.sendKeys(Keys.BACK_SPACE);
//            JavascriptExecutor jse = (JavascriptExecutor)driver;
//            jse.executeScript("arguments[0].value='"+ value +"';", el);
            System.out.println("Inside Clear.....");

            //  driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));

//            el.sendKeys(Keys.chord(Keys.COMMAND,"a"));
//            el.sendKeys(Keys.BACK_SPACE);
//            Actions actions = new Actions(driver);
//            actions.click(el).
//                    keyDown(Keys.COMMAND).
//                    sendKeys("a").
//                    keyUp(Keys.COMMAND).
//                    sendKeys(Keys.BACK_SPACE).build().perform();
//

        } catch (Exception e) {
            APP_LOGS.error("Unable to perform clear::" + e.getMessage());
        }

    }

    public static String getCurentWindow() {

        String winHandle = "";
        try {

            winHandle = driver.getWindowHandle();
            return winHandle;

        } catch (Exception e) {
            APP_LOGS.error("Unable to perform window handle::" + e.getMessage());
        }
        return winHandle;
    }

    public static void switchToWindow() {

        try {

            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
            }

        } catch (Exception e) {
            APP_LOGS.error("Unable to perform window switch::" + e.getMessage());
        }

    }

    public static void openURL(String URL) {

        try {

            driver.get(URL);

        } catch (Exception e) {
            APP_LOGS.error("Unable to perform window switch::" + e.getMessage());
        }

    }


}