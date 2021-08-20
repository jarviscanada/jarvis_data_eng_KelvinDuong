package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Arrays;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "indices",
    "screen_name",
    "id",
    "id_str"
})
public class UserMention {

  @JsonProperty("name")
  private String name;
  @JsonProperty("indices")
  private Integer[] indices;
  @JsonProperty("screen_name")
  private String screenName;
  @JsonProperty("id")
  private Long id;
  @JsonProperty("id_str")
  private String idStr;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer[] getIndices() {
    return indices;
  }

  public void setIndices(Integer[] indices) {
    this.indices = indices;
  }

  public String getScreenName() {
    return screenName;
  }

  public void setScreenName(String screenName) {
    this.screenName = screenName;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getIdStr() {
    return idStr;
  }

  public void setIdStr(String idStr) {
    this.idStr = idStr;
  }

  @Override
  public String toString() {
    return "UserMention{" +
        "name='" + name + '\'' +
        ", indices=" + Arrays.toString(indices) +
        ", screenName='" + screenName + '\'' +
        ", id=" + id +
        ", idStr='" + idStr + '\'' +
        '}';
  }
}
