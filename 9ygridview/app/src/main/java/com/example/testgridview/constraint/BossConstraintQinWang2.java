package com.example.testgridview.constraint;

import android.support.v4.util.ArrayMap;
import com.example.testgridview.R;
import com.example.testgridview.model.GridItem;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jings on 2019/3/17.
 */

public class BossConstraintQinWang2 {
    public static String LOG_TAG = "action";


    public static int ACTION_BOSS2_QUANGANG = 2001;
    public static int ACTION_BOSS2_LIANYING = ACTION_BOSS2_QUANGANG + 1;
    public static int ACTION_BOSS2_YOUBING = ACTION_BOSS2_LIANYING + 1;
    public static int ACTION_BOSS2_LIAOYUAN = ACTION_BOSS2_YOUBING + 1;
    public static int ACTION_BOSS2_DIELANG= ACTION_BOSS2_LIAOYUAN + 1;
    public static int ACTION_BOSS2_GUANGMING = ACTION_BOSS2_DIELANG + 1;

    /**
     * 数据资源：标题 ＋ 图片
     * 拳罡
     莲影
     幽冰
     燎原
     叠浪
     光明
     */
    private static String[] arrText = new String[] {
        "拳罡", "莲影", "幽冰", "燎原", "叠浪", "光明"
    };
    private static int[] arrImages = new int[] {
        R.drawable.address_book, R.drawable.calendar, R.drawable.camera, R.drawable.clock,
        R.drawable.games_control,R.drawable.games_control
    };


    public static List<GridItem> getFridinitData() {
        List<GridItem> actionItems = new ArrayList<GridItem>();
        GridItem pt = new GridItem(arrText[0], arrImages[0]);
        pt.setItemType(BossConstraintQinWang2.ACTION_BOSS2_QUANGANG);
        actionItems.add(pt);

        GridItem pt1 = new GridItem(arrText[1], arrImages[1]);
        pt1.setItemType(BossConstraintQinWang2.ACTION_BOSS2_LIANYING);
        actionItems.add(pt1);

        GridItem pt2 = new GridItem(arrText[2], arrImages[2]);
        pt2.setItemType(BossConstraintQinWang2.ACTION_BOSS2_YOUBING);
        actionItems.add(pt2);

        GridItem pt3 = new GridItem(arrText[3], arrImages[3]);
        pt3.setItemType(BossConstraintQinWang2.ACTION_BOSS2_LIAOYUAN);
        actionItems.add(pt3);

        GridItem pt4 = new GridItem(arrText[4], arrImages[4]);
        pt4.setItemType(BossConstraintQinWang2.ACTION_BOSS2_DIELANG);
        actionItems.add(pt4);

        GridItem pt5 = new GridItem(arrText[5], arrImages[5]);
        pt5.setItemType(BossConstraintQinWang2.ACTION_BOSS2_GUANGMING);
        actionItems.add(pt5);
        return actionItems;
    }

    public static ArrayMap<Integer, Integer> getBOSS_ONE_ActionItemMap() {
        ArrayMap<Integer, Integer> actionMap = new ArrayMap<Integer, Integer>();
        actionMap.put(ACTION_BOSS2_QUANGANG, 0);
        actionMap.put(ACTION_BOSS2_LIANYING, 1);
        actionMap.put(ACTION_BOSS2_YOUBING, 2);
        actionMap.put(ACTION_BOSS2_LIAOYUAN, 3);
        actionMap.put(ACTION_BOSS2_DIELANG, 4);
        actionMap.put(ACTION_BOSS2_GUANGMING, 5);
        return actionMap;
    }

    public static List<GridItem> getBOSS_TWO_ActionItemListBegin() {
        ArrayMap<Integer, Integer> map = getBOSS_ONE_ActionItemMap();
        List<Integer> actionList = getBOSS_TWO_ActionListBegin();
        List<GridItem> resulktList = new ArrayList<>();
        for (Integer intpos : actionList) {
            int postion = map.get(intpos);
            GridItem mGridItem = new GridItem(intpos, arrText[postion], arrImages[postion]);
            resulktList.add(mGridItem);
        }
        return resulktList;
    }

    /**
     *
     拳罡
     莲影
     幽冰
     燎原
     叠浪
     光明
     燎原
     幽冰
     莲影
     拳罡
     光明
     幽冰
     拳罡
     燎原
     光明
     燎原
     拳罡
     光明
     叠浪
     拳罡
     莲影
     光明
     * @return
     */

    public static List<Integer> getBOSS_TWO_ActionListBegin() {
        List<Integer> actionList = new ArrayList<>();
        actionList.add(ACTION_BOSS2_QUANGANG);                 //拳罡
        actionList.add(ACTION_BOSS2_LIANYING);                   //莲影
        actionList.add(ACTION_BOSS2_YOUBING);                      //幽冰
        actionList.add(ACTION_BOSS2_LIAOYUAN);                    //燎原
        actionList.add(ACTION_BOSS2_DIELANG);                  //叠浪
        actionList.add(ACTION_BOSS2_GUANGMING);                 //光明
        actionList.add(ACTION_BOSS2_LIAOYUAN);                       //燎原
        actionList.add(ACTION_BOSS2_YOUBING);                     //幽冰
        actionList.add(ACTION_BOSS2_LIANYING);                  //莲影
        actionList.add(ACTION_BOSS2_QUANGANG);                     //拳罡
        actionList.add(ACTION_BOSS2_GUANGMING);                 //光明
        actionList.add(ACTION_BOSS2_YOUBING);                 //幽冰
        actionList.add(ACTION_BOSS2_QUANGANG);                  //拳罡
        actionList.add(ACTION_BOSS2_LIAOYUAN);                   //燎原
        actionList.add(ACTION_BOSS2_GUANGMING);                //光明
        actionList.add(ACTION_BOSS2_LIAOYUAN);                   //燎原
        actionList.add(ACTION_BOSS2_QUANGANG);                   //拳罡
        actionList.add(ACTION_BOSS2_GUANGMING);                 //光明
        actionList.add(ACTION_BOSS2_DIELANG);                 //叠浪
        actionList.add(ACTION_BOSS2_QUANGANG);                  //拳罡
        actionList.add(ACTION_BOSS2_LIANYING);               //莲影
        actionList.add(ACTION_BOSS2_GUANGMING);                //光明

        return actionList;
    }


}
