package com.example.testgridview.adapter;

import android.widget.BaseAdapter;
import com.example.testgridview.model.GridItem;
import java.util.List;

/**
 * Created by jings on 2019/4/28.
 */

public abstract class BossBaseAdapter extends BaseAdapter {
    public static final int BOSS_ACTION_DURATION = 15*1000;  //间隔时间  毫秒

    protected List<GridItem> actionItems;
    public void setSelectedItem(int position){
        int selectedPos = position;
        if(null != actionItems){
            if ((selectedPos < 0) || (selectedPos >= actionItems.size())) {
                actionItems.get(0).setSelected(true);
            }
            else{
                for(int i=0;i<actionItems.size();i++){
                    if(i == selectedPos){
                        actionItems.get(i).setSelected(true);
                        actionItems.get(i).setExpirationTime(System.currentTimeMillis()+BOSS_ACTION_DURATION);
                    }
                    else{
                        actionItems.get(i).setSelected(false);
                        actionItems.get(i).setExpirationTime(0);
                    }
                }
            }
        }
        this.notifyDataSetChanged();
    }
}
