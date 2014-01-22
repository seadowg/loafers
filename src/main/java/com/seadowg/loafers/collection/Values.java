package com.seadowg.loafers.collection;

import com.google.common.collect.ImmutableList;

import java.util.Collection;
import java.util.Random;

public class Values<T> {

  private final ImmutableList<T> values;

  public Values(T... values) {
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

  public Values<T> add(Values<T> appendValues) {
    ImmutableList<T> newValues = new ImmutableList.Builder<T>()
        .addAll(toCollection())
        .addAll(appendValues.toCollection())
        .build();

    return new Values<T>((T[]) newValues.toArray());
  }

  public boolean equals(Object object) {
    if (object.getClass().isAssignableFrom(this.getClass())) {
      Values<T> otherValues = (Values<T>) object;
      return toCollection().equals(otherValues.toCollection());
    } else {
      return false;
    }
  }
}
