package me.osrecki.prog.java.ctci.chapter3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
public class AnimalQueueTest {
  @Test
  public void shouldEnqueueAndDequeueAnimals() {
    AnimalQueue animalQueue = new AnimalQueue();

    List<AnimalQueue.Animal> animals = Arrays.asList(
      new AnimalQueue.Dog("Snoopy"),
      new AnimalQueue.Cat("Snarky"),
      new AnimalQueue.Dog("Max"),
      new AnimalQueue.Cat("Charlie")
    );

    for(AnimalQueue.Animal animal : animals)
      animalQueue.enqueue(animal);

    AnimalQueue.Animal animal = animalQueue.dequeueAny();
    Assert.assertEquals("DequeueAny should give Snoopy.", animal.name, "Snoopy");

    animal = animalQueue.dequeueCats();
    Assert.assertEquals("DequeueCats should give Snarky.", animal.name, "Snarky");

    animal = animalQueue.dequeueDogs();
    Assert.assertEquals("DequeueDogs should give Max.", animal.name, "Max");

    animal = animalQueue.dequeueAny();
    Assert.assertEquals("DequeueAny should give Charlie.", animal.name, "Charlie");
  }

  @Test
  public void shouldReturnNullOnEmptyQueue() {
    AnimalQueue animalQueue = new AnimalQueue();
    AnimalQueue.Animal animal = animalQueue.dequeueAny();

    Assert.assertNull("Animal should be null.", animal);
  }
}
