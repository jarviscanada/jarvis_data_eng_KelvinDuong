package ca.jrvs.apps.twitter.controller;

import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.TwitterService;
import ca.jrvs.apps.twitter.util.TweetUtil;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class TwitterControllerIntTest {

  private TwitterDao dao;
  private TwitterService service;
  private TwitterController controller;

  private String hashtag = "#abc";
  private String coords = "15:-18";
  private Double lon = 15.0;
  private Double lat = -18.0;

  @Before
  public void setup() {
    String consumerKey = System.getenv("consumerKey");
    String consumerSecret = System.getenv("consumerSecret");
    String accessToken = System.getenv("accessToken");
    String tokenSecret = System.getenv("tokenSecret");
    HttpHelper httpHelper = new TwitterHttpHelper(consumerKey, consumerSecret, accessToken,
        tokenSecret);
    this.dao = new TwitterDao(httpHelper);
    this.service = new TwitterService(dao);
    this.controller = new TwitterController(service);
  }

  @Test
  public void postTweet() throws Exception {
    Tweet tweet;
    String text = "@kelvin this is my text " + hashtag + " " + System.currentTimeMillis();

    // Expected bad case
    String[] badArg = {"Not", "enough"};
    try {
      controller.postTweet(badArg);
      fail();
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }

    // Expected good case
    String[] goodArg = {"post", text, coords};
    tweet = controller.postTweet(goodArg);
    assertEquals(lon, tweet.getCoordinates().getCoordinates()[0]);
    assertEquals(lat, tweet.getCoordinates().getCoordinates()[1]);
  }

  @Test
  public void showTweet() throws Exception {
    String text = "@kelvin this is my text " + hashtag + " " + System.currentTimeMillis();

    // Expected bad case
    String[] badArg = {"Not", "enough"};
    try {
      controller.showTweet(badArg);
      fail();
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }

    // Expected good case
    String[] postArg = {"post", text, coords};
    Tweet tweet = controller.postTweet(postArg);
    String fields = "created_at,text,coordinates,retweet_count,favorite_count,favorited,retweeted";
    String[] showArg = {"show", tweet.getIdStr(), fields};
    Tweet foundTweet = controller.showTweet(showArg);
    assertEquals(lon, foundTweet.getCoordinates().getCoordinates()[0]);
    assertEquals(lat, foundTweet.getCoordinates().getCoordinates()[1]);
    assertEquals(text, foundTweet.getText());
  }

  @Test
  public void deleteTweet() throws Exception {
    String text = "@kelvin this is my text " + hashtag + " " + System.currentTimeMillis();

    // Expected bad case
    String[] badArg = {"Too", "many", "args"};
    try {
      controller.deleteTweet(badArg);
      fail();
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }

    // Expected good case deleting two ids
    String[] postArg = {"post", text, coords};
    String[] postArg2 = {"post", text + "second one", coords};
    Tweet tweet = controller.postTweet(postArg);
    Tweet tweet2 = controller.postTweet(postArg2);
    String[] deletetArg = {"delete", tweet.getIdStr() + "," + tweet2.getIdStr()};
    List<Tweet> deletedTweet = controller.deleteTweet(deletetArg);

    assertEquals(2, deletedTweet.size());
    assertEquals(lon, deletedTweet.get(0).getCoordinates().getCoordinates()[0]);
    assertEquals(lat, deletedTweet.get(0).getCoordinates().getCoordinates()[1]);
    assertEquals(text, deletedTweet.get(0).getText());
    assertEquals(lon, deletedTweet.get(1).getCoordinates().getCoordinates()[0]);
    assertEquals(lat, deletedTweet.get(1).getCoordinates().getCoordinates()[1]);
    assertEquals(text + "second one", deletedTweet.get(1).getText());
  }
}