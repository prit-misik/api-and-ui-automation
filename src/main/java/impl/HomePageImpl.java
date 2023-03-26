package impl;

import base.BasePage;
import component.HomePageComponent;
import org.openqa.selenium.By;
import pages.HomePage;
import util.TestUtils;
import util.WebDriverUtils;

public class HomePageImpl extends BasePage {

  HomePage homePage = new HomePage();

  public HomePageImpl navigateToHomePage() {

    String username = TestUtils.getPropFileValues().get("username");
    String password = TestUtils.getPropFileValues().get("password");
    String url = TestUtils.getPropFileValues().get("url");
    url = url.replace("https://", "https://" + username + ":" + password + "@");
    WebDriverUtils.openURL(url);
    return new HomePageImpl();
  }

  public LoginImpl clickOnLoginLink() {

    WebDriverUtils.click(homePage.signInLink);
    return new LoginImpl();
  }

  public String getHomePageTitle() {
    return WebDriverUtils.getTitle();
  }

  public void clickOnNewArticle() {
    WebDriverUtils.click(homePage.newArticleLink);
  }

  public void  searchWithTagName(String tagName) {
    WebDriverUtils.click(driver.findElement(By.xpath(String.format(HomePage.tag,tagName))));
  }
  public boolean verifyNewTabWithTagName(String tagName){
    return WebDriverUtils.isElementVisible(String.format(HomePage.tabWithTagName,tagName),tagName);

  }
  public SettingsImpl clickOnSettingsLink(){
     WebDriverUtils.click(homePage.settingsLink);
     return new SettingsImpl();
  }
}
