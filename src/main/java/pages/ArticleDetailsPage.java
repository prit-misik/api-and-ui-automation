package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArticleDetailsPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'banner')]//a[contains(@class, 'btn-outline-secondary')]")
    public WebElement editArticle;

    @FindBy(xpath = "//div[contains(@class, 'banner')]//button[contains(@class, 'btn-outline-danger')]")
    public WebElement deleteArticle;

    @FindBy(xpath= "//h1")
    public WebElement articleTitle ;

}
