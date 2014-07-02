package com.seadowg.loafers.test;

import android.widget.EditText;
import android.widget.LinearLayout;
import com.seadowg.loafers.app.App;
import com.seadowg.loafers.test.helper.Helper;
import com.seadowg.loafers.widget.Input;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class) @Config(manifest=Config.NONE)
public class InputTest {

  @Test
  public void getText_returnsTheViewsText() {
    TestApp app = Robolectric.setupActivity(TestApp.class);
    LinearLayout layout = Helper.fetchAppLayout(app);

    EditText editText = (EditText) layout.getChildAt(0);
    editText.setText("I have grown quite weary");

    assertEquals("I have grown quite weary", app.getInput().getText());
  }

  private static class TestApp extends App {
    private Input input;

    public void open() {
      input = new Input();
    }

    public Input getInput() {
      return input;
    }
  }
}
