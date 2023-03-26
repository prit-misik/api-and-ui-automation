package component;

import base.BasePage;
import impl.ArticleDetailsImpl;
import util.WebDriverUtils;

public class ArticleDetailsComponent extends BasePage {

  ArticleDetailsImpl articleDetailsImpl = new ArticleDetailsImpl();

  public boolean validateVisibilityOfBasicControls() {
    return articleDetailsImpl.isDeleteOptionVisible()
        && articleDetailsImpl.isEditOptionVisible();
  }

}
