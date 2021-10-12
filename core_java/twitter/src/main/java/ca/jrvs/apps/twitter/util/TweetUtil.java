package ca.jrvs.apps.twitter.util;

import ca.jrvs.apps.twitter.model.Coordinates;
import ca.jrvs.apps.twitter.model.Entities;
import ca.jrvs.apps.twitter.model.Hashtag;
import ca.jrvs.apps.twitter.model.Tweet;
import java.util.ArrayList;

public class TweetUtil {

  public static Tweet buildTweet(String text, Double lon, Double lat) {
    Tweet tweet = new Tweet();
    Coordinates coordinates = new Coordinates();
    coordinates.setCoordinates(new Double[]{lon, lat});
    coordinates.setType("point");

    tweet.setText(text);
    tweet.setCoordinates(coordinates);
    return tweet;
  }
 }
