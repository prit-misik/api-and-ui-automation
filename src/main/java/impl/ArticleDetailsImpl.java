package impl;

import base.BasePage;
import io.cucumber.datatable.DataTable;
import java.util.List;
import java.util.Map;
import pages.ArticleDetailsPage;
import util.WebDriverUtils;

public class ArticleDetailsImpl extends BasePage {

   ArticleDetailsPage articleDetailsPage = new ArticleDetailsPage();
   EditorImpl editorImpl = new EditorImpl();

   public boolean isTitleVisible(DataTable articleData){
      List<Map<String, String>> data = articleData.asMaps(String.class, String.class);
      return WebDriverUtils.isElementVisible(articleDetailsPage.articleTitle);

   }
   public boolean isTitleVisible(){
      return WebDriverUtils.isElementVisible(articleDetailsPage.articleTitle);

   }
   public boolean isEditOptionVisible(){
      return WebDriverUtils.isElementVisible(articleDetailsPage.editArticle);

   }
   public boolean isDeleteOptionVisible(){
      return WebDriverUtils.isElementVisible(articleDetailsPage.deleteArticle);

   }
   public ArticleDetailsImpl clickEditArticle(){
      WebDriverUtils.click(articleDetailsPage.editArticle);
      return this ;
   }

   public void deleteArticle() {
      WebDriverUtils.click(articleDetailsPage.deleteArticle);
      WebDriverUtils.waitForElementToBeInvisible(articleDetailsPage.articleTitle,5);
   }
}
