package com.seadowg.loafers.widget;

import com.seadowg.loafers.app.App;

public class Popup {
  public final String text;

  public Popup(String text) {
    this.text = text;
  }

  public void show() {
    App.show(this);
  }
}
