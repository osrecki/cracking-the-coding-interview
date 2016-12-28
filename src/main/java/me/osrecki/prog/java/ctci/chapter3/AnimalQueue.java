package me.osrecki.prog.java.ctci.chapter3;

import java.util.LinkedList;

/**
 * Question:  An animal shelter, which holds only dogs and cats, operates on a
 *            strictly "first in, first out" basis. People must adopt either the
 *            "oldest" (based on arrival time) of all animals at the shelter, or
 *            they can select whether they would prefer a dog or a cat (and will
 *            receive the oldest animal of that type). They cannot select which
 *            specific animal they would like. Create the data structures to
 *            maintain this system and implement operations such as enqueue,
 *            dequeueAny, dequeueDog, and dequeueCat. You may use the built-in
 *            Linked list data structure.
 * Author:    Dinko Osrecki
 * Date:      28/12/2016
 */
public class AnimalQueue {
  private int             time = 0;
  private LinkedList<Dog> dogs = new LinkedList<>();
  private LinkedList<Cat> cats = new LinkedList<>();

  void enqueue(Animal animal) {
    animal.timestamp = time++;

    if(animal instanceof Dog)       dogs.addLast((Dog) animal);
    else if(animal instanceof Cat)  cats.addLast((Cat) animal);
  }

  Animal dequeueAny() {
    if(dogs.isEmpty())      return dequeueCats();
    else if(cats.isEmpty()) return dequeueDogs();

    Dog dog = dogs.peek();
    Cat cat = cats.peek();

    return dog.isLongerThan(cat) ? dequeueDogs() : dequeueCats();
  }

  Dog dequeueDogs() {
    return dogs.poll();
  }

  Cat dequeueCats() {
    return cats.poll();
  }

  public int size() {
    return dogs.size() + cats.size();
  }

  static class Animal {
    String name;
    int timestamp;

    Animal(String name) { this.name = name; }

    boolean isLongerThan(Animal other) {
      return timestamp < other.timestamp;
    }
  }

  static class Dog extends Animal {
    Dog(String name) { super(name); }
  }
  static class Cat extends Animal {
    Cat(String name) { super(name); }
  }
}
