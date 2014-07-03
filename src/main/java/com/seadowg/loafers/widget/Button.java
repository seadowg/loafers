package com.seadowg.loafers.widget;

import com.seadowg.loafers.app.App;

public class Button {
  public final String text;

  public Button(String text) {
    this.text = text;

    App.add(this);
  }

  public void press() {

  }
}
