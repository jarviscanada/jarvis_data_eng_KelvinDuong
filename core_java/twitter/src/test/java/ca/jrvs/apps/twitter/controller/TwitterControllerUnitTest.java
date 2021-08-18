package ca.jrvs.apps.twitter.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.model.Coordinates;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.TwitterService;
import ca.jrvs.apps.twitter.util.TweetUtil;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TwitterControllerUnitTest {

  @Mock
  private TwitterService service;

  @InjectMocks
  private TwitterController controller;

  private String hashtag = "#abc";
  private Double[] coordList = {15.0, -18.0};
  private Double lon = 15.0;
  private Double lat = -18.0;
  private String coords = "15:-18";

  @Test
  public void postTweet() throws Exception {
    Tweet tweet = new Tweet();
    String text = "@kelvin this is my text " + hashtag + " " + System.currentTimeMillis();
    tweet.setText(text);
    Coordinates coordinates = new Coordinates();
    coordinates.setCoordinates(coordList);
    tweet.setCoordinates(coordinates);

    when(service.postTweet(any())).thenReturn(tweet);
    String[] goodArg = {"post", text, coords};
    Tweet postTweet = controller.postTweet(goodArg);
    assertEquals(lon, postTweet.getCoordinates().getCoordinates()[0]);
    assertEquals(lat, postTweet.getCoordinates().getCoordinates()[1]);
  }

  @Test
  public void showTweet() throws Exception {
    Tweet tweet = new Tweet();
    Coordinates coordinates = new Coordinates();
    coordinates.setCoordinates(coordList);
    tweet.setCoordinates(coordinates);
    tweet.setIdStr("1612315115");

    when(service.showTweet(any(), any())).thenReturn(tweet);
    String fields = "created_at,text,coordinates,retweet_count,favorite_count,favorited,retweeted";
    String[] goodArg = {"show", "1612315115", fields};
    Tweet foundTweet = controller.showTweet(goodArg);
    assertEquals(lon, foundTweet.getCoordinates().getCoordinates()[0]);
    assertEquals(lat, foundTweet.getCoordinates().getCoordinates()[1]);
    assertEquals("1612315115", foundTweet.getIdStr());
  }

  @Test
  public void deleteTweet() throws Exception {
    Coordinates coordinates = new Coordinates();
    coordinates.setCoordinates(coordList);

    // Setup tweet objects
    Tweet tweet = new Tweet();
    tweet.setCoordinates(coordinates);
    tweet.setIdStr("1612315115");

    Tweet tweet2 = new Tweet();
    tweet2.setCoordinates(coordinates);
    tweet2.setIdStr("16123151515115");

    // Add to mock list
    List<Tweet> tweetList = new ArrayList<Tweet>();
    tweetList.add(tweet);
    tweetList.add(tweet2);

    when(service.deleteTweets(any())).thenReturn(tweetList);
    String[] deletetArg = {"delete", tweet.getIdStr()};
    List<Tweet> deletedTweet = controller.deleteTweet(deletetArg);
    assertEquals(lon, deletedTweet.get(0).getCoordinates().getCoordinates()[0]);
    assertEquals(lat, deletedTweet.get(0).getCoordinates().getCoordinates()[1]);
    assertEquals("1612315115", deletedTweet.get(0).getIdStr());
    assertEquals(lon, deletedTweet.get(1).getCoordinates().getCoordinates()[0]);
    assertEquals(lat, deletedTweet.get(1).getCoordinates().getCoordinates()[1]);
    assertEquals("16123151515115", deletedTweet.get(1).getIdStr());
  }
}
