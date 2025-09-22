package org.example;

public class App {
  public static void main(String[] args) {
    TodoList list = new TodoList();

    list.add("Buy milk");
    list.add("Buy eggs");
    list.add("Prepare a lesson for CSC 122");
    list.add("Sow beet seeds");

    list.complete("Buy eggs");

    list.all();

    list.complete();

    list.incomplete();

    list.clear();

    list.all();
  }
}
