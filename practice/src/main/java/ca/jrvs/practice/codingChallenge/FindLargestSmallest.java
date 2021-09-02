package ca.jrvs.practice.codingChallenge;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ticket: https://www.notion.so/jarvisdev/Find-Largest-Smallest-6bfe9de90c454509930891e8552ed38b
 */
public class FindLargestSmallest {

  /**
   * Big-O: O(n)
   * Justification: Loop through array once
   */
  public Integer[] findLargestSmallestArray(Integer[] n) {
    int smallest = Integer.MAX_VALUE, largest = Integer.MIN_VALUE;
    for (int i = 0; i < n.length; i++) {
      if (n[i] > largest) {
        largest = n[i];
      } else if (n[i] < smallest) {
        smallest = n[i];
      }
    }
    return new Integer[]{smallest, largest};
  }

  /**
   * Big-O: O(n)
   * Justification: Loop through the array twice. Checks for max first and then min
   */
  public Integer[] findLargestSmallestStream(Integer[] n) {
    int smallest = Integer.MAX_VALUE, largest = Integer.MIN_VALUE;
    List<Integer> listOfInteger = Arrays.asList(n);
    largest = listOfInteger
        .stream()
        .mapToInt(v -> v)
        .max().orElseThrow(RuntimeException::new);
    ;
    smallest = listOfInteger
        .stream()
        .mapToInt(v -> v)
        .min().orElseThrow(RuntimeException::new);
    ;
    return new Integer[]{smallest, largest};
  }

  /**
   * Big-O: O(n)
   * Justification: Don't know how it's implemented. Assumes that it checks the entire
   * array
   */
  public Integer[] findLargestSmallestAPI(Integer[] n) {
    int smallest = Integer.MAX_VALUE, largest = Integer.MIN_VALUE;
    List<Integer> listOfInteger = Arrays.asList(n);
    largest = Collections.max(listOfInteger);
    smallest = Collections.min(listOfInteger);
    return new Integer[]{smallest, largest};
  }
}
