package ca.jrvs.practice.codingChallenge;


import java.util.Arrays;
import java.util.HashMap;

/**
 * ticket: https://www.notion.so/Two-Sum-abd5b26752a3400582213e95c0a40335
 */
public class TwoSum {

  /**
   * Big-O: O(n^2)
   * Justification: loop of n-1 withing a loop of n
   */
  public Boolean twoSumBrute(int[] array, int sum) {
    if (array.length == 1) {
      return array[0] == sum;
    } else if (array.length == 0) {
      return false;
    } else {
      for (int i = 0; i < array.length; i++) {
        for (int j = i + 1; j < array.length; j++) {
          if ((i + j) == sum) {
            return true;
          }
        }
      }
      return false;
    }
  }

  /**
   * Big-O: O(nlogn)
   * Justification: sorting takes nlogn then one loop of n. O(n + nlogn) = O(nlogn)
   */
  public Boolean twoSumSorted(int[] array, int value) {
    int[] temp = Arrays.copyOf(array, array.length);
    Arrays.sort(temp);
    int i = 0, j = array.length - 1;
    while (i < j) {
      int sum = temp[i] + temp[j];
      if (sum == value) {
        return true;
      } else if (sum < value) {
        i++;
      } else {
        j--;
      }
    }
    return false;
  }

  /**
   * Big-O: O(n)
   * Justification: adding values in the array to the hashmap takes O(n). looping
   * through it again takes n
   */
  public Boolean twoSumMap(int[] array, int value) {
    HashMap<Integer, Integer> map = new HashMap();
    for (int i = 0; i < array.length; i++) {
      if (map.containsKey(array[i])) {
        map.put(array[i], map.get(array[i]) + 1);
      } else {
        map.put(array[i], 1);
      }
    }
    for (int i = 0; i < array.length; i++) {
      int key = array[i];
      if (map.containsKey(value - key)) {
        if (value / 2 == key) {
          return map.get(key) > 1;
        } else {
          return true;
        }
      }
    }
    return false;
  }
}