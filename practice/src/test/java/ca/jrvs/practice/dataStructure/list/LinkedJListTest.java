package ca.jrvs.practice.dataStructure.list;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LinkedJListTest {

  @Test
  public void add() {
    LinkedJList list = new LinkedJList();
    assertEquals(0, list.size());
    list.add("First");
    assertEquals("First", list.get(0));
    assertEquals(1, list.size());
  }

  @Test
  public void toArray() {
    LinkedJList list = new LinkedJList();
    list.add("First");
    list.add("Second");
    list.add("Third");
    Object[] arrayString = new Object[]{"First", "Second", "Third"};
    assertEquals(list.toArray(), arrayString);
  }

  @Test
  public void size() {
    LinkedJList list = new LinkedJList();
    assertEquals(0, list.size());
    list.add("First");
    assertEquals(1, list.size());
    list.add("Second");
    assertEquals(2, list.size());
    list.add("Third");
    assertEquals(3, list.size());
  }

  @Test
  public void isEmpty() {
    LinkedJList list = new LinkedJList();
    assertTrue(list.isEmpty());
    list.add("First");
    assertFalse(list.isEmpty());
  }

  @Test
  public void indexOf() {
    LinkedJList list = new LinkedJList();
    list.add("First");
    list.add("Second");
    assertEquals(0, list.indexOf("First"));
    assertEquals(1, list.indexOf("Second"));
  }

  @Test
  public void contains() {
    LinkedJList list = new LinkedJList();
    list.add("First");
    assertTrue(list.contains("First"));
    assertFalse(list.contains("Second"));
  }

  @Test
  public void get() {
    LinkedJList list = new LinkedJList();
    list.add("First");
    list.add("Second");
    assertEquals("First", list.get(0));
    assertEquals("Second", list.get(1));
  }

  @Test
  public void remove() {
    LinkedJList list = new LinkedJList();
    list.add("First");
    list.add("Second");
    list.add("Third");
    assertEquals("Second", list.get(1));
    list.remove(1);
    assertEquals("Third", list.get(1));
  }

  @Test
  public void clear() {
    LinkedJList list = new LinkedJList();
    list.add("First");
    list.add("Second");
    list.add("Third");
    list.clear();
    assertTrue(list.isEmpty());
  }
}