package com.example.testgridview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.testgridview.R;
import com.example.testgridview.adapter.BOSSOneGridAdapter;
import com.example.testgridview.adapter.BOSSOneListAdapter;
import com.example.testgridview.business.BossOneBusiness;
import com.example.testgridview.constraint.BossConstraint;
import com.example.testgridview.constraint.BossConstraintQinWang1;
import com.example.testgridview.constraint.BossConstraintQinWang2;
import com.example.testgridview.model.GridItem;
import com.example.testgridview.view.PercentCircle;
import java.util.ArrayList;
import java.util.List;

public class ActivityQinwangBossOneTest extends Activity implements AdapterView.OnItemClickListener ,View.OnClickListener{

    private GridView gview;
    private ListView lActionListview;
    private List<GridItem> actionItems;
    private List<GridItem> actionListItems;
    private BOSSOneListAdapter saListImageItems;
    private TextView tvNotice;
    private BOSSOneGridAdapter saImageItems;
    private ClickeItem cachedClickeItem;
    private PercentCircle mPercentCircle;

    private CountDownTimer mCountDownTimer;
    private TextView mTextcount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qinwang_boss_one_test);
        gview = (GridView) findViewById(R.id.gview_boss1);
        tvNotice = (TextView) findViewById(R.id.gview_boss1_solution_1);
        lActionListview = (ListView) findViewById(R.id.gview_boss1_ordered_list);
        mPercentCircle = findViewById(R.id.boss_one_percentCircle);
        mTextcount = findViewById(R.id.gview_count_down_text);
        mPercentCircle.setOnClickListener(this);
        initData();
        saImageItems = new BOSSOneGridAdapter(this, gview);
        saImageItems.setActionItems(actionItems);
        gview.setAdapter(saImageItems);
        gview.setOnItemClickListener(this);
        actionListItems = BossConstraintQinWang1.getBOSS_ONE_ActionItemListBegin();
        saListImageItems = new BOSSOneListAdapter(this, lActionListview);
        saListImageItems.setActionItems(actionListItems);
        lActionListview.setAdapter(saListImageItems);
        //lActionListview.setOnItemClickListener(this);

        //设置手机屏幕常亮
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.v(BossConstraint.LOG_TAG, "onItemClick i=" + i);
        int positon = i;
        GridItem clickedItem = actionItems.get(positon);
        tvNotice.append(clickedItem.getItemName()+"\n");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.boss_one_percentCircle:
                startCountDownTimer();
                break;
        }
    }

    private void startCountDownTimer(){
        if(mCountDownTimer == null){
            mCountDownTimer = new CountDownTimer((long) (60 * 1000), 1000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    if (!ActivityQinwangBossOneTest.this.isFinishing()) {
                        int remainTime = (int) (millisUntilFinished / 1000L);
                        Log.e("zpan","======remainTime=====" + remainTime);
                        mTextcount.setText(String.valueOf(remainTime));
                        if(null != mPercentCircle){
                            int target = 100*(60-remainTime)/60;
                            mPercentCircle.setTargetPercent(target);
                        }
                    }
                }

                @Override
                public void onFinish() {
                    Log.e("zpan","======onFinish=====");
                }
            };
            mCountDownTimer.start();

        }
        else{
            mCountDownTimer.cancel();
            mCountDownTimer.start();
        }
    }



    private void initData() {
        actionItems = BossConstraintQinWang1.getFridinitData();
    }



    public class ClickeItem{
        private long clickeTime;
        private int itemType;

        public ClickeItem(long clickeTime, int itemType) {
            this.clickeTime = clickeTime;
            this.itemType = itemType;
        }

        public long getClickeTime() {
            return clickeTime;
        }

        public void setClickeTime(long clickeTime) {
            this.clickeTime = clickeTime;
        }

        public int getItemType() {
            return itemType;
        }

        public void setItemType(int itemType) {
            this.itemType = itemType;
        }
    }




}


