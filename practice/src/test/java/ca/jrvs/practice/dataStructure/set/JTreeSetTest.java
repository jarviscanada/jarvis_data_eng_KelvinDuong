package ca.jrvs.practice.dataStructure.set;

import static org.junit.Assert.*;

import org.junit.Test;

public class JTreeSetTest {

  @Test
  public void size() {
    JTreeSet<String> set = new JTreeSet<>();
    assertEquals(0, set.size());
    set.add("First");
    assertEquals(1, set.size());
    set.add("Second");
    assertEquals(2, set.size());
  }

  @Test
  public void contains() {
    JTreeSet<String> set = new JTreeSet<>();
    set.add("First");
    assertTrue(set.contains("First"));
    assertFalse(set.contains("Second"));
  }

  @Test
  public void add() {
    JTreeSet<String> set = new JTreeSet<>();
    set.add("First");
    assertTrue(set.contains("First"));
    set.add("Second");
    assertTrue(set.contains("Second"));
  }

  @Test
  public void remove() {
    JTreeSet<String> set = new JTreeSet<>();
    set.add("First");
    assertTrue(set.contains("First"));
    set.remove("First");
    assertFalse(set.contains("First"));
  }

  @Test
  public void clear() {
    JTreeSet<String> set = new JTreeSet<>();
    set.add("First");
    set.add("Second");
    set.clear();
    assertFalse(set.contains("First"));
    assertFalse(set.contains("Second"));
    assertEquals(0, set.size());
  }
}