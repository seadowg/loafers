package com.example.activity;

import roboshoes.*;

public class MyApp extends App {
  public void open() {
    title = "Magic 8-Ball";

    new Input();
    new Button("Ask") {
      public void click() {
        String answer = new List("Yes", "No", "Maybe").chooseOne();
        new Popup(answer).show();
      }
    };
  }
}
