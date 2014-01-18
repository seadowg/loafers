package com.seadowg.loafers.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import com.google.common.base.Function;
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

  public void onChange(Function<String, Void> function) {
    editText.addTextChangedListener(new ChangeListener(function));
  }

  private class ChangeListener implements TextWatcher {
    private Function<String, Void> function;

    public ChangeListener(Function<String, Void> function) {
      this.function = function;
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
      function.apply(s.toString());
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

    @Override
    public void afterTextChanged(Editable s) { }
  }
}
