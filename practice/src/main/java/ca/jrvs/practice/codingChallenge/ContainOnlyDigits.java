package ca.jrvs.practice.codingChallenge;

/**
 * ticket: https://www.notion.so/jarvisdev/Check-if-a-String-contains-only-digits-998847b2874f4c818b0cc5326857caf4
 */
public class ContainOnlyDigits {

  /**
   * Big-O: O(n)
   * Justification: Loop through string once
   */
  public Boolean containOnlyDigitsASCII(String n) {
    for (int i = 0; i < n.length(); i++) {
      if ((n.charAt(i) > 57) || (n.charAt(i) < 48)) {
        return false;
      }
    }
    return true;
  }

  public Boolean containOnlyDigitsAPI(String n) {
    try {
      Integer.valueOf(n);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public Boolean containOnlyDigitsRegex(String n) {
    return n.matches("[0-9]+");
  }

}
