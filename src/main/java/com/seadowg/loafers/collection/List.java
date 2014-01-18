package com.seadowg.loafers.collection;

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

  public List<T> add(List<T> appendList) {
    int newLength = length() + appendList.length();
    Object[] buffer = new Object[newLength];

    for (int i = 0; i < newLength; i++) {
      if (i < length()) {
        buffer[i]= get(i);
      } else {
        buffer[i] = appendList.get(i - length());
      }
    }

    return new List<T>((T[]) buffer);
  }

  public boolean equals(Object object) {
    if (object.getClass().isAssignableFrom(this.getClass())) {
      return equalsList((List<T>) object);
    } else {
      return false;
    }
  }

  private boolean equalsList(List<T> otherList) {
    if (length() == otherList.length()) {
      boolean isEqual = true;

      for (int i = 0; i < length(); i++) {
        if (!get(i).equals(otherList.get(i))) {
          isEqual = false;
        }
      }

      return isEqual;
    } else {
      return false;
    }
  }
}
