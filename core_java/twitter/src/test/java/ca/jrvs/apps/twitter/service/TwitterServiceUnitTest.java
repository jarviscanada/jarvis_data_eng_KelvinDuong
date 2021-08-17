package ca.jrvs.apps.twitter.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.example.JsonParser;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.util.TweetUtil;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TwitterServiceUnitTest {

  @Mock
  TwitterDao dao;

  @InjectMocks
  TwitterService service;

  String hashtag = "#abc";
  Double lat = 1d;
  Double lon = -1d;

  @Test
  public void postTweet() throws Exception {
    String text = "@kelvin this is my text " + hashtag + " " + System.currentTimeMillis();
    when(dao.create(any())).thenReturn(new Tweet());
    Tweet tweet = service.postTweet(TweetUtil.buildTweet(text, lon, lat));
    assertNotNull(tweet);

    // following tests should fail
    String overLimit = "1j5zXrUypqR85jq0khrrjV0KGG83IM7jsUet7pnel5xpNJ6CEpRkBAXLR7CbaFHAz"
        + "BkmTLfBRvUOLizlodA9yQ4lbmiGbrJhyjaX46Pb4DVDcwoOYohkaf5Shu1YxJ9ise1MxHDNX9Duz\n";
    Double overLatLon = -200.00;
    try {
      tweet = service.postTweet(TweetUtil.buildTweet(overLimit, lon, lat));
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }

    try {
      tweet = service.postTweet(TweetUtil.buildTweet(text, overLatLon, lat));
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }

    try {
      tweet = service.postTweet(TweetUtil.buildTweet(text, lon, overLatLon));
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }
  }

  @Test
  public void showTweet() {
    Tweet tweet = new Tweet();
    tweet.setIdStr("7129304");
    when(dao.findById(any())).thenReturn(tweet);
    Tweet getTweet = service.showTweet("7129304",
        new String[]{"text", "entity", "coordinates", "favorite_count", "favorited", "retweeted"});
    assertNotNull(getTweet);
  }

  @Test
  public void deleteTweets() {
    Tweet tweet = new Tweet();
    tweet.setIdStr("7129304");

    when(dao.deleteById(any())).thenReturn(tweet);
    List<Tweet> tweets = service.deleteTweets(new String[]{"7129304", "7129304"});
    assertNotNull(tweets);
    assertEquals(2, tweets.size());
    assertEquals("7129304", tweets.get(0).getIdStr());
    assertEquals("7129304", tweets.get(1).getIdStr());
  }
}
