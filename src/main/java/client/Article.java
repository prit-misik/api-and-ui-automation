package client;

import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import util.APIUtils;
import util.CreatePayload;
import util.ReqSpecification;
import util.TestUtils;

public class Article {

  private final HashMap<String, String> map = TestUtils.getPropFileValues();

  public Response createNewArticle(DataTable articleData, String token) {
      ReqSpecification reqSpecification = new ReqSpecification();
      Response response = APIUtils.makePOSTCall(reqSpecification.createReqSpec(),
          map.get("api.articles"), CreatePayload.createArticlePayload(articleData), token);
      response.then().log().all();
      return response;
    }

  public Response markArticleAsFavourite(String slug, String token) {
    Map<String, String> pathParamMap = Map.of("slug",slug);
    ReqSpecification reqSpecification = new ReqSpecification();
      Response response = APIUtils.makePOSTCall(reqSpecification.createReqSpec(),map.get("api.article.favourite"),
          token, pathParamMap);
      response.then().log().all();
      return response;
    }

  public Response deleteArticle(String slug, String token) {
    Map<String, String> pathParamMap = Map.of("slug",slug);
    ReqSpecification reqSpecification = new ReqSpecification();
    Response response = APIUtils.makeDELETECall(reqSpecification.createReqSpec(), map.get("api.article.delete"),
        token, pathParamMap);
    response.then().log().all();
    return response;
  }
}
