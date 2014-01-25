package com.seadowg.loafers.collection;

import com.google.common.collect.ImmutableList;

import java.util.Collection;
import java.util.Random;

public class Stuff<T> {

  private final ImmutableList<T> values;

  public Stuff(T... values) {
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

  public Stuff<T> add(Stuff<T> appendStuff) {
    ImmutableList<T> newValues = new ImmutableList.Builder<T>()
        .addAll(toCollection())
        .addAll(appendStuff.toCollection())
        .build();

    return new Stuff<T>((T[]) newValues.toArray());
  }

  public boolean equals(Object object) {
    if (object.getClass().isAssignableFrom(this.getClass())) {
      Stuff<T> otherStuff = (Stuff<T>) object;
      return toCollection().equals(otherStuff.toCollection());
    } else {
      return false;
    }
  }
}
