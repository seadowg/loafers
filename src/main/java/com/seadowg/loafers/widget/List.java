package com.seadowg.loafers.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.seadowg.loafers.app.App;
import com.seadowg.loafers.app.internal.view.builder.TextListAdapter;

import java.util.Collection;

import static com.google.common.collect.Collections2.filter;

public class List implements AdapterView.OnItemClickListener {
  private ImmutableList<String> strings;
  private final ListView view;

  public List(String ... strings) {
    this.strings = new ImmutableList.Builder<String>().add(strings).build();
    view = App.add(this);
  }

  public void press(String pressed) {

  }

  public ImmutableList<String> getStrings() {
    return strings;
  }

  public void add(String item) {
    strings = new ImmutableList.Builder<String>().addAll(strings).add(item).build();
    TextListAdapter adapter = (TextListAdapter) view.getAdapter();
    adapter.setList(strings);
    adapter.notifyDataSetChanged();
  }

  public void remove(final String item) {
    Collection<String> filteredList = filter(strings, new Predicate<String>() {
      @Override
      public boolean apply(String s) {
        return s != item;
      }
    });

    strings = new ImmutableList.Builder<String>().addAll(filteredList).build();
    TextListAdapter adapter = (TextListAdapter) view.getAdapter();
    adapter.setList(strings);
    adapter.notifyDataSetChanged();
  }

  public int length() {
    return strings.size();
  }

  @Override
  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    press(strings.get(position));
  }
}
