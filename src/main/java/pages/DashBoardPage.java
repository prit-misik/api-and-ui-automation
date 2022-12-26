package pages;

import base.BasePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage extends BasePage {

    @FindBy(xpath = "//a[contains(.,'Computer database')]")
    public WebElement dashboardHeader;

    @FindBy(xpath = "//input[@id='searchbox']")
    public WebElement searchBox;

    @FindBy(xpath = "//input[@id='searcsubmit']")
    public WebElement searchButton;

    @FindBy(xpath = "//a[contains(.,'Add a new computer')]")
    public WebElement addNewCompLink;

    @FindBy(xpath = "//h1[contains(.,'computers found')]")
    public WebElement computersFoundMsg;

    @FindBy(xpath = "//table[@class='computers zebra-striped']")
    public WebElement tableForAllComputers;

    @FindBy(xpath = "//a[contains(.,'Next →')]")
    public WebElement nextLink;

    @FindBy(xpath = "//a[contains(.,'← Previous')]")
    public WebElement prevLink;


    @FindBy(xpath = "//em[contains(.,'Nothing to display')]")
    public WebElement noResultMsg;

    public String creationMessage = "//div[contains(.,'Done !  Computer %s has been created')]";

    public String updateMessage = "//div[contains(.,'Done ! Computer %s has been updated')]";

    public String deleteMessage = "//div[contains(.,'Done ! Computer %s has been deleted')]";

    public String colHeader = "//th[contains(.,'%s')]";

    public String prodInTable = "//a[contains(.,'%s')]";

}

