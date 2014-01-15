package com.seadowg.loafers.test;

import org.junit.Test;
import com.seadowg.loafers.collection.List;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class ListTest {

  @Test
  public void constructor_isGeneric() {
    List<String> stringList = new List("Hello", "List");
    List<Integer> integerList = new List(1, 2, 3);
    List<List<String>> listList = new List(Arrays.asList("Hello"));

    assertTrue(true);
  }

  @Test
  public void chooseOne_picksARandomElement() {
    java.util.List<String> choices = Arrays.asList("One", "Two", "Three");
    List<String> list = new List("One", "Two", "Three");

    for (int i = 0; i < 5; i++) {
      assertTrue(choices.contains(list.chooseOne()));
    }
  }

  @Test
  public void first_getsTheFirstElement() {
    List<String> list = new List("One", "Two", "Three");
    assertEquals("One", list.first());
  }

  @Test
  public void last_getsTheLastElement() {
    List<String> list = new List("One", "Two", "Three");
    assertEquals("Three", list.last());
  }

  @Test
  public void get_getsTheElementAtTheSpecifiedIndex() {
    List<String> list = new List("One", "Two", "Three");
    assertEquals("One", list.get(0));
    assertEquals("Two", list.get(1));
    assertEquals("Three", list.get(2));
  }

  @Test
  public void length_returnsTheLengthOfTheList() {
    List<String> threeList = new List("One", "Two", "Three");
    assertEquals(new Integer(3), threeList.length());

    List<String> oneList = new List("One");
    assertEquals(new Integer(1), oneList.length());
  }
}
