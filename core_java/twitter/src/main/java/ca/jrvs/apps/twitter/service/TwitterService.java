package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.model.Tweet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class TwitterService implements Service {

  private CrdDao dao;
  private String[] allFields = new String[]{"created_at", "id", "id_str", "text", "entities",
      "coordinates", "retweet_count", "favorite_count", "favorited", "retweeted"};

  @Autowired
  public TwitterService(CrdDao dao) {
    this.dao = dao;
  }

  /**
   * Validate and post a user input Tweet
   *
   * @param tweet tweet to be created
   * @return created tweet
   * @throws IllegalArgumentException if text exceed max number of allowed characters or lat/long
   *                                  out of range
   */
  @Override
  public Tweet postTweet(Tweet tweet) {
    validatePostTweet(tweet);
    return (Tweet) dao.create(tweet);
  }

  public void validatePostTweet(Tweet tweet) {
    Double lon = tweet.getCoordinates().getCoordinates()[0];
    Double lat = tweet.getCoordinates().getCoordinates()[1];
    Double maxLon = 180.0, maxLat = 90.0;
    if (-maxLon >= lon || lon >= maxLon) {
      throw new IllegalArgumentException("Latitude/Longitude out of range");
    } else if (-maxLat >= lat || lat >= maxLat) {
      throw new IllegalArgumentException("Latitude/Longitude out of range");
    } else if (tweet.getText().length() > 140) {
      throw new IllegalArgumentException("Exceeding maximum number of characters");
    }
  }

  /**
   * Search a tweet by ID
   *
   * @param id     tweet id
   * @param fields set fields not in the list to null
   * @return Tweet object which is returned by the Twitter API
   * @throws IllegalArgumentException if id or fields param is invalid
   */
  @Override
  public Tweet showTweet(String id, String[] fields) {
    validateId(id);
    List<String> fieldList = Arrays.asList(fields);
    List<String> fieldsToNull = new LinkedList<String>(Arrays.asList(allFields));
    Tweet tweet = (Tweet) dao.findById(id);
    // get the fields that need to be set to null
    for (String field : fieldList) {
      fieldsToNull.remove(field);
    }
    // set the fields to null
    for (String field : fieldsToNull) {
      switch (field) {
        case "created_at":
          tweet.setCreatedAt(null);
          break;
        case "id":
          tweet.setId(null);
          break;
        case "id_str":
          tweet.setIdStr(null);
          break;
        case "text":
          tweet.setText(null);
          break;
        case "entities":
          tweet.setEntities(null);
          break;
        case "coordinates":
          tweet.setCoordinates(null);
          break;
        case "retweet_count":
          tweet.setRetweetCount(null);
          break;
        case "favorite_count":
          tweet.setFavoriteCount(null);
          break;
        case "favorited":
          tweet.setFavorited(null);
          break;
        case "retweeted":
          tweet.setRetweeted(null);
          break;
      }
    }
    return tweet;
  }

  public void validateId(String id) {
    try {
      Long.parseLong(id);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Unable to parse ID");
    }
  }

  /**
   * Delete Tweet(s) by id(s).
   *
   * @param ids tweet IDs which will be deleted
   * @return A list of Tweets
   * @throws IllegalArgumentException if one of the IDs is invalid.
   */
  @Override
  public List<Tweet> deleteTweets(String[] ids) {
    List<Tweet> tweets = new ArrayList<>();
    for (String id : ids) {
      validateId(id);
      tweets.add((Tweet) dao.deleteById(id));
    }
    return tweets;
  }
}
