package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Arrays;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "text",
    "indices"
})
public class Hashtag {

  @JsonProperty("text")
  private String text;
  @JsonProperty("indices")
  private Integer[] indices;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Integer[] getIndices() {
    return indices;
  }

  public void setIndices(Integer[] indices) {
    this.indices = indices;
  }

  @Override
  public String toString() {
    return "Hashtag{" +
        "text='" + text + '\'' +
        ", indices=" + Arrays.toString(indices) +
        '}';
  }
}
