package com.seadowg.loafers.app.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

public class Screen {
  private LinearLayout layout;

  public void attach(Activity activity) {
    layout = new LinearLayout(activity);
    layout.setOrientation(LinearLayout.VERTICAL);
    layout.setLayoutParams(new LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.FILL_PARENT,
        LinearLayout.LayoutParams.FILL_PARENT
    ));

    activity.setContentView(layout);
  }

  public void addView(View view) {
    layout.addView(view);
  }
}
