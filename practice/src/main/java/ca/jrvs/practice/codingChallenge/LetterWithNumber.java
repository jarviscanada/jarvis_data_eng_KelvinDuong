package ca.jrvs.practice.codingChallenge;

/**
 * ticket: https://www.notion.so/jarvisdev/Print-letter-with-number-1427e66642a04caaaf16dd14cb6dba40
 */
public class LetterWithNumber {

  /**
   * Big-O: O(n)
   * Justification: Loop through string once
   */
  public void letterWithNumber(String s) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      stringBuilder.append(s.charAt(i));
      stringBuilder.append((s.charAt(i) - 'a' + 1));
    }
    System.out.print(stringBuilder.toString());
  }

  public static void main(String[] args) {
    LetterWithNumber letterWithNumber = new LetterWithNumber();
    letterWithNumber.letterWithNumber("abcdefghijklmnopqrstuvwxyz");
  }
}


