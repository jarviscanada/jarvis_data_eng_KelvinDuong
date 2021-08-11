package ca.jrvs.practice.dataStructure.tree;

import static org.junit.Assert.*;

import ca.jrvs.practice.dataStructure.tree.JBSTree.Node;
import org.junit.Test;

public class JBSTreeTest {

  @Test
  public void insert() {
    JBSTree<Integer> tree = new JBSTree<>(Integer::compareTo);
    tree.insert(10);
    tree.insert(15);
    tree.insert(5);
    Node root =  tree.getRoot();
    assertEquals(10, root.getValue());
  }

  @Test
  public void search() {
    JBSTree<Integer> tree = new JBSTree<>(Integer::compareTo);
    tree.insert(10);
    tree.insert(15);
    tree.insert(5);
    Node root =  tree.getRoot();
    int search1 = tree.search(10);
    int search2 = tree.search(15);
    int search3 = tree.search(5);
    assertEquals(10, search1);
    assertEquals(15, search2);
    assertEquals(5, search3);
  }

  @Test
  public void remove() {
    JBSTree<Integer> tree = new JBSTree<>(Integer::compareTo);
    tree.insert(10);
    tree.insert(15);
    tree.insert(5);
    tree.insert(3);
    tree.remove(5);
    assertEquals(null, tree.search(5));
    tree.remove(15);
    assertEquals(null, tree.search(15));
  }

  @Test
  public void preOrder() {
    JBSTree<Integer> tree = new JBSTree<>(Integer::compareTo);
    tree.insert(10);
    tree.insert(15);
    tree.insert(5);
    tree.insert(3);
    Object[] array = tree.preOrder();
    assertEquals(10, array[0]);
    assertEquals(5, array[1]);
    assertEquals(3, array[2]);
    assertEquals(15, array[3]);
  }

  @Test
  public void inOrder() {
    JBSTree<Integer> tree = new JBSTree<>(Integer::compareTo);
    tree.insert(10);
    tree.insert(15);
    tree.insert(5);
    tree.insert(3);
    Object[] array = tree.inOrder();
    assertEquals(3, array[0]);
    assertEquals(5, array[1]);
    assertEquals(10, array[2]);
    assertEquals(15, array[3]);
  }

  @Test
  public void postOrder() {
    JBSTree<Integer> tree = new JBSTree<>(Integer::compareTo);
    tree.insert(10);
    tree.insert(15);
    tree.insert(5);
    tree.insert(7);
    tree.insert(3);
    Object[] array = tree.postOrder();
    assertEquals(3, array[0]);
    assertEquals(7, array[1]);
    assertEquals(5, array[2]);
    assertEquals(15, array[3]);
    assertEquals(10, array[4]);
  }

  @Test
  public void findHeight() {
    JBSTree<Integer> tree = new JBSTree<>(Integer::compareTo);
    tree.insert(10);
    assertEquals(1, tree.findHeight());
    tree.insert(15);
    assertEquals(2, tree.findHeight());
    tree.insert(5);
    tree.insert(7);
    tree.insert(3);
    assertEquals(3, tree.findHeight());
  }
}