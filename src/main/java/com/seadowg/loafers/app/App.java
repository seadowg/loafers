package com.seadowg.loafers.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.seadowg.loafers.app.internal.Screen;
import com.seadowg.loafers.app.internal.view.builder.AlertDialogBuilder;
import com.seadowg.loafers.app.internal.view.builder.ButtonBuilder;
import com.seadowg.loafers.app.internal.view.builder.ListViewBuilder;
import com.seadowg.loafers.widget.*;

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

    setTitle("Loafers App");
    open();
  }

  public static void add(final Button button) {
    App.screen.addView(new ButtonBuilder(App.context, button).build());
  }

  public static EditText add(final Input input) {
    EditText view = new EditText(App.context);
    App.screen.addView(view);

    return view;
  }

  public static TextView add(Text text) {
    TextView view = new TextView(App.context);
    view.setText(text.text);
    App.screen.addView(view);

    return view;
  }

  public static ListView add(List list) {
    ListView view = new ListViewBuilder(App.context, list).build();
    App.screen.addView(view);

    return view;
  }

  public static void show(final Popup popup) {
    new AlertDialogBuilder(App.context, popup).build().show();
  }
}
