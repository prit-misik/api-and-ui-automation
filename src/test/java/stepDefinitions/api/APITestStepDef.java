package stepDefinitions.api;

import client.Article;
import client.Registration;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import java.util.List;
import java.util.Map;
import models.NewArticle;
import models.User;
import org.testng.Assert;
import sharedContext.APISharedContext;

public class APITestStepDef {

  private APISharedContext apiSharedContext;

  public APITestStepDef(APISharedContext apiSharedContext){

     this.apiSharedContext = apiSharedContext;
  }
  @Given("new user performs registration")
  public void new_user_performs_registration() throws JsonProcessingException {
     Response response = new Registration().registerNewUser();
     Assert.assertEquals(response.statusCode(),200);
     ObjectMapper objectMapper = new ObjectMapper();
     User user = objectMapper.readValue(response.body().asString(), User.class);
     apiSharedContext.token = user.getUser().getToken();
  }
  @Given("user creates an article with the following data")
  public void userCreatesAnArticleWithTheFollowingData(DataTable data)
      throws JsonProcessingException {
    Response response = new Article().createNewArticle(data,apiSharedContext.getToken());
    apiSharedContext.articleCreationResponse = response;
    Assert.assertEquals(response.statusCode(),200);
  }

  @Then("user validates the following data from the article")
  public void userValidatesTheFollowingDataFromTheArticle(DataTable articleData)
      throws JsonProcessingException {
    List<Map<String, Object>> data = articleData.asMaps(String.class, Object.class);
    ObjectMapper objectMapper = new ObjectMapper();
    NewArticle newArticle = objectMapper.readValue(apiSharedContext.articleCreationResponse.getBody().asString(), NewArticle.class);
    Assert.assertEquals(newArticle.getArticle().getTitle(),data.get(0).get("title"));
    Assert.assertEquals(newArticle.getArticle().getBody(),data.get(0).get("body"));
    Assert.assertEquals(newArticle.getArticle().getDescription(),data.get(0).get("description"));
  }

  @And("the user marks it as favourite")
  public void theUserMarksItAsFavourite() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    NewArticle newArticle = objectMapper.readValue(apiSharedContext.articleCreationResponse.getBody().asString(), NewArticle.class);
    apiSharedContext.slug = newArticle.getArticle().getSlug();
    Response response = new Article().markArticleAsFavourite(apiSharedContext.slug,apiSharedContext.token);
    Assert.assertEquals(response.statusCode(),200);
  }

  @And("the user deletes the article")
  public void theUserDeletesTheArticle() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    NewArticle newArticle = objectMapper.readValue(apiSharedContext.articleCreationResponse.getBody().asString(), NewArticle.class);
    apiSharedContext.slug = newArticle.getArticle().getSlug();
    Response response = new Article().deleteArticle(apiSharedContext.slug,apiSharedContext.token);
    Assert.assertEquals(response.statusCode(),204);
  }
}
