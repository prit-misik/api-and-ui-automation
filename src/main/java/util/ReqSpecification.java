package util;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import java.util.HashMap;

public class ReqSpecification {

  private static final HashMap<String, String> map = TestUtils.getPropFileValues();

  public RequestSpecification createReqSpec() {
    return RestAssured.given().log().all()
    .baseUri(map.get("url"))
        .auth().basic(map.get("username"),
            map.get("password"))
        .header("content-type", "application/json");

  }
}
