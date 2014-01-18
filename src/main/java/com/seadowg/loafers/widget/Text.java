package com.seadowg.loafers.widget;

import com.seadowg.loafers.app.App;

public class Text {
  public final String text;

  public Text(String text) {
    this.text = text;
    App.add(this);
  }
}
