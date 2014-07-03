package com.seadowg.loafers.test;

import com.seadowg.loafers.app.App;
import com.seadowg.loafers.widget.Button;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class ButtonTest {
  @Test
  public void overridingPressIsOptional() {
    Robolectric.setupActivity(NoActionButtonActivity.class);
  }

  private static class NoActionButtonActivity extends App {
    public void open() {
      new Button("Hello");
    }
  }
}
