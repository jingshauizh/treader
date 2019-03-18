package com.example.testgridview;

import com.example.testgridview.adapter.BOSSOneGridAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends Activity {
	private GridView gview;
	private List<Map<String, Object>> data_list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);
		gview = (GridView) findViewById(R.id.gview);
		data_list = new ArrayList<Map<String, Object>>();
		BOSSOneGridAdapter saImageItems = new BOSSOneGridAdapter(this, gview);

		gview.setAdapter(saImageItems);
	}

	

}
