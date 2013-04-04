package de.alosdev.listviewdemo;

import java.util.ArrayList;
import java.util.Arrays;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MultiSelectActivity extends android.app.ListActivity {
  private ArrayAdapter<String> adapter;

  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    String[] array = getResources().getStringArray(R.array.list_view_examples);
    adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,
      android.R.id.text1, new ArrayList<String>(Arrays.asList(array))) {
      @Override
      public boolean hasStableIds() {
        return true;
      }
    };
    setListAdapter(adapter);
    getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    for (int i = 1; i < 15; i++) {
      adapter.add("dummy item " + i);
    }
  }

  @Override
  protected void onListItemClick(ListView l, View v, int position, long id) {
    Toast.makeText(this, "selected positions: " + Arrays.toString(l.getCheckedItemIds()), Toast.LENGTH_SHORT).show();
  }

}
