package sharedContext;

import io.restassured.response.Response;
import lombok.Data;

@Data
public class APISharedContext {

  public String token;
  public Response articleCreationResponse;
  public String slug;
}
