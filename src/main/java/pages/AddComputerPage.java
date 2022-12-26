package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddComputerPage extends BasePage {

    @FindBy(xpath = "//h1[contains(.,'Add a computer')]")
    public WebElement addComputerHeader;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement prodName;

    @FindBy(xpath = "//input[@name='introduced']")
    public WebElement introduced;

    @FindBy(xpath = "//input[@name='discontinued']")
    public WebElement discontinued;

    @FindBy(xpath = "//select[@id='company']")
    public WebElement company;

    @FindBy(xpath = "//input[@value='Create this computer']")
    public WebElement createComputerButton;

    @FindBy(xpath = "//a[contains(.,'Cancel')]")
    public WebElement cancelbutton;

    @FindBy(xpath = "//span[contains(.,'Failed to refine type : Predicate isEmpty() did not fail.')]")
    public WebElement errorMsg;

    @FindBy(xpath = "//span[contains(.,'Failed to decode date : java.time.format.DateTimeParseException')]")
    public WebElement dateErrorMsg;
}

