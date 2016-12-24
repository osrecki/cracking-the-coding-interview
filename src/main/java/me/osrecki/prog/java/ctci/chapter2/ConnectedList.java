package me.osrecki.prog.java.ctci.chapter2;

import java.util.*;

/**
 * Author:  Dinko Osrecki
 * Date:    23/12/2016
 */
public class ConnectedList<E> implements Iterable<E>, Cloneable {
  private Node<E> master = new Node<>(null, null);
  private int size;

  static class Node<E> {
    E element;
    Node<E> next;

    Node(E element, Node<E> next) {
      this.element = element;
      this.next = next;
    }
  }

  private ConnectedList() {
    master.next = master;
  }

  @SafeVarargs
  ConnectedList(E... elements) {
    this(Arrays.asList(elements));
  }

  private ConnectedList(Collection<? extends E> collection) {
    this();
    addAll(collection);
  }

  Node<E> head() {
    return master.next;
  }

  private Node<E> tail() {
    return (size < 1) ? head() : node(size - 1);
  }

  Node<E> node(int index) {
    if(index < 0 || index >= size)
      throw new IndexOutOfBoundsException("Index: "+ index +", Size: "+ size +".");

    Node<E> current = master;
    for(int i = 0; i <= index; i++)
      current = current.next;

    return current;
  }

  private boolean addAll(Collection<? extends E> collection) {
    return addAll(size, collection);
  }

  @SuppressWarnings("unchecked")
  private boolean addAll(int index, Collection<? extends E> collection) {
    if(index < 0 || index > size)
      throw new IndexOutOfBoundsException("Index: "+ index +", Size: "+ size +".");

    Object[] array = collection.toArray();
    if(array.length == 0) return false;

    Node<E> successor = (index == size) ? null : node(index);
    Node<E> predecessor = (index == 0) ? master : node(index - 1);
    for(Object object : array) {
      Node<E> node = new Node<>((E) object, successor);
      predecessor.next = node;
      predecessor = node;
    }

    size += array.length;
    return true;
  }

  private Node<E> addLast(E element) {
    Node<E> newNode = new Node<>(element, null);

    Node<E> last = tail();
    last.next = newNode;

    size++;

    return newNode;
  }

  @Override
  public Iterator<E> iterator() {
    return new ConnectedListIterator();
  }

  private class ConnectedListIterator implements Iterator<E> {
    private int nextIndex;
    private ConnectedList.Node<E> cursor;

    ConnectedListIterator() {
      nextIndex = 0;
      cursor = head();
    }

    @Override
    public boolean hasNext() {
      return nextIndex < size;
    }

    @Override
    public E next() {
      if(!hasNext())
        throw new NoSuchElementException();

      ConnectedList.Node<E> current = cursor;

      cursor = cursor.next;
      nextIndex++;

      return current.element;
    }
  }

  @Override
  public boolean equals(Object o) {
    if(o == this)
      return true;

    if(!(o instanceof ConnectedList))
      return false;

    Iterator<E> it1 = iterator();
    Iterator it2 = ((ConnectedList) o).iterator();
    while(it1.hasNext() && it2.hasNext()) {
      E element1 = it1.next();
      Object element2 = it2.next();
      if(!(element1 == null ? element2 == null : element1.equals(element2)))
        return false;
    }

    return !(it1.hasNext() || it2.hasNext());
  }

  @SuppressWarnings("unchecked")
  @Override
  public Object clone() {
    ConnectedList<E> clone;

    try {
      clone = (ConnectedList<E>) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new InternalError();
    }

    clone.master = new Node<>(null, null);
    clone.master.next = clone.master;
    clone.size = 0;

    for(Node<E> current = master.next; current != null; current = current.next) {
      clone.addLast(current.element);
    }

    return clone;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    Iterator<E> it = iterator();
    while(it.hasNext()) {
      sb.append(it.next());

      if(it.hasNext())
        sb.append(", ");
    }

    return sb.toString();
  }

  static <E> ConnectedList<E> fromNode(Node<E> head) {
    List<E> elements = new ArrayList<>();
    for(Node<E> current = head; current != null; current = current.next) {
      elements.add(current.element);
    }

    return new ConnectedList<>(elements);
  }

  public static void main(String[] args) {
    ConnectedList<Integer> list = new ConnectedList<>(1, 2, 3, 4);
    ConnectedList list2 = (ConnectedList)list.clone();

    System.out.println(list2);
  }
}
