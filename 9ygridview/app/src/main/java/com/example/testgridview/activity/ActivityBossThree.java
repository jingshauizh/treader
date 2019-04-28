package com.example.testgridview.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.testgridview.R;
import com.example.testgridview.adapter.BOSSOneGridAdapter;
import com.example.testgridview.adapter.BOSSOneListAdapter;
import com.example.testgridview.adapter.BOSSThreeListAdapter;
import com.example.testgridview.business.BossOneBusiness;
import com.example.testgridview.business.BossThreeBusiness;
import com.example.testgridview.constraint.BossConstraint;
import com.example.testgridview.constraint.BossConstraintThree;
import com.example.testgridview.model.GridItem;
import java.util.ArrayList;
import java.util.List;

public class ActivityBossThree extends Activity implements AdapterView.OnItemClickListener {

    private GridView gview;
    private ListView lActionListview;
    private List<GridItem> actionItems;
    private List<GridItem> actionListItems;
    private BOSSThreeListAdapter saListImageItems;
    private TextView tvNotice;
    private BOSSOneGridAdapter saImageItems;
    private ClickeItem cachedClickeItem;

    private boolean is40after;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boss_three);
        gview = (GridView) findViewById(R.id.gview_boss3);
        tvNotice = (TextView) findViewById(R.id.gview_boss1_solution_3);
        lActionListview = (ListView) findViewById(R.id.gview_boss3_ordered_list);
        initData();
        saImageItems = new BOSSOneGridAdapter(this, gview);
        saImageItems.setActionItems(actionItems);
        gview.setAdapter(saImageItems);

        actionListItems = BossConstraintThree.getBOSS_THREE_ActionItemListBegin();
        saListImageItems = new BOSSThreeListAdapter(this, lActionListview);
        saListImageItems.setActionItems(actionListItems);
        lActionListview.setAdapter(saListImageItems);
        //lActionListview.setOnItemClickListener(this);
        lActionListview.setOnItemClickListener(this);
        //设置手机屏幕常亮
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.v(BossConstraint.LOG_TAG, "onItemClick i=" + i);


        saListImageItems.setSelectedItem(i);
    }

    /**
     * 数据资源：标题 ＋ 图片
     */
    private String[] arrText = new String[] {
        "寂", "殇", "呤", "弑", "赦"
    };
    private int[] arrImages = new int[] {
        R.drawable.address_book, R.drawable.calendar, R.drawable.camera, R.drawable.clock,
        R.drawable.games_control,
    };

    private void initData() {
        actionItems = new ArrayList<GridItem>();
        GridItem pt = new GridItem(arrText[0], arrImages[0]);
        pt.setItemType(BossConstraintThree.ACTION_BOSS1_JI);
        actionItems.add(pt);

        GridItem pt1 = new GridItem(arrText[1], arrImages[1]);
        pt1.setItemType(BossConstraintThree.ACTION_BOSS1_SHANG);
        actionItems.add(pt1);

        GridItem pt2 = new GridItem(arrText[2], arrImages[2]);
        pt2.setItemType(BossConstraintThree.ACTION_BOSS1_YIN);
        actionItems.add(pt2);

        GridItem pt3 = new GridItem(arrText[3], arrImages[3]);
        pt3.setItemType(BossConstraintThree.ACTION_BOSS1_SHI);
        actionItems.add(pt3);

        GridItem pt4 = new GridItem(arrText[4], arrImages[4]);
        pt4.setItemType(BossConstraintThree.ACTION_BOSS1_SHE);
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


