package com.seadowg.loafers.test;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.seadowg.loafers.app.App;
import com.seadowg.loafers.test.helper.Helper;
import com.seadowg.loafers.widget.Input;
import com.seadowg.loafers.widget.Text;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class) @Config(manifest=Config.NONE)
public class TextTest {

  @Test
  public void setText_setsTheViewsText() {
    MyApp app = Robolectric.buildActivity(MyApp.class).create().start().resume().get();
    LinearLayout layout = Helper.fetchAppLayout(app);

    TextView view = (TextView) layout.getChildAt(0);
    app.getText().setText("Candy People explode when they get scared?");

    assertEquals("Candy People explode when they get scared?", view.getText());
  }

  @Test
  public void setText_withAnInput_keepsTheTextUpToDateWithTheInput() {
    MyApp app = Robolectric.buildActivity(MyApp.class).create().start().resume().get();
    LinearLayout layout = Helper.fetchAppLayout(app);

    TextView textView = (TextView) layout.getChildAt(0);
    EditText editText = (EditText) layout.getChildAt(1);

    app.getText().setText(app.getInput());
    assertEquals("", textView.getText());

    editText.setText("I'll slay anything that's evil");
    assertEquals("I'll slay anything that's evil", textView.getText());
  }

  private static class MyApp extends App {
    private Text text;
    private Input input;

    public void open() {
      text = new Text("");
      input = new Input();
    }

    public Text getText() {
      return text;
    }

    public Input getInput() {
      return input;
    }
  }
}
