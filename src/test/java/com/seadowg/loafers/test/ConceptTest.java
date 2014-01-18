package com.seadowg.loafers.test;

import android.app.Activity;
import android.app.AlertDialog;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.seadowg.loafers.app.App;
import com.seadowg.loafers.collection.List;
import com.seadowg.loafers.test.helper.Helper;
import com.seadowg.loafers.widget.Button;
import com.seadowg.loafers.widget.Input;
import com.seadowg.loafers.widget.Popup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowAlertDialog;
import org.robolectric.shadows.ShadowDialog;

import java.util.Arrays;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.robolectric.Robolectric.shadowOf;

@RunWith(RobolectricTestRunner.class) @Config(manifest=Config.NONE)
public class ConceptTest {
  @Test
  public void buildingAMagic8Ball_works() throws Exception {
    Activity app = Robolectric.buildActivity(MyApp.class).create().start().resume().get();

    LinearLayout layout = Helper.fetchAppLayout(app);
    android.widget.EditText editText = (EditText) layout.getChildAt(0);
    android.widget.Button button = (android.widget.Button) layout.getChildAt(1);

    assertEquals(app.getTitle(), "Magic 8-Ball");
    assertEquals("", editText.getText().toString());
    assertEquals("Shake", button.getText());

    button.performClick();
    ShadowAlertDialog popup = (shadowOf((AlertDialog) ShadowDialog.getLatestDialog()));
    assertTrue(Arrays.asList("Yes!", "No!", "Maybe?").contains(popup.getTitle()));
  }

  private static class MyApp extends App {
    public void open() {
      setTitle("Magic 8-Ball");

      new Input();
      new Button("Shake") {
        public void click() {
          String answer = new List<String>("Yes!", "No!", "Maybe?").chooseOne();
          new Popup(answer).show();
        }
      };
    }
  }
}