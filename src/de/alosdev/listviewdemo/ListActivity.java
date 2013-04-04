package de.alosdev.listviewdemo;

import java.util.ArrayList;
import java.util.Arrays;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class ListActivity extends android.app.ListActivity {
  private ArrayAdapter<String> adapter;

  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    String[] array = getResources().getStringArray(R.array.list_view_examples);
    adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
      android.R.id.text1, new ArrayList<String>(Arrays.asList(array)));
    setListAdapter(adapter);
  }

  @Override
  protected void onListItemClick(ListView l, View v, int position, long id) {
    switch (position) {
      case 3: {
        adapter.add("added item " + position);
        break;
      }

      default: {
        Toast.makeText(this, "you selected position: " + (position + 1), Toast.LENGTH_SHORT).show();
        break;
      }
    }
  }

}
