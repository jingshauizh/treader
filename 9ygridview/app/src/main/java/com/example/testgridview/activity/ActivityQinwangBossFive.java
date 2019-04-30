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
import com.example.testgridview.adapter.BOSSQingwangTwoGridAdapter;
import com.example.testgridview.business.BossOneBusiness;
import com.example.testgridview.constraint.BossConstraint;
import com.example.testgridview.constraint.BossConstraintQinWang5;
import com.example.testgridview.model.GridItem;
import com.example.testgridview.view.PercentCircle;
import java.util.ArrayList;
import java.util.List;

public class ActivityQinwangBossFive extends ActivityBase
    implements AdapterView.OnItemClickListener, View.OnClickListener {

    private GridView gview;

    private List<GridItem> actionItems;

    private BOSSQingwangTwoGridAdapter saImageItems;

    private PercentCircle mPercentCircle;
    private CountDownTimer mCountDownTimer;
    private TextView mTextcount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qinwang_boss_five);
        gview = (GridView) findViewById(R.id.gview_boss5);

        mPercentCircle = findViewById(R.id.boss_one_percentCircle);
        mTextcount = findViewById(R.id.gview_count_down_text);
        mPercentCircle.setOnClickListener(this);
        //initData();
        initTimeDistanceFromSP(this, ActivitySettings.BOSS_5_SP_TIME_DISTANCE);
        actionItems = BossConstraintQinWang5.getBOSS_FIVE_ActionItemListBegin();
        saImageItems = new BOSSQingwangTwoGridAdapter(this, gview);
        saImageItems.setActionItems(actionItems);
        saImageItems.setActionDistance(this.spActionDistance);
        gview.setAdapter(saImageItems);
        gview.setOnItemClickListener(this);

        //设置手机屏幕常亮
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.v(BossConstraint.LOG_TAG, "onItemClick i=" + i);
        saImageItems.setSelectedItem(i);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.boss_one_percentCircle:
                startCountDownTimer();
                break;
        }
    }

    private void startCountDownTimer() {
        if (mCountDownTimer == null) {
            mCountDownTimer = new CountDownTimer((long) (60 * 1000), 1000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    if (!ActivityQinwangBossFive.this.isFinishing()) {
                        int remainTime = (int) (millisUntilFinished / 1000L);
                        Log.e("zpan", "======remainTime=====" + remainTime);
                        mTextcount.setText(String.valueOf(remainTime));
                        if (null != mPercentCircle) {
                            int target = 100 * (60 - remainTime) / 60;
                            mPercentCircle.setTargetPercent(target);
                        }
                    }
                }

                @Override
                public void onFinish() {
                    Log.e("zpan", "======onFinish=====");
                }
            };
            mCountDownTimer.start();
        } else {
            mCountDownTimer.cancel();
            mCountDownTimer.start();
        }
    }

    /**
     * 数据资源：标题 ＋ 图片
     */
    private String[] arrText = new String[] {
        "须禁", "迷茫", "狂怒", "欢喜", "冥思", "忧郁", "极寒", "恐吓"
    };
    private int[] arrImages = new int[] {
        R.drawable.address_book, R.drawable.calendar, R.drawable.camera, R.drawable.clock,
        R.drawable.games_control, R.drawable.games_control, R.drawable.games_control
    };

    public class ClickeItem {
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


