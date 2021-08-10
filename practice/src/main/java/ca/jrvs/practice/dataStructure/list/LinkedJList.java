package ca.jrvs.practice.dataStructure.list;

public class LinkedJList<E> implements JList<E> {

  // head of ll
  private Node head;
  private Node tail;
  private int size;

  class Node {

    E data;
    Node next;

    Node(E e) {
      data = e;
      next = null;
    }

    public E getData() {
      return data;
    }

    public Node getNext() {
      return next;
    }
  }

  public LinkedJList() {
  }

  /**
   * Appends the specified element to the end of this list (optional operation).
   *
   * @param e element to be appended to this list
   * @return <tt>true</tt> (as specified by
   * @throws NullPointerException if the specified element is null and this list does not permit
   *                              null elements
   */
  @Override
  public boolean add(E e) {
    if (e == null) {
      throw new NullPointerException("Element is null");
    }
    Node newNode = new Node(e);
    if (head == null) {
      head = newNode;
      tail = head;
    } else {
      tail.next = newNode;
      tail = tail.next;
    }
    size++;
    return true;
  }

  /**
   * Returns an array containing all of the elements in this list in proper sequence (from first to
   * last element).
   *
   * <p>This method acts as bridge between array-based and collection-based
   * APIs.
   *
   * @return an array containing all of the elements in this list in proper sequence
   */
  @Override
  public Object[] toArray() {
    Object[] array = new Object[size];
    Node current = head;
    for (int i = 0; i < size; i++) {
      array[i] = current.data;
      current = current.next;
    }
    return array;
  }

  /**
   * The size of the ArrayList (the number of elements it contains).
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Returns <tt>true</tt> if this list contains no elements.
   *
   * @return <tt>true</tt> if this list contains no elements
   */
  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Returns the index of the first occurrence of the specified element in this list, or -1 if this
   * list does not contain the element. More formally, returns the lowest index <tt>i</tt> such
   * that
   * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
   * or -1 if there is no such index.
   *
   * @param o
   */
  @Override
  public int indexOf(Object o) {
    if (size == 0) {
      return -1;
    }
    Node current = head;
    int index = 0;
    while (current != null) {
      if (current.data.equals(o)) {
        return index;
      }
      index++;
      current = current.next;
    }
    return -1;
  }

  /**
   * Returns <tt>true</tt> if this list contains the specified element. More formally, returns
   * <tt>true</tt> if and only if this list contains at least one element <tt>e</tt> such that
   * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
   *
   * @param o element whose presence in this list is to be tested
   * @return <tt>true</tt> if this list contains the specified element
   * @throws NullPointerException if the specified element is null and this list does not permit
   *                              null elements
   */
  @Override
  public boolean contains(Object o) {
    return indexOf(o) >= 0;
  }

  /**
   * Returns the element at the specified position in this list.
   *
   * @param index index of the element to return
   * @return the element at the specified position in this list
   * @throws IndexOutOfBoundsException if the index is out of range (<tt>index &lt; 0 || index &gt;=
   *                                   size()</tt>)
   */
  @Override
  public E get(int index) {
    Node node = head;
    for (int i = 0; i < index; i++) {
      node = node.next;
    }
    return (E) node.data;
  }

  /**
   * Removes the element at the specified position in this list. Shifts any subsequent elements to
   * the left (subtracts one from their indices).
   *
   * @param index the index of the element to be removed
   * @return the element that was removed from the list
   * @throws IndexOutOfBoundsException {@inheritDoc}
   */
  @Override
  public E remove(int index) {
    if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }
    if (index == 0) {
      Node temp = head;
      head = head.next;
      return temp.data;
    } else {
      Node current = head;
      Node prev = head;
      for (int i = 0; i < index; i++) {
        prev = current;
        current = current.next;
      }
      prev.next = current.next;
      size--;
      return (E) current.data;
    }
  }

  /**
   * Removes all of the elements from this list (optional operation). The list will be empty after
   * this call returns.
   */
  @Override
  public void clear() {
    size = 0;
    head = null;
  }
}
