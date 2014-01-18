package com.seadowg.loafers.test;

import com.seadowg.loafers.collection.List;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
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
    assertEquals(3, threeList.length());

    List<String> oneList = new List("One");
    assertEquals(1, oneList.length());
  }

  @Test
  public void add_returnsANewListWithTheContentsOfBoth() {
    List<String> originalList = new List("One", "Two");
    List<String> appendList = new List("Three");
    List<String> combinedList = originalList.add(appendList);

    assertTrue(combinedList != originalList);
    assertTrue(combinedList != appendList);

    assertEquals(3, combinedList.length());
    assertEquals("One", combinedList.get(0));
    assertEquals("Two", combinedList.get(1));
    assertEquals("Three", combinedList.get(2));
  }

  @Test
  public void equals_comparesElementEqualityInOrder() {
    List<String> oneTwoListOne = new List("One", "Two");
    List<String> oneTwoListTwo = new List("One", "Two");

    assertTrue(oneTwoListOne.equals(oneTwoListTwo));

    List<String> twoOneList = new List("Two", "One");
    assertFalse(oneTwoListOne.equals(twoOneList));
  }

  @Test
  public void equals_isFalseForListWithDifferentLength() {
    List<String> oneList = new List("One", "Two");
    List<String> twoList = new List("One");

    assertFalse(oneList.equals(twoList));
  }

  @Test
  public void equals_isFalseForOtherTypes() {
    assertFalse(new List("One").equals("Two"));
  }
}
