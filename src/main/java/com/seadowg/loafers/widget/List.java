package com.seadowg.loafers.widget;

import com.seadowg.loafers.app.App;
import com.seadowg.loafers.collection.Stuff;

import java.util.Arrays;
import java.util.Collections;

public class List {
  public final java.util.List<String> strings;

  public List(String ... strings) {
    this.strings = Arrays.asList(strings);
    App.add(this);
  }
}
