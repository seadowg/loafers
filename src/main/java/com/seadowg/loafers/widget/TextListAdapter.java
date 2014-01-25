package com.seadowg.loafers.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

public class TextListAdapter implements ListAdapter {
  private Context context;
  private List<String> list;

  public TextListAdapter(Context context, java.util.List<String> list) {
    this.context = context;
    this.list = list;
  }

  @Override
  public boolean areAllItemsEnabled() {
    return false;
  }

  @Override
  public boolean isEnabled(int position) {
    return false;
  }

  @Override
  public void registerDataSetObserver(DataSetObserver observer) {

  }

  @Override
  public void unregisterDataSetObserver(DataSetObserver observer) {

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
  public boolean hasStableIds() {
    return false;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    TextView view = new TextView(context);
    view.setText(list.get(position));
    return view;
  }

  @Override
  public int getItemViewType(int position) {
    return 0;
  }

  @Override
  public int getViewTypeCount() {
    return 1;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }
}
