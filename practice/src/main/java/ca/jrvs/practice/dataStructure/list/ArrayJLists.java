package ca.jrvs.practice.dataStructure.list;

import java.util.Arrays;

public class ArrayJLists<E> implements JList<E> {

  /**
   * Default initial capacity.
   */
  private static final int DEFAULT_CAPACITY = 10;

  /**
   * The array buffer into which the elements of the ArrayList are stored. The capacity of the
   * ArrayList is the length of this array buffer.
   */
  transient Object[] elementData; // non-private to simplify nested class access
  /**
   * The size of the ArrayList (the number of elements it contains).
   */
  private int size;

  /**
   * Constructs an empty list with the specified initial capacity.
   *
   * @param initialCapacity the initial capacity of the list
   * @throws IllegalArgumentException if the specified initial capacity is negative
   */
  public ArrayJLists(int initialCapacity) {
    if (initialCapacity > 0) {
      this.elementData = new Object[initialCapacity];
    } else {
      throw new IllegalArgumentException("Illegal Capacity: " +
          initialCapacity);
    }
  }

  /**
   * Constructs an empty list with an initial capacity of ten.
   */
  public ArrayJLists() {
    this(DEFAULT_CAPACITY);
    size = 0;
  }


  /**
   * Appends the specified element to the end of this list (optional operation).
   * <p>
   * Double elementData size if elementData is full.
   */
  @Override
  public boolean add(E e) {
    if (e == null) {
      throw new NullPointerException(("Value cannot be null"));
    }
    if (elementData.length == size) {
      int newCapacity = size * 2;
      elementData = Arrays.copyOf(elementData, newCapacity);
    }
    elementData[size] = e;
    size++;
    return true;
  }

  @Override
  public Object[] toArray() {
    // copy instead of original
    return Arrays.copyOf(elementData, size);
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public int indexOf(Object o) {
    for (int i = 0; i < size; i++) {
      if (elementData[i].equals(o)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public boolean contains(Object o) {
    if (o == null) {
      throw new NullPointerException("Object cannot be null");
    }
    return indexOf(o) >= 0;
  }

  @Override
  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }
    return (E) elementData[index];
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
    if (index <= 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }
    E removed = (E) elementData[index];
    for (int i = index; i < size - 1; i++) {
      elementData[i] = elementData[i+1];
    }
    size--;
    elementData[size] = null;

    return removed;
  }

  @Override
  public void clear() {
    for (int i = 0; i < size ; i++) {
      elementData[i] = null;
    }
    size = 0;
  }
}