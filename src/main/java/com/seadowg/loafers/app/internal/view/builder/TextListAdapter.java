package com.seadowg.loafers.app.internal.view.builder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class TextListAdapter extends BaseAdapter {
  private Context context;
  private List<String> list;

  public TextListAdapter(Context context, java.util.List<String> list) {
    this.context = context;
    this.list = list;
  }

  public void setList(List<String> list) {
    this.list = list;
  }

  @Override
  public int getCount() {
    return list.size();
  }

  @Override
  public Object getItem(int position) {
    return null;
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    TextView view = new TextView(context);
    view.setText(list.get(position));
    return view;
  }
}
