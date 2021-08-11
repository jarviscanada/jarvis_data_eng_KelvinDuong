package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import java.util.HashMap;
import org.junit.Test;

public class CompareMapTest {

  @Test
  public void compareMaps() {
    CompareMap compareMap = new CompareMap();
    HashMap<String, String> m1 = new HashMap<>();
    HashMap<String, String> m2 = new HashMap<>();
    m1.put("a", "b");
    m2.put("a", "b");
    m1.put("c", "d");
    m2.put("c", "d");
    assertTrue(compareMap.compareMaps(m1, m2));
    m2.put("d", "d");
    assertFalse(compareMap.compareMaps(m1, m2));
  }
}