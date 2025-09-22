package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

  @Test
  void addAndListAll() {
    TodoList list = new TodoList();
    assertTrue(list.add("Buy milk"));
    assertTrue(list.add("Buy eggs"));
    List<String> all = list.all();
    assertEquals(2, all.stream().filter(s -> s.contains("Buy")).count());
  }

  @Test
  void duplicateAndInvalidAddsAreRejected() {
    TodoList list = new TodoList();
    assertTrue(list.add("Buy Milk"));
    assertFalse(list.add("buy milk")); // duplicate (case-insensitive)
    assertFalse(list.add(null));
    assertFalse(list.add("   "));
    List<String> all = list.all();
    assertEquals(1, all.size()); // one printed line for the single task
    assertTrue(all.get(0).contains("Buy Milk"));
  }

  @Test
  void completeByDescription() {
    TodoList list = new TodoList();
    list.add("Buy eggs");
    list.add("Buy milk");
    assertTrue(list.complete("buy EGGS")); // case-insensitive completion
    List<String> done = list.complete();
    assertEquals(1, done.size());
    assertTrue(done.get(0).contains("Buy eggs"));
    List<String> todo = list.incomplete();
    assertEquals(1, todo.size());
    assertTrue(todo.get(0).contains("Buy milk"));
  }

  @Test
  void completeNonexistentReturnsFalse() {
    TodoList list = new TodoList();
    list.add("A");
    assertFalse(list.complete("B"));
    // nothing in completed list
    assertEquals(1, list.incomplete().size());
    assertTrue(list.complete().get(0).contains("No completed tasks."));
  }

  @Test
  void clearEmptiesEverything() {
    TodoList list = new TodoList();
    list.add("X");
    list.add("Y");
    list.clear();
    List<String> all = list.all();
    assertEquals(1, all.size());
    assertEquals("Your to-do list is empty.", all.get(0));
  }
}
