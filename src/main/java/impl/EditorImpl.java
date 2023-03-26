package impl;

import base.BasePage;
import pages.EditorPage;
import util.WebDriverUtils;

public class EditorImpl extends BasePage {

  EditorPage editorPage = new EditorPage();

  public EditorImpl enterArticleTitle(String title) {

    WebDriverUtils.setText(editorPage.articleTitle, title);
    return this;
  }

  public EditorImpl enterAbout(String about) {
    WebDriverUtils.setText(editorPage.description, about);
    return this;
  }

  public EditorImpl enterDetailedArticle(String detailedArticle) {
    WebDriverUtils.setText(editorPage.body, detailedArticle);
    return this;
  }

  public EditorImpl enterTag(String tag) {
    WebDriverUtils.setText(editorPage.tags, tag);
    return this;
  }

  public void clickPublishButton() {
    WebDriverUtils.click(editorPage.publishArticle);
    //return homePageImpl;
  }

  public EditorImpl clearTitleField() {
    WebDriverUtils.clearElement(editorPage.articleTitle);
    return this;
  }
}
