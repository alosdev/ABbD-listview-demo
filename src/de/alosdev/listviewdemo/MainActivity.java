package de.alosdev.listviewdemo;

import java.util.ArrayList;
import java.util.Arrays;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnItemClickListener {
  private ArrayAdapter<String> adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ListView list = (ListView) findViewById(R.id.list);
    String[] array = getResources().getStringArray(R.array.list_view_examples);
    adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
      android.R.id.text1, new ArrayList<String>(Arrays.asList(array)));
    list.setAdapter(adapter);
    list.setOnItemClickListener(this);
  }

  @Override
  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    switch (position) {
      case 1: {
        startActivity(new Intent(this, CustomAdapterActivity.class));
        break;
      }

      case 2: {
        startActivity(new Intent(this, ListActivity.class));
        break;
      }

      case 3: {
        adapter.add("added item " + position);
        break;
      }

      case 4: {
        startActivity(new Intent(this, ListFragmentActivity.class));
        break;
      }

      case 5: {
        startActivity(new Intent(this, MultiSelectActivity.class));
        break;
      }

      case 6: {
        startActivity(new Intent(this, HeaderFooterActivity.class));
        break;
      }

      case 7: {
        startActivity(new Intent(this, CursorAdapterActivity.class));
        break;
      }

      default: {
        Toast.makeText(this, "you selected position: " + (position + 1), Toast.LENGTH_SHORT).show();
        break;
      }
    }
  }
}
