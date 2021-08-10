package ca.jrvs.practice.dataStructure.list;

import static org.junit.Assert.*;


import ca.jrvs.practice.dataStructure.list.ArrayJLists;
import org.junit.Before;
import org.junit.Test;

public class ArrayJListsTest {

  @Test
  public void add() {
    ArrayJLists<String> array = new ArrayJLists<>();
    array.add("First");
    array.add("Second");
    array.add("Third");
    assertEquals("First", array.get(0));
    assertEquals("Second", array.get(1));
    assertEquals("Third", array.get(2));
  }

  @Test
  public void toArray() {
    ArrayJLists<String> array = new ArrayJLists<>();
    array.add("First");
    array.add("Second");
    Object[] arrayString = new Object[]{"First", "Second"};
    assertEquals(array.toArray(), arrayString);
  }

  @Test
  public void size() {
    ArrayJLists<String> array = new ArrayJLists<>();
    assertEquals(0, array.size());
    array.add("First");
    assertEquals(1, array.size());
    array.add("Second");
    assertEquals(2, array.size());
    array.add("Third");
    assertEquals(3, array.size());
  }

  @Test
  public void isEmpty() {
    ArrayJLists<String> array = new ArrayJLists<>();
    assertTrue(array.isEmpty());
  }

  @Test
  public void indexOf() {
    ArrayJLists<String> array = new ArrayJLists<>();
    array.add("First");
    assertEquals(0, array.indexOf("First"));
  }

  @Test
  public void contains() {
    ArrayJLists<String> array = new ArrayJLists<>();
    array.add("First");
    assertTrue(array.contains("First"));
  }

  @Test
  public void get() {
    ArrayJLists<String> array = new ArrayJLists<>();
    array.add("First");
    array.add("Second");
    assertEquals("First", array.get(0));
    assertEquals("Second", array.get(1));
  }

  @Test
  public void remove() {
    ArrayJLists<String> array = new ArrayJLists<>();
    array.add("First");
    array.add("Second");
    array.add("Third");
    assertEquals("Second", array.get(1));
    array.remove(1);
    assertEquals("Third", array.get(1));
  }

  @Test
  public void clear() {
    ArrayJLists<String> array = new ArrayJLists<>();
    array.add("First");
    array.add("Second");
    array.add("Third");
    array.clear();
    assertTrue(array.isEmpty());
  }
}