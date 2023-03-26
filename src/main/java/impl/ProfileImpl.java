package impl;

import base.BasePage;
import io.cucumber.datatable.DataTable;
import java.util.List;
import java.util.Map;
import pages.LoginPage;
import pages.ProfilePage;
import util.TestUtils;
import util.WebDriverUtils;

public class ProfileImpl extends BasePage {

  ProfilePage profilePage = new ProfilePage();
  public boolean validateBio(String bio) {
    return WebDriverUtils.isElementVisible(profilePage.bio,bio);
  }
}
