package com.seadowg.loafers.test.helper;

import android.app.Activity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class Helper {
  public static LinearLayout fetchAppLayout(Activity activity) {
    FrameLayout rootView = (FrameLayout) activity.getWindow().getDecorView().getRootView();
    LinearLayout rootLayout = (LinearLayout) rootView.getChildAt(0);
    return ((LinearLayout) ((FrameLayout) rootLayout.getChildAt(2)).getChildAt(0));
  }
}
