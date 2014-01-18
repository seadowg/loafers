package com.seadowg.loafers.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.seadowg.loafers.app.internal.Screen;
import com.seadowg.loafers.app.internal.view.builder.AlertDialogBuilder;
import com.seadowg.loafers.app.internal.view.builder.ButtonBuilder;
import com.seadowg.loafers.widget.Button;
import com.seadowg.loafers.widget.Input;
import com.seadowg.loafers.widget.Popup;

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

  public static void add(final Input input) {
    App.addView(new EditText(App.context));
  }

  public static void show(final Popup popup) {
    new AlertDialogBuilder(App.context, popup).build().show();
  }
}
