package com.example.testgridview.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.testgridview.MainActivity;
import com.example.testgridview.adapter.BOSSOneListAdapter;
import com.example.testgridview.business.BossOneBusiness;
import com.example.testgridview.model.GridItem;
import com.example.testgridview.adapter.BOSSOneGridAdapter;
import com.example.testgridview.R;
import com.example.testgridview.constraint.BossConstraint;
import java.util.ArrayList;
import java.util.List;

public class ActivityBossOne extends Activity implements AdapterView.OnItemClickListener {

    private static String TAG_LOG = "ActivityBossOne";
    private GridView gview;
    private ListView lActionListview;
    private List<GridItem> actionItems;
    private List<GridItem> actionListItems;
    private BOSSOneListAdapter saListImageItems;
    private TextView tvNotice;
    private BOSSOneGridAdapter saImageItems;
    private ClickeItem cachedClickeItem;

    private boolean is40after;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boss_one);
        gview = (GridView) findViewById(R.id.gview_boss1);
        tvNotice = (TextView) findViewById(R.id.gview_boss1_solution_1);
        lActionListview = (ListView) findViewById(R.id.gview_boss1_ordered_list);
        Intent mintent = getIntent();
        is40after = mintent.getBooleanExtra("type",false);

        initData();
        initTimeDistanceFromSP(ActivityBossOne.this);

        saImageItems = new BOSSOneGridAdapter(this, gview);
        saImageItems.setActionItems(actionItems);
        gview.setAdapter(saImageItems);
        gview.setOnItemClickListener(this);
        if (!is40after) {
            actionListItems = BossConstraint.getBOSS_ONE_ActionItemListBegin();
        } else {
            actionListItems = BossConstraint.getBOSS_ONE_ActionItemList40After();
        }
        saListImageItems = new BOSSOneListAdapter(this, lActionListview);
        saListImageItems.setActionItems(actionListItems);
        lActionListview.setAdapter(saListImageItems);
        //lActionListview.setOnItemClickListener(this);


        Button bognshu1 =  findViewById(R.id.linearLayout_button_begin);
        Button qinwang11 =  findViewById(R.id.linearLayout_button_40after);
        bognshu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityBossOne.this.finish();
                Intent mintent = new Intent(ActivityBossOne.this, ActivityBossOne.class);
                mintent.putExtra("type",false);
                startActivity(mintent);
            }
        });
        qinwang11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityBossOne.this.finish();
                Intent mintent = new Intent(ActivityBossOne.this, ActivityBossOne.class);
                mintent.putExtra("type",true);
                startActivity(mintent);

            }
        });

        //设置手机屏幕常亮
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    private void initTimeDistanceFromSP(Context pcontext){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String listpref = sp.getString(ActivitySettings.BOSS_1_SP_TIME_DISTANCE, "10000");
        Log.v(TAG_LOG,"BOSS_1_SP_TIME_DISTANCE ="+listpref);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.v(BossConstraint.LOG_TAG, "onItemClick i=" + i);
        int positon = i;
        GridItem clickedItem = actionItems.get(positon);
        int clickType = clickedItem.getItemType();
        List<GridItem> newactionListItems = BossConstraint.getBOSS_ONE_ActionItemListBegin();

        String checkStringResult ="";
        if(null != cachedClickeItem ){
            long timedistance = System.currentTimeMillis() - cachedClickeItem.getClickeTime();
            if (timedistance <= 30000){
                //cachedClickeItem 有效
                if(!is40after){
                    checkStringResult =
                        BossOneBusiness.updateCheckedItemList(clickType, newactionListItems,cachedClickeItem.itemType);
                }

            }

        }
        else{
            if(!is40after){
                checkStringResult =
                    BossOneBusiness.updateCheckedItemList(clickType, newactionListItems);
            }

        }
        saListImageItems.setActionItems(newactionListItems);
        tvNotice.setText(checkStringResult);
        cachedClickeItem = new ClickeItem(System.currentTimeMillis(),clickType);
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


