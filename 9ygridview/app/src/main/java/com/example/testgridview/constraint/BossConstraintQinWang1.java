package com.example.testgridview.constraint;

import android.support.v4.util.ArrayMap;
import com.example.testgridview.R;
import com.example.testgridview.model.GridItem;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jings on 2019/3/17.
 */

public class BossConstraintQinWang1 {
    public static String LOG_TAG = "action";


    public static int ACTION_BOSS1_ZHURI = 1001;
    public static int ACTION_BOSS1_ZHUIXING = ACTION_BOSS1_ZHURI + 1;
    public static int ACTION_BOSS1_XINGMIE = ACTION_BOSS1_ZHUIXING + 1;
    public static int ACTION_BOSS1_XINGLUOMIBU = ACTION_BOSS1_XINGMIE + 1;
    public static int ACTION_BOSS1_XINHENIZHUAN = ACTION_BOSS1_XINGLUOMIBU + 1;
    public static int ACTION_BOSS1_XINGMUFENTIAN = ACTION_BOSS1_XINHENIZHUAN + 1;

    /**
     * 数据资源：标题 ＋ 图片
     */
    private static String[] arrText = new String[] {
        "星河逆转", "追新逐日", "追星", "星落密布", "星灭","星幕焚天"
    };
    private static int[] arrImages = new int[] {
        R.drawable.address_book, R.drawable.calendar, R.drawable.camera, R.drawable.clock,
        R.drawable.games_control,R.drawable.games_control
    };

    public static List<GridItem> getFridinitData() {
        List<GridItem> actionItems = new ArrayList<GridItem>();
        GridItem pt = new GridItem(arrText[0], arrImages[0]);
        pt.setItemType(BossConstraintQinWang1.ACTION_BOSS1_XINHENIZHUAN);
        actionItems.add(pt);

        GridItem pt1 = new GridItem(arrText[1], arrImages[1]);
        pt1.setItemType(BossConstraintQinWang1.ACTION_BOSS1_ZHURI);
        actionItems.add(pt1);

        GridItem pt2 = new GridItem(arrText[2], arrImages[2]);
        pt2.setItemType(BossConstraintQinWang1.ACTION_BOSS1_ZHUIXING);
        actionItems.add(pt2);

        GridItem pt3 = new GridItem(arrText[3], arrImages[3]);
        pt3.setItemType(BossConstraintQinWang1.ACTION_BOSS1_XINGLUOMIBU);
        actionItems.add(pt3);

        GridItem pt4 = new GridItem(arrText[4], arrImages[4]);
        pt4.setItemType(BossConstraintQinWang1.ACTION_BOSS1_XINGMIE);
        actionItems.add(pt4);

        GridItem pt5 = new GridItem(arrText[5], arrImages[5]);
        pt5.setItemType(BossConstraintQinWang1.ACTION_BOSS1_XINGMUFENTIAN);
        actionItems.add(pt5);
        return actionItems;
    }

    public static ArrayMap<Integer, Integer> getBOSS_ONE_ActionItemMap() {
        ArrayMap<Integer, Integer> actionMap = new ArrayMap<Integer, Integer>();
        actionMap.put(ACTION_BOSS1_ZHURI, 1);
        actionMap.put(ACTION_BOSS1_ZHUIXING, 2);
        actionMap.put(ACTION_BOSS1_XINGMIE, 4);
        actionMap.put(ACTION_BOSS1_XINGLUOMIBU, 3);
        actionMap.put(ACTION_BOSS1_XINHENIZHUAN, 0);
        actionMap.put(ACTION_BOSS1_XINGMUFENTIAN, 5);
        return actionMap;
    }

    public static List<GridItem> getBOSS_ONE_ActionItemListBegin() {
        ArrayMap<Integer, Integer> map = getBOSS_ONE_ActionItemMap();
        List<Integer> actionList = getBOSS_ONE_ActionListBegin();
        List<GridItem> resulktList = new ArrayList<>();
        for (Integer intpos : actionList) {
            int postion = map.get(intpos);
            GridItem mGridItem = new GridItem(intpos, arrText[postion], arrImages[postion]);
            resulktList.add(mGridItem);
        }
        return resulktList;
    }

    public static List<GridItem> getBOSS_ONE_ActionItemList40After() {
        ArrayMap<Integer, Integer> map = getBOSS_ONE_ActionItemMap();
        List<Integer> actionList = getBOSS_ONE_ActionListAfter40();
        List<GridItem> resulktList = new ArrayList<>();
        for (Integer intpos : actionList) {
            int postion = map.get(intpos);
            GridItem mGridItem = new GridItem(intpos, arrText[postion], arrImages[postion]);
            resulktList.add(mGridItem);
        }
        return resulktList;
    }

    public static List<Integer> getBOSS_ONE_ActionListBegin() {
        List<Integer> actionList = new ArrayList<>();
        actionList.add(ACTION_BOSS1_XINGLUOMIBU);   //星落
        actionList.add(ACTION_BOSS1_XINGMIE);       //星灭
        actionList.add(ACTION_BOSS1_ZHURI);         //逐日
        actionList.add(ACTION_BOSS1_XINHENIZHUAN);  //星河
        actionList.add(ACTION_BOSS1_ZHURI);         //逐日
        actionList.add(ACTION_BOSS1_ZHUIXING);      //追星
        actionList.add(ACTION_BOSS1_ZHUIXING);      //追星
        actionList.add(ACTION_BOSS1_XINGMUFENTIAN);      //焚天
        actionList.add(ACTION_BOSS1_XINHENIZHUAN);  //星河
        actionList.add(ACTION_BOSS1_ZHURI);         //逐日
        return actionList;
    }

    public  static  List<Integer> getBOSS_ONE_ActionListAfter40() {
        List<Integer> actionList = new ArrayList<>();
        actionList.add(ACTION_BOSS1_XINGMIE);       //星灭
        actionList.add(ACTION_BOSS1_ZHURI);         //逐日
        actionList.add(ACTION_BOSS1_XINGLUOMIBU);   //星落
        actionList.add(ACTION_BOSS1_XINHENIZHUAN);  //星河
        actionList.add(ACTION_BOSS1_ZHURI);         //逐日
        actionList.add(ACTION_BOSS1_XINGMIE);       //星灭
        actionList.add(ACTION_BOSS1_XINGLUOMIBU);   //星落
        actionList.add(ACTION_BOSS1_XINHENIZHUAN);  //星河
        return actionList;
    }
}
