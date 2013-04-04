package de.alosdev.listviewdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class CustomAdapterActivity extends Activity implements OnItemClickListener {
  private ArrayAdapter<String> adapter;
  private int counter = 1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ListView list = (ListView) findViewById(R.id.list);
    String[] array = getResources().getStringArray(R.array.list_view_examples);
    adapter = new CustomArrayAdapter(this, android.R.layout.simple_list_item_1,
      android.R.id.text1, new ArrayList<String>(Arrays.asList(array)));
    list.setAdapter(adapter);
    list.setOnItemClickListener(this);
  }

  @Override
  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    switch (position) {
      case 3: {
        adapter.add("added item " + counter++);
        break;
      }

      default: {
        Toast.makeText(this, "you selected position: " + (position + 1), Toast.LENGTH_SHORT).show();
        break;
      }
    }
  }

  private class CustomArrayAdapter extends ArrayAdapter<String> {
    private final int textViewResourceId;
    private final int resource;
    private LayoutInflater inflater;

    public CustomArrayAdapter(Context context, int resource, int textViewResourceId, List<String> objects) {
      super(context, resource, textViewResourceId, objects);
      this.resource = resource;
      this.textViewResourceId = textViewResourceId;
      inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      View v;
      if (null == convertView) {
        v = inflater.inflate(resource, parent, false);
      } else {
        v = convertView;
      }

      TextView text = (TextView) v.findViewById(textViewResourceId);
      text.setText(getItem(position));
      if ((position % 2) == 0) {
        text.setBackgroundColor(getResources().getColor(R.color.white));
        text.setTextColor(getResources().getColor(R.color.black));
      } else {
        text.setBackgroundColor(getResources().getColor(R.color.blue));
        text.setTextColor(getResources().getColor(R.color.white));
      }

      return v;
    }

  }
}
