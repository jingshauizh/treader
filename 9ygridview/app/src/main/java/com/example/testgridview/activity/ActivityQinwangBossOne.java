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
import com.example.testgridview.model.GridItem;
import com.example.testgridview.view.PercentCircle;
import java.util.ArrayList;
import java.util.List;

public class ActivityQinwangBossOne extends Activity implements AdapterView.OnItemClickListener ,View.OnClickListener{

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
        setContentView(R.layout.activity_qinwang_boss_one);
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
        actionListItems = BossConstraint.getBOSS_ONE_ActionItemListBegin();
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
        int clickType = clickedItem.getItemType();
        List<GridItem> newactionListItems = BossConstraint.getBOSS_ONE_ActionItemListBegin();
        long timedistance = System.currentTimeMillis() - cachedClickeItem.getClickeTime();
        String checkStringResult ="";
        if(null != cachedClickeItem && (timedistance <= 30000)){
            //cachedClickeItem 有效
            checkStringResult =
                BossOneBusiness.updateCheckedItemList(clickType, newactionListItems,cachedClickeItem.itemType);
        }
        else{
             checkStringResult =
                BossOneBusiness.updateCheckedItemList(clickType, newactionListItems);
        }
        saListImageItems.setActionItems(newactionListItems);
        tvNotice.setText(checkStringResult);
        cachedClickeItem = new ClickeItem(System.currentTimeMillis(),clickType);
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
                    if (!ActivityQinwangBossOne.this.isFinishing()) {
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
        actionItems = new ArrayList<GridItem>();
        GridItem pt = new GridItem(arrText[0], arrImages[0]);
        pt.setItemType(BossConstraint.ACTION_BOSS1_XINHENIZHUAN);
        actionItems.add(pt);

        GridItem pt1 = new GridItem(arrText[1], arrImages[1]);
        pt1.setItemType(BossConstraint.ACTION_BOSS1_ZHURI);
        actionItems.add(pt1);

        GridItem pt2 = new GridItem(arrText[2], arrImages[2]);
        pt2.setItemType(BossConstraint.ACTION_BOSS1_ZHUIXING);
        actionItems.add(pt2);

        GridItem pt3 = new GridItem(arrText[3], arrImages[3]);
        pt3.setItemType(BossConstraint.ACTION_BOSS1_XINGLUOMIBU);
        actionItems.add(pt3);

        GridItem pt4 = new GridItem(arrText[4], arrImages[4]);
        pt4.setItemType(BossConstraint.ACTION_BOSS1_XINGMIE);
        actionItems.add(pt4);
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


