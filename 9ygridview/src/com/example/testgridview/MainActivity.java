package com.example.testgridview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	private GridView gview;
	private List<Map<String, Object>> data_list;
	private SimpleAdapter sim_adapter;
	// ͼƬ��װΪһ������
	private int[] icon = { R.drawable.address_book, R.drawable.calendar,
			R.drawable.camera, R.drawable.clock, R.drawable.games_control,
			R.drawable.messenger, R.drawable.ringtone, R.drawable.settings,
			R.drawable.speech_balloon, R.drawable.weather, R.drawable.world,
			R.drawable.youtube };
	private String[] iconName = { "ͨѶ¼", "����", "�����", "ʱ��", "��Ϸ", "����", "����",
			"����", "����", "����", "�����", "��Ƶ" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);
		gview = (GridView) findViewById(R.id.gview);
		//�½�List
		data_list = new ArrayList<Map<String, Object>>();
		//��ȡ����
		getData();
		//�½�������
		String [] from ={"image","text"};
		int [] to = {R.id.image,R.id.text};
		sim_adapter = new SimpleAdapter(this, data_list, R.layout.item, from, to);
		//����������
		gview.setAdapter(sim_adapter);
	}

	
	
	public List<Map<String, Object>> getData(){		
		//cion��iconName�ĳ�������ͬ�ģ�������ѡ��һ������
		for(int i=0;i<icon.length;i++){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("image", icon[i]);
			map.put("text", iconName[i]);
			data_list.add(map);
		}
			
		return data_list;
	}
	

}
