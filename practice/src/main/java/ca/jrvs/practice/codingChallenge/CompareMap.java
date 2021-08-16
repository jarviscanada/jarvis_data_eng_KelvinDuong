package ca.jrvs.practice.codingChallenge;

import java.util.Map;

/**
 * ticket: https://www.notion.so/jarvisdev/How-to-compare-two-maps-3ddc5a9c583f4ea8a0ef243217b8da73
 */
public class CompareMap {

  /**
   * Big-O: O(n)
   * Justification: comparing keys and values
   */
  public <K, V> boolean compareMaps(Map<K, V> m1, Map<K, V> m2) {
    return m1.equals(m2);
  }

  // HashJMap implementation not completed as it is deprecated
}