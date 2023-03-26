package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPage extends BasePage {

    @FindBy(xpath= "//textarea[@placeholder='Short bio about you']")
    public WebElement shortBio;

    @FindBy(xpath= "//button[contains(.,'Update Settings')]")
    public WebElement updateSetting;

}
