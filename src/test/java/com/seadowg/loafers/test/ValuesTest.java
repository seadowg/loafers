package com.seadowg.loafers.test;

import com.seadowg.loafers.collection.Values;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class ValuesTest {

  @Test
  public void constructor_isGeneric() {
    Values<String> stringValues = new Values("Hello", "Values");
    Values<Integer> integerValues = new Values(1, 2, 3);
    Values<Values<String>> listValues = new Values(Arrays.asList("Hello"));

    assertTrue(true);
  }

  @Test
  public void chooseOne_picksARandomElement() {
    java.util.List<String> choices = Arrays.asList("One", "Two", "Three");
    Values<String> values = new Values("One", "Two", "Three");

    for (int i = 0; i < 5; i++) {
      assertTrue(choices.contains(values.chooseOne()));
    }
  }

  @Test
  public void first_getsTheFirstElement() {
    Values<String> values = new Values("One", "Two", "Three");
    assertEquals("One", values.first());
  }

  @Test
  public void last_getsTheLastElement() {
    Values<String> values = new Values("One", "Two", "Three");
    assertEquals("Three", values.last());
  }

  @Test
  public void get_getsTheElementAtTheSpecifiedIndex() {
    Values<String> values = new Values("One", "Two", "Three");
    assertEquals("One", values.get(0));
    assertEquals("Two", values.get(1));
    assertEquals("Three", values.get(2));
  }

  @Test
  public void length_returnsTheLengthOfTheList() {
    Values<String> threeValues = new Values("One", "Two", "Three");
    assertEquals(3, threeValues.length());

    Values<String> oneValues = new Values("One");
    assertEquals(1, oneValues.length());
  }

  @Test
  public void add_returnsANewListWithTheContentsOfBoth() {
    Values<String> originalValues = new Values("One", "Two");
    Values<String> appendValues = new Values("Three");
    Values<String> combinedValues = originalValues.add(appendValues);

    assertTrue(combinedValues != originalValues);
    assertTrue(combinedValues != appendValues);

    assertEquals(3, combinedValues.length());
    assertEquals("One", combinedValues.get(0));
    assertEquals("Two", combinedValues.get(1));
    assertEquals("Three", combinedValues.get(2));
  }

  @Test
  public void equals_comparesElementEqualityInOrder() {
    Values<String> oneTwoValuesOne = new Values("One", "Two");
    Values<String> oneTwoValuesTwo = new Values("One", "Two");

    assertTrue(oneTwoValuesOne.equals(oneTwoValuesTwo));

    Values<String> twoOneValues = new Values("Two", "One");
    assertFalse(oneTwoValuesOne.equals(twoOneValues));
  }

  @Test
  public void equals_isFalseForListWithDifferentLength() {
    Values<String> oneValues = new Values("One", "Two");
    Values<String> twoValues = new Values("One");

    assertFalse(oneValues.equals(twoValues));
  }

  @Test
  public void equals_isFalseForOtherTypes() {
    assertFalse(new Values("One").equals("Two"));
  }
}
