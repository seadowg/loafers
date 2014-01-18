package com.seadowg.loafers.widget;

import android.widget.EditText;
import com.seadowg.loafers.app.App;

public class Input {
  private final EditText editText;

  public Input() {
    editText = App.add(this);
  }

  public String getText() {
    return editText.getText().toString();
  }

  public void setText(String text) {
    editText.setText(text);
  }
}
