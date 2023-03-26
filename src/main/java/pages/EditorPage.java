package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditorPage extends BasePage {

    @FindBy(xpath = "//input[@formcontrolname='title']")
    public WebElement articleTitle;

    @FindBy(xpath = "//input[@formcontrolname='description']")
    public WebElement description;

    @FindBy(xpath = "//textarea[@formcontrolname='body']")
    public WebElement body;

    @FindBy(xpath = "//input[@placeholder='Enter tags']")
    public WebElement tags;

    @FindBy(xpath = "//button[contains(text(),'Publish Article')]")
    public WebElement publishArticle;
}
