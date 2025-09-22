package org.example;

import java.util.*;

public class TodoList {

  private static class Task {
    final String text;      
    boolean done;

    Task(String text) {
      this.text = text;
      this.done = false;
    }
  }

  private final LinkedHashMap<String, Task> tasks = new LinkedHashMap<>();

  private static String norm(String s) {
    return s == null ? null : s.trim().toLowerCase(Locale.ROOT);
  }

  public boolean add(String description) {
    if (description == null) return false;
    String trimmed = description.trim();
    if (trimmed.isEmpty()) return false;

    String key = norm(trimmed);
    if (tasks.containsKey(key)) return false; // duplicate (case-insensitive)

    tasks.put(key, new Task(trimmed));
    return true;
  }

  public boolean complete(String description) {
    if (description == null) return false;
    Task t = tasks.get(norm(description));
    if (t == null) return false;
    t.done = true;
    return true;
  }

  public List<String> all() {
    List<Task> list = new ArrayList<>(tasks.values());
    return printTasks(list, "Your to-do list is empty.");
  }

  public List<String> complete() {
    List<Task> list = new ArrayList<>();
    for (Task t : tasks.values()) if (t.done) list.add(t);
    return printTasks(list, "No completed tasks.");
  }

  public List<String> incomplete() {
    List<Task> list = new ArrayList<>();
    for (Task t : tasks.values()) if (!t.done) list.add(t);
    return printTasks(list, "No incomplete tasks.");
  }

  public void clear() {
    tasks.clear();
  }

  private static List<String> printTasks(List<Task> items, String emptyMsg) {
    List<String> lines = new ArrayList<>();
    if (items.isEmpty()) {
      lines.add(emptyMsg);
    } else {
      int i = 1;
      for (Task t : items) {
        String line = String.format("%d. [%s] %s", i++, t.done ? "x" : " ", t.text);
        lines.add(line);
      }
    }

    for (String line : lines) System.out.println(line);
    return lines;
  }
}
