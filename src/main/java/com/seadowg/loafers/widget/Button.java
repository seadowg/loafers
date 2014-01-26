package com.seadowg.loafers.widget;

import com.seadowg.loafers.app.App;

public abstract class Button {
  public abstract void press();

  public final String text;

  public Button(String text) {
    this.text = text;

    App.add(this);
  }
}
