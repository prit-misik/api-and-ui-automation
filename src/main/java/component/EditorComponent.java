package component;

import impl.ArticleDetailsImpl;
import impl.EditorImpl;
import impl.HomePageImpl;
import io.cucumber.datatable.DataTable;
import java.util.List;
import java.util.Map;
import pages.ArticleDetailsPage;
import util.JavaUtils;

public class EditorComponent {

  EditorImpl editorImpl = new EditorImpl();
  HomePageImpl homePageImpl = new HomePageImpl();
  ArticleDetailsPage articleDetailsPage = new ArticleDetailsPage();

  public ArticleDetailsImpl addNewArticle(DataTable articleData) {
    List<Map<String, String>> data = articleData.asMaps(String.class, String.class);
    homePageImpl.clickOnNewArticle();
    editorImpl.enterArticleTitle(data.get(0).get("article_title"))
        .enterAbout(data.get(0).get("about"))
        .enterDetailedArticle(
            JavaUtils.readTextFromFile(
                "src/test/resources/testData/" + data.get(0).get("path_to_detailed_article")))
        .enterTag(data.get(0).get("tag"));
    editorImpl.clickPublishButton();
    return new ArticleDetailsImpl();
  }

  public ArticleDetailsImpl editArticleTitle(String newTitle) {
    editorImpl.clearTitleField()
        .enterArticleTitle(newTitle)
        .clickPublishButton();
    return new ArticleDetailsImpl();
  }
}
