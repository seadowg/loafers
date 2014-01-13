package com.seadowg.loafers.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.seadowg.loafers.widget.Button;
import com.seadowg.loafers.widget.Input;
import com.seadowg.loafers.widget.Popup;

public abstract class App extends Activity {
  private static App activity;
  private LinearLayout layout;

  protected String title = "Loafers";

  public abstract void open();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    layout = new LinearLayout(this);
    layout.setOrientation(LinearLayout.VERTICAL);
    layout.setLayoutParams(new LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.FILL_PARENT,
        LinearLayout.LayoutParams.FILL_PARENT
    ));
    setContentView(layout);

    App.activity = this;
    open();
    setTitle(title);
  }

  public LinearLayout getLayout() {
    return layout;
  }

  public static void add(final Button button) {
    android.widget.Button androidButton = new android.widget.Button(App.activity);
    androidButton.setText(button.text);
    androidButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        button.click();
      }
    });

    App.activity.getLayout().addView(androidButton);
  }

  public static void add(final Input input) {
    android.widget.EditText editText = new EditText(App.activity);
    App.activity.getLayout().addView(editText);
  }

  public static void show(final Popup popup) {
    AlertDialog.Builder builder = new AlertDialog.Builder(App.activity);
    builder.setTitle(popup.text);
    builder.create().show();
  }
}
