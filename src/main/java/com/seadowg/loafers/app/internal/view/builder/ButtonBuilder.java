package com.seadowg.loafers.app.internal.view.builder;

import android.content.Context;
import android.view.View;
import com.seadowg.loafers.widget.Button;

public class ButtonBuilder {
  private Context context;
  private Button button;

  public ButtonBuilder(Context context, Button button) {
    this.context = context;
    this.button = button;
  }

  public View build() {
    android.widget.Button androidButton = new android.widget.Button(context);
    androidButton.setText(button.text);
    androidButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        button.click();
      }
    });

    return androidButton;
  }
}
