package com.seadowg.loafers.app.internal.view.builder;

import android.app.AlertDialog;
import android.content.Context;
import com.seadowg.loafers.widget.Popup;

public class AlertDialogBuilder {
  private final Context context;
  private final Popup popup;

  public AlertDialogBuilder(Context context, Popup popup) {
    this.context = context;
    this.popup = popup;
  }

  public AlertDialog build() {
    AlertDialog.Builder builder = new AlertDialog.Builder(context);
    builder.setTitle(popup.text);
    return builder.create();
  }
}
