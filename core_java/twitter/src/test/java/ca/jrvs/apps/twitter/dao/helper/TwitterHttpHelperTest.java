package ca.jrvs.apps.twitter.dao.helper;

import java.net.URI;
import junit.framework.TestCase;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TwitterHttpHelperTest extends TestCase {

  private TwitterHttpHelper twitterHttpHelper;
  final Logger logger = LoggerFactory.getLogger(TwitterHttpHelper.class);

  public void setUp() throws Exception {
    String consumerKey = System.getenv("consumerKey");
    String consumerSecret = System.getenv("consumerSecret");
    String accessToken = System.getenv("accessToken");
    String tokenSecret = System.getenv("tokenSecret");
    twitterHttpHelper = new TwitterHttpHelper(consumerKey, consumerSecret, accessToken,
        tokenSecret);
  }

  public void testHttpPost() throws Exception {
    HttpResponse httpResponse = twitterHttpHelper.httpPost(
        URI.create("https://api.twitter.com/1.1/statuses/update.json?status=TestingTwitter"));
    logger.info(EntityUtils.toString((httpResponse.getEntity())));
  }

  public void testHttpGet() throws Exception {
    HttpResponse httpResponse = twitterHttpHelper.httpGet(
        URI.create("https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=canada"));
    logger.info(EntityUtils.toString((httpResponse.getEntity())));
  }
}