package com.seadowg.loafers.widget;

import com.seadowg.loafers.app.App;

import java.util.Arrays;

public class List {
  public final java.util.List<String> strings;

  public List(String ... strings) {
    this.strings = Arrays.asList(strings);
    App.add(this);
  }
}
