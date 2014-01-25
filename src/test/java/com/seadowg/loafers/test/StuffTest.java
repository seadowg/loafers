package com.seadowg.loafers.test;

import com.seadowg.loafers.collection.Stuff;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class StuffTest {

  @Test
  public void constructor_isGeneric() {
    Stuff<String> stringStuff = new Stuff("Hello", "Stuff");
    Stuff<Integer> integerStuff = new Stuff(1, 2, 3);
    Stuff<Stuff<String>> listStuff = new Stuff(Arrays.asList("Hello"));

    assertTrue(true);
  }

  @Test
  public void chooseOne_picksARandomElement() {
    java.util.List<String> choices = Arrays.asList("One", "Two", "Three");
    Stuff<String> stuff = new Stuff("One", "Two", "Three");

    for (int i = 0; i < 5; i++) {
      assertTrue(choices.contains(stuff.chooseOne()));
    }
  }

  @Test
  public void first_getsTheFirstElement() {
    Stuff<String> stuff = new Stuff("One", "Two", "Three");
    assertEquals("One", stuff.first());
  }

  @Test
  public void last_getsTheLastElement() {
    Stuff<String> stuff = new Stuff("One", "Two", "Three");
    assertEquals("Three", stuff.last());
  }

  @Test
  public void get_getsTheElementAtTheSpecifiedIndex() {
    Stuff<String> stuff = new Stuff("One", "Two", "Three");
    assertEquals("One", stuff.get(0));
    assertEquals("Two", stuff.get(1));
    assertEquals("Three", stuff.get(2));
  }

  @Test
  public void length_returnsTheLengthOfTheList() {
    Stuff<String> threeStuff = new Stuff("One", "Two", "Three");
    assertEquals(3, threeStuff.length());

    Stuff<String> oneStuff = new Stuff("One");
    assertEquals(1, oneStuff.length());
  }

  @Test
  public void add_returnsANewListWithTheContentsOfBoth() {
    Stuff<String> originalStuff = new Stuff("One", "Two");
    Stuff<String> appendStuff = new Stuff("Three");
    Stuff<String> combinedStuff = originalStuff.add(appendStuff);

    assertTrue(combinedStuff != originalStuff);
    assertTrue(combinedStuff != appendStuff);

    assertEquals(3, combinedStuff.length());
    assertEquals("One", combinedStuff.get(0));
    assertEquals("Two", combinedStuff.get(1));
    assertEquals("Three", combinedStuff.get(2));
  }

  @Test
  public void equals_comparesElementEqualityInOrder() {
    Stuff<String> oneTwoStuffOne = new Stuff("One", "Two");
    Stuff<String> oneTwoStuffTwo = new Stuff("One", "Two");

    assertTrue(oneTwoStuffOne.equals(oneTwoStuffTwo));

    Stuff<String> twoOneStuff = new Stuff("Two", "One");
    assertFalse(oneTwoStuffOne.equals(twoOneStuff));
  }

  @Test
  public void equals_isFalseForListWithDifferentLength() {
    Stuff<String> oneStuff = new Stuff("One", "Two");
    Stuff<String> twoStuff = new Stuff("One");

    assertFalse(oneStuff.equals(twoStuff));
  }

  @Test
  public void equals_isFalseForOtherTypes() {
    assertFalse(new Stuff("One").equals("Two"));
  }
}
