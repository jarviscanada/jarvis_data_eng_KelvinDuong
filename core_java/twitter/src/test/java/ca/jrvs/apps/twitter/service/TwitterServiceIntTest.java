package ca.jrvs.apps.twitter.service;

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


public class TwitterServiceIntTest {

  private TwitterDao dao;
  private TwitterService service;

  private String hashtag = "#abc";
  private Double lat = 1d;
  private Double lon = -1d;

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
  }

  @Test
  public void postTweet() throws Exception {
    String text = "@kelvin this is my text " + hashtag + " " + System.currentTimeMillis();
    Tweet postTweet = TweetUtil.buildTweet(text, lon, lat);
    Tweet tweet = service.postTweet(postTweet);

    // Case should work
    assertEquals(text, tweet.getText());
    assertNotNull(tweet.getCoordinates());
    assertEquals(2, tweet.getCoordinates().getCoordinates().length);
    assertEquals(lon, tweet.getCoordinates().getCoordinates()[0]);
    assertEquals(lat, tweet.getCoordinates().getCoordinates()[1]);

    // Exceed character limit
    String overLimit = "1j5zXrUypqR85jq0khrrjV0KGG83IM7jsUet7pnel5xpNJ6CEpRkBAXLR7CbaFHAz"
        + "BkmTLfBRvUOLizlodA9yQ4lbmiGbrJhyjaX46Pb4DVDcwoOYohkaf5Shu1YxJ9ise1MxHDNX9Duz\n";
    Tweet tweetFail = TweetUtil.buildTweet(overLimit, lon, lat);
    try {
      tweet = service.postTweet(tweetFail);
      assertTrue(false);
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }

    // Invalid longitude and latitude
    tweetFail = TweetUtil.buildTweet(text, -200.0, lat);
    try {
      tweet = service.postTweet(tweetFail);
      assertTrue(false);
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }

    // Invalid latitude
    tweetFail = TweetUtil.buildTweet(text, lon, 299.00);
    try {
      tweet = service.postTweet(tweetFail);
      assertTrue(false);
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }
  }

  @Test
  public void showTweet() throws Exception {
    String text = "@kelvin this is a new text " + hashtag + " " + System.currentTimeMillis();
    Tweet postTweet = TweetUtil.buildTweet(text, lon, lat);
    String[] fields = new String[]{"created_at", "text",
        "coordinates", "retweet_count", "favorite_count", "favorited", "retweeted"};
    Tweet tweet = service.postTweet(postTweet);
    Tweet foundTweet = service.showTweet(tweet.getIdStr(), fields);
    assertEquals(text, foundTweet.getText());
    assertNotNull(foundTweet.getCoordinates());
    // id, id_str and entities should be null
    assertNull(foundTweet.getId());
    assertNull(foundTweet.getIdStr());
    assertNull(foundTweet.getEntities());
  }

  @Test
  public void deleteTweets() throws Exception {
    String text = "@kelvin this is text " + hashtag + " " + System.currentTimeMillis();
    Tweet postTweet = TweetUtil.buildTweet(text, lon, lat);
    Tweet postTweet2 = TweetUtil.buildTweet(text + "second tweet", lon, lat);
    Tweet tweet = service.postTweet(postTweet);
    Tweet tweet2 = service.postTweet(postTweet2);

    List<Tweet> tweetList = service.deleteTweets(new String[]{tweet.getIdStr(), tweet2.getIdStr()});
    assertEquals(text, tweetList.get(0).getText());
    assertEquals(text + "second tweet", tweetList.get(1).getText());
    assertEquals(lon, tweet.getCoordinates().getCoordinates()[0]);
    assertEquals(lat, tweet.getCoordinates().getCoordinates()[1]);
    assertEquals(lon, tweet2.getCoordinates().getCoordinates()[0]);
    assertEquals(lat, tweet2.getCoordinates().getCoordinates()[1]);
  }

}
