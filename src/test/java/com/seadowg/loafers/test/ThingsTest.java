package com.seadowg.loafers.test;

import com.seadowg.loafers.collection.Things;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.*;

public class ThingsTest {

  @Test
  public void constructor_isGeneric() {
    Things<String> stringThings = new Things("Hello", "Things");
    Things<Integer> integerThings = new Things(1, 2, 3);
    Things<Things<String>> listThings = new Things(Arrays.asList("Hello"));

    assertTrue(true);
  }

  @Test
  public void chooseOne_picksARandomElement() {
    java.util.List<String> choices = Arrays.asList("One", "Two", "Three");
    Things<String> things = new Things("One", "Two", "Three");

    for (int i = 0; i < 5; i++) {
      assertTrue(choices.contains(things.chooseOne()));
    }
  }

  @Test
  public void first_getsTheFirstElement() {
    Things<String> things = new Things("One", "Two", "Three");
    assertEquals("One", things.first());
  }

  @Test
  public void last_getsTheLastElement() {
    Things<String> things = new Things("One", "Two", "Three");
    assertEquals("Three", things.last());
  }

  @Test
  public void get_getsTheElementAtTheSpecifiedIndex() {
    Things<String> things = new Things("One", "Two", "Three");
    assertEquals("One", things.get(0));
    assertEquals("Two", things.get(1));
    assertEquals("Three", things.get(2));
  }

  @Test
  public void length_returnsTheLengthOfTheList() {
    Things<String> threeThings = new Things("One", "Two", "Three");
    assertEquals(3, threeThings.length());

    Things<String> oneThings = new Things("One");
    assertEquals(1, oneThings.length());
  }

  @Test
  public void add_returnsANewListWithTheContentsOfBoth() {
    Things<String> originalThings = new Things("One", "Two");
    Things<String> appendThings = new Things("Three");
    Things<String> combinedThings = originalThings.add(appendThings);

    assertTrue(combinedThings != originalThings);
    assertTrue(combinedThings != appendThings);

    assertEquals(3, combinedThings.length());
    assertEquals("One", combinedThings.get(0));
    assertEquals("Two", combinedThings.get(1));
    assertEquals("Three", combinedThings.get(2));
  }

  @Test
  public void equals_comparesElementEqualityInOrder() {
    Things<String> oneTwoThingsOne = new Things("One", "Two");
    Things<String> oneTwoThingsTwo = new Things("One", "Two");

    assertTrue(oneTwoThingsOne.equals(oneTwoThingsTwo));

    Things<String> twoOneThings = new Things("Two", "One");
    assertFalse(oneTwoThingsOne.equals(twoOneThings));
  }

  @Test
  public void equals_isFalseForListWithDifferentLength() {
    Things<String> oneThings = new Things("One", "Two");
    Things<String> twoThings = new Things("One");

    assertFalse(oneThings.equals(twoThings));
  }

  @Test
  public void equals_isFalseForOtherTypes() {
    assertFalse(new Things("One").equals("Two"));
  }
}
