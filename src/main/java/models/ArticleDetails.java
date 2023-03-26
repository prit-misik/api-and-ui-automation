package models;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDetails {
  public String slug;
  public String title;
  public String description;
  public String body;
  public Date createdAt;
  public Date updatedAt;
  public ArrayList<String> tagList;
  public boolean favorited;
  public int favoritesCount;
  public JsonNode author;
}
