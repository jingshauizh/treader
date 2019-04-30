package com.example.testgridview;

import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import com.example.testgridview.activity.ActivityBossOne;
import com.example.testgridview.activity.ActivityBossThree;
import com.example.testgridview.activity.ActivityQinwangBossFive;
import com.example.testgridview.activity.ActivityQinwangBossOne;
import com.example.testgridview.activity.ActivityQinwangBossOneTest;
import com.example.testgridview.activity.ActivityQinwangBossTwo;
import com.example.testgridview.activity.ActivitySettings;
import com.example.testgridview.adapter.BOSSOneGridAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.test);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.boss_title_layout);

		ImageButton settingsBtn =  findViewById(R.id.boss_settings);
		Button bognshu1 =  findViewById(R.id.gongshu1);
		Button bognshu3 =  findViewById(R.id.gongshu3);
		Button qinwang11 =  findViewById(R.id.qinwang1);
		Button qinwang12 =  findViewById(R.id.qinwang2);
		Button qinwang15 =  findViewById(R.id.qinwang5);
		Button qinwang16 =  findViewById(R.id.qinwang6);
		Button qinwang17 =  findViewById(R.id.qinwang7);
		bognshu1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent mintent = new Intent(MainActivity.this, ActivityBossOne.class);
				startActivity(mintent);
			}
		});

		bognshu3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent mintent = new Intent(MainActivity.this, ActivityBossThree.class);
				startActivity(mintent);
			}
		});
		qinwang11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent mintent = new Intent(MainActivity.this, ActivityQinwangBossOne.class);
				startActivity(mintent);
			}
		});

		qinwang12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent mintent = new Intent(MainActivity.this, ActivityQinwangBossTwo.class);
				startActivity(mintent);
			}
		});

		qinwang15.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent mintent = new Intent(MainActivity.this, ActivityQinwangBossFive.class);
				startActivity(mintent);
			}
		});

		qinwang16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent mintent = new Intent(MainActivity.this, ActivityQinwangBossOneTest.class);
				startActivity(mintent);
			}
		});

		qinwang17.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent mintent = new Intent(MainActivity.this, ActivitySettings.class);
				startActivity(mintent);
			}
		});

		settingsBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent mintent = new Intent(MainActivity.this, ActivitySettings.class);
				startActivity(mintent);
			}
		});


	}

	

}
