package com.seadowg.loafers.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.seadowg.loafers.app.internal.Screen;
import com.seadowg.loafers.app.internal.view.builder.AlertDialogBuilder;
import com.seadowg.loafers.app.internal.view.builder.ButtonBuilder;
import com.seadowg.loafers.widget.Button;
import com.seadowg.loafers.widget.Input;
import com.seadowg.loafers.widget.Popup;
import com.seadowg.loafers.widget.Text;

public abstract class App extends Activity {
  private static App context;
  private static Screen screen;

  public abstract void open();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    App.context = this;

    screen = new Screen();
    screen.attach(this);
    open();
  }

  private static void addView(View view) {
    screen.addView(view);
  }

  public static void add(final Button button) {
    App.addView(new ButtonBuilder(App.context, button).build());
  }

  public static EditText add(final Input input) {
    EditText view = new EditText(App.context);
    App.addView(view);

    return view;
  }

  public static TextView add(Text text) {
    TextView view = new TextView(App.context);
    view.setText(text.text);
    App.addView(view);

    return view;
  }

  public static void show(final Popup popup) {
    new AlertDialogBuilder(App.context, popup).build().show();
  }
}
