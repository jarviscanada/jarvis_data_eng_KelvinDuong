package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.util.TweetUtil;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TwitterDaoIntTest {

  private TwitterDao dao;

  @Before
  public void setup() {
    String consumerKey = System.getenv("consumerKey");
    String consumerSecret = System.getenv("consumerSecret");
    String accessToken = System.getenv("accessToken");
    String tokenSecret = System.getenv("tokenSecret");
    HttpHelper httpHelper = new TwitterHttpHelper(consumerKey, consumerSecret, accessToken, tokenSecret);
    this.dao = new TwitterDao(httpHelper);
  }

  @Test
  public void create() throws Exception {
    String hashtag = "#abc";
    String text = "@kelvin this is text " + hashtag + " " + System.currentTimeMillis();
    Double lat = 1d;
    Double lon = -1d;
    Tweet postTweet = TweetUtil.buildTweet(text, lon, lat);

    Tweet tweet = dao.create(postTweet);

    assertEquals(text, tweet.getText());
    assertNotNull(tweet.getCoordinates());
    assertEquals(2, tweet.getCoordinates().getCoordinates().length);
    assertEquals(lon, tweet.getCoordinates().getCoordinates()[0]);
    assertEquals(lat, tweet.getCoordinates().getCoordinates()[1]);

    assertTrue(hashtag.contains(tweet.getEntities().getHashtags().get(0).getText()));
  }

  @Test
  public void findById() {
    String hashtag = "#abc";
    String text = "@kelvin this is text " + hashtag + " " + System.currentTimeMillis();
    Double lat = 1d;
    Double lon = -1d;
    Tweet postTweet = TweetUtil.buildTweet(text, lon, lat);

    Tweet tweet = dao.create(postTweet);
    Tweet foundTweet = dao.findById(tweet.getIdStr());
    assertEquals(text, foundTweet.getText());
    assertNotNull(foundTweet.getCoordinates());
    assertEquals(2, foundTweet.getCoordinates().getCoordinates().length);
    assertEquals(lon, foundTweet.getCoordinates().getCoordinates()[0]);
    assertEquals(lat, foundTweet.getCoordinates().getCoordinates()[1]);

    assertTrue(hashtag.contains(foundTweet.getEntities().getHashtags().get(0).getText()));
  }

  @Test
  public void deleteById() {
    String hashtag = "#abc";
    String text = "@kelvin this is text " + hashtag + " " + System.currentTimeMillis();
    Double lat = 1d;
    Double lon = -1d;
    Tweet postTweet = TweetUtil.buildTweet(text, lon, lat);

    Tweet tweet = dao.create(postTweet);
    Tweet deletedTweet = dao.deleteById(tweet.getIdStr());
    assertEquals(text, deletedTweet.getText());
    assertNotNull(deletedTweet.getCoordinates());
    assertEquals(2, deletedTweet.getCoordinates().getCoordinates().length);
    assertEquals(lon, deletedTweet.getCoordinates().getCoordinates()[0]);
    assertEquals(lat, deletedTweet.getCoordinates().getCoordinates()[1]);

    assertTrue(hashtag.contains(deletedTweet.getEntities().getHashtags().get(0).getText()));
  }
}
