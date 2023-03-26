package stepDefinitions.ui;

import component.ArticleDetailsComponent;
import component.EditorComponent;
import component.LoginComponent;
import impl.ArticleDetailsImpl;
import impl.HomePageImpl;
import impl.ProfileImpl;
import impl.SettingsImpl;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class UITestStepDef {

  LoginComponent loginComponent = new LoginComponent();
  HomePageImpl homePageImpl = new HomePageImpl();
  EditorComponent editorComponent = new EditorComponent();
  ArticleDetailsImpl articleDetailsImpl = new ArticleDetailsImpl();
  ArticleDetailsComponent articleDetailsComponent = new ArticleDetailsComponent();
  ProfileImpl profileImpl = new ProfileImpl();

  @Given("user logs in with correct username and password")
  public void  userLogsInWithCorrectUsernameAndPassword() {
       homePageImpl= loginComponent.login();
       Assert.assertEquals(homePageImpl.getHomePageTitle(), "Conduit");
  }

  @Given("user creates new article with given details")
  public void userCreatesNewArticleWithGivenDetails(DataTable dataTable) {
    articleDetailsImpl = editorComponent.addNewArticle(dataTable);
    Assert.assertTrue(articleDetailsImpl.isTitleVisible(dataTable));
  }

  @Then("user should be able to verify basic components of article")
  public void user_should_be_able_to_verify_basic_components_of_article() {
    Assert.assertTrue(articleDetailsComponent.validateVisibilityOfBasicControls());
  }
  @Given("user modifies the title to {string}")
  public void user_modifies_the_title_to(String newTitle) {
    articleDetailsImpl = editorComponent.editArticleTitle(newTitle);
  }
  @Then("validates the updated title")
  public void validates_the_updated_title() {
    Assert.assertTrue(articleDetailsImpl.isTitleVisible());
  }
  @Given("user deletes the article")
  public void user_deletes_the_article(){
    articleDetailsImpl.deleteArticle();
  }

  @Then("user validates the article is not visible")
  public void user_validates_the_article_is_not_visible() {
    Assert.assertFalse(articleDetailsImpl.isTitleVisible());
  }

  @Given("user searches with a tag {string}")
  public void user_searches_with_a_tag(String tagName) {
     homePageImpl.searchWithTagName(tagName);

  }

  @Then("user should be able to a new tab with the tag name {string}")
  public void user_should_be_able_to_a_new_tab_with_the_tag_name(String tagName) {
     Assert.assertTrue(homePageImpl.verifyNewTabWithTagName(tagName));
  }

  @Given("user updates bio with the given details")
  public void userUpdatesBioWithTheGivenDetails(DataTable data) {
     SettingsImpl settingsImpl = homePageImpl.clickOnSettingsLink();
     settingsImpl.updateProfileSettings(data);

  }

  @Then("user validate short bio as {string}")
  public void userValidateShortBioAs(String bio) {
    Assert.assertTrue(profileImpl.validateBio(bio));
  }


}
