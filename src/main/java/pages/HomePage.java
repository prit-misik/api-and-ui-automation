package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

  @FindBy(xpath = "//a[contains(.,'Sign in')]")
  public WebElement signInLink;

  @FindBy(xpath = "//a[contains(.,'New Article')]")
  public WebElement newArticleLink;

  @FindBy(xpath = "//a[contains(.,'Settings')]")
  public WebElement settingsLink;

  public static String tag = "//a[@class='tag-default tag-pill' and contains(.,'%s')]";
  public static String tabWithTagName = "//a[@class='nav-link active' and contains(.,'%s')]";
}
