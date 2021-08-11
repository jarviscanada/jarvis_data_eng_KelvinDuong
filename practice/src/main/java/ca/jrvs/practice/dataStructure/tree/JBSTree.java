package ca.jrvs.practice.dataStructure.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * A simplified BST implementation
 *
 * @param <E> type of object to be stored
 */
public class JBSTree<E> implements JTree<E> {

  /**
   * The comparator used to maintain order in this tree map Comparator cannot be null
   */
  private Comparator<E> comparator;

  public Node<E> getRoot() {
    return root;
  }

  private Node<E> root;

  /**
   * Create a new BST
   *
   * @param comparator the comparator that will be used to order this map.
   * @throws IllegalArgumentException if comparator is null
   */
  public JBSTree(Comparator<E> comparator) {
    this.comparator = comparator;
  }

  /**
   * Insert an object into the BST. Please review the BST property.
   *
   * @param object item to be inserted
   * @return inserted item
   * @throws IllegalArgumentException if the object already exists
   */
  @Override
  public E insert(E object) {
    if (root == null) {
      Node<E> newRoot = new Node(object, null);
      root = newRoot;
    } else {
      Node<E> current = root;
      while (current != null) {
        int value = comparator.compare(current.getValue(), object);
        // object already exists
        if (value == 0) {
          throw new IllegalArgumentException("Object already exists");
          // current nodes value greater than object
        } else if (value > 0) {
          if (current.left == null) {
            Node<E> newNode = new Node(object, current);
            current.left = newNode;
            return object;
          } else {
            current = current.left;
          }
          // current nodes value less than object
        } else {
          if (current.right == null) {
            Node<E> newNode = new Node(object, current);
            current.right = newNode;
            return object;
          } else {
            current = current.right;
          }
        }
      }
    }
    return object;
  }

  /**
   * Search and return an object, return null if not found
   *
   * @param object to be found
   * @return the object if exists or null if not
   */
  @Override
  public E search(E object) {
    if (root == null) {
      return null;
    } else {
      Node<E> current = root;
      while (current != null) {
        int value = comparator.compare(current.getValue(), object);
        // object found
        if (value == 0) {
          return object;
          // current nodes value greater than object
        } else if (value > 0) {
          current = current.left;
          // current nodes value less than object
        } else {
          current = current.right;
        }
      }
    }
    return null;
  }

  /**
   * Remove an object from the tree.
   *
   * @param object to be removed
   * @return removed object
   * @throws IllegalArgumentException if the object not exists
   */
  @Override
  public E remove(E object) {
    if (root == null || search(object) == null) {
      throw new IllegalArgumentException("Object does not exist in tree");
    }
    Node<E> current = root;
    while (current != null) {
      int value = comparator.compare(current.getValue(), object);
      // object found
      if (value == 0) {
        if (current.left == null && current.right == null) {
          // if its a left child of the parent
          if (current.parent.left.getValue() == current.getValue()) {
            current.parent.left = null;
            return object;
            // if its a right child of the parent
          } else {
            current.parent.right = null;
            return object;
          }
        } else if (current.right == null) {
          Node<E> successor = successor(current);
          if (current.parent.left.getValue() == current.getValue()) {
            current.parent.left = successor;
            remove(successor.getValue());
            return object;
          } else {
            current.parent.right = successor;
            remove(successor.getValue());
            return object;
          }
        } else {
          Node<E> successor = successor(current.getRight());
          if (current.parent.left.getValue() == current.getValue()) {
            current.parent.left = successor;
            remove(successor.getValue());
            return object;
          } else {
            current.parent.right = successor;
            remove(successor.getValue());
            return object;
          }
        }
      } else if (value > 0) {
        current = current.left;
      } else {
        current = current.right;
      }
    }
    return null;
  }

  /**
   * Finds the successor of a given node
   * @param root
   * @return successor
   */
  public Node<E> successor(Node<E> root) {
    Node<E> current = root;
    while (current.left != null) {
      current = current.left;
    }
    return current;
  }

  /**
   * traverse the tree recursively
   *
   * @return all objects in pre-order
   */
  @Override
  public E[] preOrder() {
    List<E> list = new ArrayList<>();
    preOrderHelper(root, list);
    return (E[]) list.toArray();
  }

  public void preOrderHelper(Node<E> root, List<E> list) {
    if (root != null) {
      list.add(root.getValue());
      preOrderHelper(root.left, list);
      preOrderHelper(root.right, list);
    }
  }

  /**
   * traverse the tree recursively
   *
   * @return all objects in-order
   */
  @Override
  public E[] inOrder() {
    List<E> list = new ArrayList<>();
    inOrderHelper(root, list);
    return (E[]) list.toArray();
  }

  public void inOrderHelper(Node<E> root, List<E> list) {
    if (root != null) {
      inOrderHelper(root.left, list);
      list.add(root.getValue());
      inOrderHelper(root.right, list);
    }
  }

  /**
   * traverse the tree recursively
   *
   * @return all objects pre-order
   */
  @Override
  public E[] postOrder() {
    List<E> list = new ArrayList<>();
    postOrderHelper(root, list);
    return (E[]) list.toArray();
  }

  public void postOrderHelper(Node<E> root, List<E> list) {
    if (root != null) {
      postOrderHelper(root.left, list);
      postOrderHelper(root.right, list);
      list.add(root.getValue());
    }
  }

  /**
   * traverse through the tree and find out the tree height
   *
   * @return height
   * @throws NullPointerException if the BST is empty
   */
  @Override
  public int findHeight() {
    return findHeightHelper(root);
  }

  public int findHeightHelper(Node<E> root) {
    if (root == null) {
      return 0;
    }
    return Math.max(1 + findHeightHelper(root.left), 1 + findHeightHelper(root.right));
  }

  static final class Node<E> {

    E value;
    Node<E> left;
    Node<E> right;
    Node<E> parent;

    public Node(E value, Node<E> parent) {
      this.value = value;
      this.parent = parent;
    }

    public E getValue() {
      return value;
    }

    public void setValue(E value) {
      this.value = value;
    }

    public Node<E> getLeft() {
      return left;
    }

    public void setLeft(Node<E> left) {
      this.left = left;
    }

    public Node<E> getRight() {
      return right;
    }

    public void setRight(Node<E> right) {
      this.right = right;
    }

    public Node<E> getParent() {
      return parent;
    }

    public void setParent(Node<E> parent) {
      this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Node)) {
        return false;
      }
      Node<?> node = (Node<?>) o;
      return getValue().equals(node.getValue()) &&
          Objects.equals(getLeft(), node.getLeft()) &&
          Objects.equals(getRight(), node.getRight()) &&
          getParent().equals(node.getParent());
    }

    @Override
    public int hashCode() {
      return Objects.hash(getValue(), getLeft(), getRight(), getParent());
    }
  }

}