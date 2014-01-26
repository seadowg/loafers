package com.seadowg.loafers.app.internal.view.builder;

import android.content.Context;
import android.widget.ListView;
import com.seadowg.loafers.widget.List;

public class ListViewBuilder {
  private Context context;
  private List list;

  public ListViewBuilder(Context context, List list) {
    this.context = context;
    this.list = list;
  }

  public ListView build() {
    ListView view = new ListView(context);
    view.setAdapter(new TextListAdapter(context, list.getStrings()));
    view.setOnItemClickListener(list);

    return view;
  }
}
