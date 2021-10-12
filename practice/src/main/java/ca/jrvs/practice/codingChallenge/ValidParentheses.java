package ca.jrvs.practice.codingChallenge;

import java.util.HashMap;
import java.util.Stack;

/**
 * ticket: https://www.notion.so/jarviscanada/Check-if-a-number-is-even-or-odd-4cbdd9acd9504c04b9b4ef0213f8084d
 */
public class ValidParentheses {

  /**
   * Big-O: O(n)
   * Justification: Loop through length of string
   */
  public boolean isValid(String s) {
    if (!(s.length() % 2 == 0)) {
      return false;
    }
    HashMap<Character, Character> parenthesesMap = new HashMap<>();
    Stack<Character> stack = new Stack<>();
    parenthesesMap.put('(', ')');
    parenthesesMap.put('{', '}');
    parenthesesMap.put('[', ']');

    for (int i = 0; i < s.length(); i++) {
      Character character = s.charAt(i);
      if (parenthesesMap.containsKey(character)) {
        stack.push(parenthesesMap.get(character));
      } else if (stack.isEmpty()) {
        return false;
      } else if (character == stack.peek()) {
        stack.pop();
      } else {
        return false;
      }
    }
    return stack.isEmpty();

  }
}