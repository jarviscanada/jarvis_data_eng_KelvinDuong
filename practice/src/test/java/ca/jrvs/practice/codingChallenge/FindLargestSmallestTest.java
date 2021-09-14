package ca.jrvs.practice.codingChallenge;

import junit.framework.TestCase;

public class FindLargestSmallestTest extends TestCase {

  public void testFindLargestSmallestArray() {
    Integer[] array = new Integer[]{5, 6, 7, 3, 2, 1};
    FindLargestSmallest findLargestSmallest = new FindLargestSmallest();
    Integer[] output = findLargestSmallest.findLargestSmallestArray(array);
    assertEquals(1, (int) output[0]);
    assertEquals(7, (int) output[1]);
  }

  public void testFindLargestSmallestStream() {
    Integer[] array = new Integer[]{5, 6, 7, 3, 2, 1};
    FindLargestSmallest findLargestSmallest = new FindLargestSmallest();
    Integer[] output = findLargestSmallest.findLargestSmallestStream(array);
    assertEquals(1, (int) output[0]);
    assertEquals(7, (int) output[1]);
  }

  public void testFindLargestSmallestAPI() {
    Integer[] array = new Integer[]{5, 6, 7, 3, 2, 1};
    FindLargestSmallest findLargestSmallest = new FindLargestSmallest();
    Integer[] output = findLargestSmallest.findLargestSmallestAPI(array);
    assertEquals(1, (int) output[0]);
    assertEquals(7, (int) output[1]);
  }
}