package com.seadowg.loafers.widget;

import android.widget.TextView;
import com.google.common.base.Function;
import com.seadowg.loafers.app.App;

public class Text {
  public final String text;
  private final TextView textView;

  public Text(String text) {
    this.text = text;
    textView = App.add(this);
  }

  public void setText(String text) {
    textView.setText(text);
  }

  public void setText(Input input) {
    input.onChange(new UpdateFromInput(this));
  }

  private class UpdateFromInput implements Function<String, Void> {
    private Text text;

    public UpdateFromInput(Text text) {
      this.text = text;
    }

    @Override
    public Void apply(String string) {
      text.setText(string);
      return null;
    }
  }
}
