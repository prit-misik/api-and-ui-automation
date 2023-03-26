package impl;

import base.BasePage;
import io.cucumber.datatable.DataTable;
import java.util.List;
import java.util.Map;
import pages.SettingsPage;
import util.WebDriverUtils;

public class SettingsImpl extends BasePage {

  SettingsPage settingsPage = new SettingsPage();

   public ProfileImpl updateProfileSettings(DataTable profileData){
     List<Map<String, String>> data = profileData.asMaps(String.class, String.class);
     WebDriverUtils.setText(settingsPage.shortBio,data.get(0).get("article_title"));
     WebDriverUtils.click(settingsPage.updateSetting);
     return new ProfileImpl();
   }
}
