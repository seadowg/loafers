package com.seadowg.loafers.test;

import android.widget.LinearLayout;
import android.widget.ListView;
import com.seadowg.loafers.app.App;
import com.seadowg.loafers.test.helper.Helper;
import com.seadowg.loafers.widget.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.robolectric.Robolectric.shadowOf;

@RunWith(RobolectricTestRunner.class) @Config(manifest=Config.NONE)
public class ListTest {
  @Test
  public void rendersListViewOfTexts_fromStrings() {
    ArgsApp app = Robolectric.buildActivity(ArgsApp.class).create().resume().start().get();
    LinearLayout layout = Helper.fetchAppLayout(app);

    ListView listView = (ListView) layout.getChildAt(0);
    shadowOf(listView).populateItems();

    assertEquals("Jake", shadowOf(listView.getChildAt(0)).innerText());
    assertEquals("Fin", shadowOf(listView.getChildAt(1)).innerText());
  }

  @Test
  public void length_returnsTheLengthOfTheList() {
    ArgsApp app = Robolectric.buildActivity(ArgsApp.class).create().resume().start().get();

    List list = app.getList();
    assertEquals(2, list.length());

    list.add("Lumpy Space Princess");
    assertEquals(3, list.length());

    list.remove("Jake");
    list.remove("Fin");
    assertEquals(1, list.length());
  }

  private static class ArgsApp extends App {

    private List list;

    @Override
    public void open() {
      list = new List("Jake", "Fin");
    }

    public List getList() {
      return list;
    }
  }
}
