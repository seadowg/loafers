package com.seadowg.loafers.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class List<T> {

  private final java.util.List<T> values;

  public List(T ... values) {
    this.values = Arrays.asList(values);
  }

  public T chooseOne() {
    int index = new Random().nextInt(values.size());
    return values.get(index);
  }

  public T first() {
    return values.get(0);
  }

  public T last() {
    return values.get(values.size() - 1);
  }

  public T get(int index) {
    return values.get(index);
  }

  public int length() {
    return values.size();
  }

  public java.util.List<T> toJavaList() {
    return new ArrayList<T>(values);
  }

  public List<T> add(List<T> appendList) {
    java.util.List<T> javaList = toJavaList();
    javaList.addAll(appendList.toJavaList());

    return new List((T[]) javaList.toArray());
  }

  public boolean equals(Object object) {
    if (object.getClass().isAssignableFrom(this.getClass())) {
      List<T> otherList = (List<T>) object;
      return toJavaList().equals(otherList.toJavaList());
    } else {
      return false;
    }
  }
}
