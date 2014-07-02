package com.seadowg.loafers.app.internal;

import android.app.Activity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class Screen {
  private LinearLayout layout;

  public void attach(Activity activity) {
    setupTheme(activity);

    layout = new LinearLayout(activity);
    layout.setOrientation(LinearLayout.VERTICAL);
    layout.setLayoutParams(new LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.FILL_PARENT,
        LinearLayout.LayoutParams.FILL_PARENT
    ));

    activity.setContentView(layout);
  }

  private void setupTheme(Activity activity) {
    activity.setTheme(android.R.style.Theme_Holo_Light);
    activity.getActionBar().setDisplayShowHomeEnabled(false);
    activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
  }

  public void addView(View view) {
    layout.addView(view);
  }
}
