package com.seadowg.loafers.collection;

import java.util.Random;

public class List {
  private final String[] values;

  public List(String ... values) {
    this.values = values;
  }

  public String chooseOne() {
    int index = new Random().nextInt(values.length);
    return values[index];
  }
}
