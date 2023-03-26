package client;

import io.restassured.response.Response;
import java.util.HashMap;
import models.User;
import models.UserData;
import models.UserDataPayload;
import util.APIUtils;
import util.ReqSpecification;
import util.TestUtils;

public class Registration {

  private final HashMap<String, String> map = TestUtils.getPropFileValues();

  public UserData createUserData() {
    return UserDataPayload.builder()
        .username(APIUtils.generateRandomUserName())
        .email(APIUtils.generateRandomUserName() + "@gmail.com")
        .password(APIUtils.generateRandomUserName())
        .build();
  }

  public User createUser() {
    return User.builder().user(createUserData()).build();
  }

  public Response registerNewUser() {
    User user = createUser();
    ReqSpecification reqSpecification = new ReqSpecification();
    Response response = APIUtils.makePOSTCall(reqSpecification.createReqSpec(),
        map.get("api.users"), user);
    response.then().log().all();
    return response;
  }
}
