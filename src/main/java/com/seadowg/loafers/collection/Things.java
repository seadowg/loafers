package com.seadowg.loafers.collection;

import com.google.common.collect.ImmutableList;

import java.util.Collection;
import java.util.Random;

public class Things<T> {

  private final ImmutableList<T> values;

  public Things(T... values) {
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

  public Things<T> add(Things<T> appendThings) {
    ImmutableList<T> newValues = new ImmutableList.Builder<T>()
        .addAll(toCollection())
        .addAll(appendThings.toCollection())
        .build();

    return new Things<T>((T[]) newValues.toArray());
  }

  public boolean equals(Object object) {
    if (object.getClass().isAssignableFrom(this.getClass())) {
      Things<T> otherThings = (Things<T>) object;
      return toCollection().equals(otherThings.toCollection());
    } else {
      return false;
    }
  }
}
