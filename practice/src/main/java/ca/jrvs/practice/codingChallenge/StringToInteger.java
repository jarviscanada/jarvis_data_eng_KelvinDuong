package ca.jrvs.practice.codingChallenge;


import java.util.Arrays;

/**
 * ticket: https://www.notion.so/jarvisdev/String-to-Integer-a-12bfd0bd8c2b468db3eb085b460d5140
 */
public class StringToInteger {

  /**
   * Big-O: O(n)
   * Justification: uses java built in method
   */
  public int stringToInteger(String string) {
    int parsedValue, negative = 1;
    // remove spaces and non digits
    string = string.trim();
    // check if it's negative
    if (string.charAt(0) == '-') {
      negative = -1;
      string = string.substring(1);
    }
    string = string.replaceAll("[^\\d.]", "");
    try {
      parsedValue = Integer.parseInt(string);
    } catch (NumberFormatException e) {
      throw new NumberFormatException("String not parsable");
    }
    return negative * parsedValue;
  }

  /**
   * Big-O: O(n)
   * Justification: one loop
   */
  public int stringToIntegerAscii(String string) {
    int parsedValue = 0, negative = 1, decimal = 1;
    // remove spaces and non digits
    string = string.trim();
    // check if it's negative
    if (string.charAt(0) == '-') {
      negative = -1;
      string = string.substring(1);
    }
    string = string.replaceAll("[^\\d.]", "");
    for (int i = string.length() - 1; i >= 0; i--) {
      int ascii = (int) string.charAt(i);
      parsedValue = parsedValue + ((ascii % 48) * decimal);
      decimal = decimal * 10;
    }
    return negative * parsedValue;
  }
}