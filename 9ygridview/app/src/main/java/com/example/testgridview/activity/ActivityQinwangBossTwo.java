package com.example.testgridview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import com.example.testgridview.R;
import com.example.testgridview.adapter.BOSSOneGridAdapter;
import com.example.testgridview.adapter.BOSSQingwangTwoGridAdapter;
import com.example.testgridview.adapter.BossBaseAdapter;
import com.example.testgridview.business.BossqinwangTwoOneBusiness;
import com.example.testgridview.constraint.BossConstraint;
import com.example.testgridview.constraint.BossConstraintQinWang2;
import com.example.testgridview.model.GridItem;
import com.example.testgridview.view.PercentCircle;
import java.util.List;

/**
 *  backlog
 *  1 放大优化listview UI
 *  2 listview 可点击 干变背景色，提示 下两个 item
 */
public class ActivityQinwangBossTwo extends ActivityBase implements AdapterView.OnItemClickListener ,View.OnClickListener{

    private GridView gview;
    private GridView lActionListview;
    private List<GridItem> actionItems;
    private List<GridItem> actionListItems;
    private BOSSQingwangTwoGridAdapter saListImageItems;
    private TextView tvNotice;
    private BOSSOneGridAdapter saImageItems;
    private ClickeItem cachedClickeItem;
    private PercentCircle mPercentCircle;

    private CountDownTimer mCountDownTimer;
    private TextView mTextcount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qinwang_boss_two);
        gview = (GridView) findViewById(R.id.gview_qinwang_boss2);
        lActionListview = (GridView) findViewById(R.id.gview_boss1_ordered_list);
        //mPercentCircle = findViewById(R.id.boss_one_percentCircle);
        mTextcount = findViewById(R.id.gview_count_down_text);
        //mPercentCircle.setOnClickListener(this);
        initData();
        initTimeDistanceFromSP(this,ActivitySettings.BOSS_2_SP_TIME_DISTANCE);

        saImageItems = new BOSSOneGridAdapter(this, gview);
        saImageItems.setActionItems(actionItems);
        gview.setAdapter(saImageItems);
        //gview.setOnItemClickListener(this);
        actionListItems = BossConstraintQinWang2.getBOSS_TWO_ActionItemListBegin();
        saListImageItems = new BOSSQingwangTwoGridAdapter(this, lActionListview);
        saListImageItems.setActionItems(actionListItems);
        saListImageItems.setActionDistance(this.spActionDistance);
        lActionListview.setAdapter(saListImageItems);
        lActionListview.setOnItemClickListener(this);
        //lActionListview.setOnItemClickListener(this);

        //设置手机屏幕常亮
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.v(BossConstraint.LOG_TAG, "onItemClick i=" + i);

        Log.v(BossConstraint.LOG_TAG, "onItemClick i=" + i);
        saListImageItems.setSelectedItem(i);
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
                    if (!ActivityQinwangBossTwo.this.isFinishing()) {
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

    /**
     * 数据资源：标题 ＋ 图片
     */
    private String[] arrText = new String[] {
        "星河逆转", "追新逐日", "追星", "星落密布", "星灭"
    };
    private int[] arrImages = new int[] {
        R.drawable.address_book, R.drawable.calendar, R.drawable.camera, R.drawable.clock,
        R.drawable.games_control,
    };

    private void initData() {
        actionItems = BossConstraintQinWang2.getFridinitData();
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


