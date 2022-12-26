package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditPage extends BasePage {

    @FindBy(xpath = "//h1[contains(.,'Edit computer')]")
    public WebElement editCompHeader;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement prodName;

    @FindBy(xpath = "//input[@name='introduced']")
    public WebElement introduced;

    @FindBy(xpath = "//input[@name='discontinued']")
    public WebElement discontinued;

    @FindBy(xpath = "//select[@id='company']")
    public WebElement company;

    @FindBy(xpath = "//input[@value='Delete this computer']")
    public WebElement deleteComputer;

    @FindBy(xpath = "//input[@value='Save this computer']")
    public WebElement saveButton;

    @FindBy(xpath = "//a[contains(.,'Cancel')]")
    public WebElement cancelbutton;


}

