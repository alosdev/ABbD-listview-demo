package de.alosdev.listviewdemo;

import java.util.ArrayList;
import java.util.Arrays;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class ListFragmentActivity extends Activity {
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list_fragment);
  }


  public static class ListFragment extends android.app.ListFragment {
    private ArrayAdapter<String> adapter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);

      String[] array = getResources().getStringArray(R.array.list_view_examples);
      adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,
        android.R.id.text1, new ArrayList<String>(Arrays.asList(array)));
      setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
      switch (position) {
        case 3: {
          adapter.add("added item " + position);
          break;
        }

        default: {
          Toast.makeText(getActivity(), "you selected position: " + (position + 1), Toast.LENGTH_SHORT).show();
          break;
        }
      }
    }
  }

}
