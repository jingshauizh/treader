package com.example.testgridview.adapter;

import android.util.Log;
import android.widget.BaseAdapter;
import com.example.testgridview.model.GridItem;
import com.example.testgridview.utils.BOSSConstrants;
import java.util.List;

/**
 * Created by jings on 2019/4/28.
 */

public abstract class BossBaseAdapter extends BaseAdapter {
    public static final int BOSS_ACTION_DURATION = 15*1000;  //间隔时间  毫秒
    public int actionDistance = BOSS_ACTION_DURATION;
    protected List<GridItem> actionItems;
    public void setSelectedItem(int position){
        int selectedPos = position;
        if(null != actionItems){
            unSelectAll();
            if ((selectedPos < 0) || (selectedPos >= actionItems.size())) {
                actionItems.get(0).setSelected(true);
                actionItems.get(0).setExpirationTime(System.currentTimeMillis()+actionDistance);
            }
            else{
                actionItems.get(selectedPos).setSelected(true);
                actionItems.get(selectedPos).setExpirationTime(System.currentTimeMillis()+actionDistance);
            }
        }
        this.notifyDataSetChanged();
    }

    private void unSelectAll(){
        for(int i=0;i<actionItems.size();i++){
            actionItems.get(i).setSelected(false);
            actionItems.get(i).setExpirationTime(0);
        }
    }

    public int getActionDistance() {
        return actionDistance;
    }

    public void setActionDistance(int actionDistance) {
        this.actionDistance = actionDistance;
        Log.v(BOSSConstrants.LOG_TAG,"adapter set actionDistance="+actionDistance);
    }
}
