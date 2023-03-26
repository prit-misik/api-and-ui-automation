package util;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;
import org.apache.commons.lang.RandomStringUtils;

public class APIUtils {

  public static Response makeGETCall(RequestSpecification spec, String path){
    return RestAssured.given(spec).basePath(path).get().then().extract().response();
  }
  public static Response makePOSTCall(RequestSpecification spec, String path, String token){
    return RestAssured.given(spec).basePath(path).header("jwtauthorization", "Token ".concat(token)).post().then().extract().response();
  }
  public static Response makePOSTCall(RequestSpecification spec, String path, Object obj){
    return RestAssured.given(spec).basePath(path).body(obj).post().then().extract().response();
  }
  public static Response makePOSTCall(RequestSpecification spec, String path, Object obj, String token){
    return RestAssured.given(spec).basePath(path).header("jwtauthorization", "Token ".concat(token)).body(obj).post().then().extract().response();
  }
  public static Response makePOSTCall(RequestSpecification spec, String path, String token, Map<String, String> pathParamMap) {
    return RestAssured.given(spec).basePath(path).pathParams(pathParamMap).header("jwtauthorization", "Token ".concat(token)).post().then().extract().response();
  }
  public static Response makeDELETECall(RequestSpecification spec, String path, String token, Map<String, String> pathParamMap) {
    return RestAssured.given(spec).basePath(path).pathParams(pathParamMap).header("jwtauthorization", "Token ".concat(token)).delete().then().extract().response();
  }

  public static String generateRandomUserName() {
    return RandomStringUtils.randomAlphabetic(6).toLowerCase();
  }

}
