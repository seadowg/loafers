package com.seadowg.loafers.collection;

import com.google.common.collect.ImmutableList;

import java.util.Collection;
import java.util.Random;

public class List<T> {

  private final ImmutableList<T> values;

  public List(T ... values) {
    this.values = ImmutableList.copyOf(values);
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

  public Collection<T> toCollection() {
    return values;
  }

  public List<T> add(List<T> appendList) {
    ImmutableList<T> newValues = new ImmutableList.Builder<T>()
        .addAll(toCollection())
        .addAll(appendList.toCollection())
        .build();

    return new List<T>((T[]) newValues.toArray());
  }

  public boolean equals(Object object) {
    if (object.getClass().isAssignableFrom(this.getClass())) {
      List<T> otherList = (List<T>) object;
      return toCollection().equals(otherList.toCollection());
    } else {
      return false;
    }
  }
}
