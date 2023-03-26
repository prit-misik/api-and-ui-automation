package util;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class ReqSpec {

    public static RequestSpecification createReqSpecForRegistration(){

      RequestSpecification spec = RestAssured.given();
      spec.baseUri(TestUtils.getPropFileValues().get("url"))
          .auth().basic(TestUtils.getPropFileValues().get("username"),TestUtils.getPropFileValues().get("password"))
          .header("content-type", "application/json");
      return spec;
    }
  }

