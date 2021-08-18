package ca.jrvs.apps.twitter.controller;

import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.Service;
import ca.jrvs.apps.twitter.util.TweetUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class TwitterController implements Controller {

  private static final String COORD_SEP = ":";
  private static final String COMMA = ",";

  private Service service;

  @Autowired
  public TwitterController(Service service) {
    this.service = service;
  }

  /**
   * Parse user argument and post a tweet by calling service classes
   *
   * @param args
   * @return a posted tweet
   * @throws IllegalArgumentException if args are invalid
   */
  @Override
  public Tweet postTweet(String[] args) {
    Tweet tweet;
    if (args.length != 3) {
      throw new IllegalArgumentException("Usage: TwitterApp post tweet_text latitude:longitude");
    }
    String text = args[1];
    String[] coords = args[2].split(COORD_SEP);
    try {
      Double longitude = Double.parseDouble(coords[0]);
      Double latitude = Double.parseDouble(coords[1]);
      tweet = TweetUtil.buildTweet(text, longitude, latitude);
    } catch (Exception e) {
      throw new IllegalArgumentException("Usage: TwitterApp post tweet_text latitude:longitude");
    }
    return service.postTweet(tweet);
  }

  /**
   * Parse user argument and search a tweet by calling service classes
   *
   * @param args
   * @return a tweet
   * @throws IllegalArgumentException if args are invalid
   */
  @Override
  public Tweet showTweet(String[] args) {
    if (args.length != 3) {
      throw new IllegalArgumentException("Usage: TwitterApp show tweet_id [field1,fields2]");
    }
    String tweetId = args[1];
    String[] fields = null;
    if (!args[2].isEmpty()) {
      fields = args[2].split(COMMA);
    }
    return service.showTweet(tweetId, fields);
  }

  /**
   * Parse user argument and delete tweets by calling service classes
   *
   * @param args
   * @return a list of deleted tweets
   * @throws IllegalArgumentException if args are invalid
   */
  @Override
  public List<Tweet> deleteTweet(String[] args) {
    if (args.length != 2) {
      throw new IllegalArgumentException("TwitterApp delete [id1,id2,..]");
    }
    String[] ids = args[1].split(COMMA);
    return service.deleteTweets(ids);
  }
}
