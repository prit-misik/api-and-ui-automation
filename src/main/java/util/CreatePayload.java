package util;

import base.BasePage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreatePayload extends BasePage {

  public static String createArticlePayload(DataTable articleData) {
    try {
      List<Map<String, Object>> data = articleData.asMaps(String.class, Object.class);
      Map<String, Object> details = new HashMap<>();
      details.put("title", (String) data.get(0).get("title"));
      details.put("description", (String) data.get(0).get("description"));
      details.put("body", (String) data.get(0).get("body"));
      String tags = (String) data.get(0).get("tagList");
      details.put("tagList", Arrays.asList(tags.split(",")));

      Map<String, Object> articlePayload = new HashMap<>();
      articlePayload.put("article", details);
      ObjectMapper mapper = new ObjectMapper();
      return mapper.writeValueAsString(articlePayload);
    } catch (JsonProcessingException e) {
      APP_LOGS.error(e.getMessage());

    }
    return null;
  }
}
