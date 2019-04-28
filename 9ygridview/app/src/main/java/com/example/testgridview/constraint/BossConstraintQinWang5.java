package com.example.testgridview.constraint;

import android.support.v4.util.ArrayMap;
import com.example.testgridview.R;
import com.example.testgridview.model.GridItem;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jings on 2019/3/17.
 */

public class BossConstraintQinWang5 {
    public static String LOG_TAG = "action";


    public static int ACTION_BOSS1_XUJIN = 9001;
    public static int ACTION_BOSS1_MIMANG = ACTION_BOSS1_XUJIN + 1;
    public static int ACTION_BOSS1_KUANGNU = ACTION_BOSS1_MIMANG + 1;
    public static int ACTION_BOSS1_HUANXI = ACTION_BOSS1_KUANGNU + 1;
    public static int ACTION_BOSS1_MINGSI = ACTION_BOSS1_HUANXI + 1;
    public static int ACTION_BOSS1_YOUYU = ACTION_BOSS1_MINGSI + 1;
    public static int ACTION_BOSS1_JIHAN = ACTION_BOSS1_YOUYU + 1;
    public static int ACTION_BOSS1_KONGHE = ACTION_BOSS1_JIHAN + 1;

    /**
     * 数据资源：标题 ＋ 图片
     */
    private static String[] arrText = new String[] {
        "须禁", "迷茫", "狂怒", "欢喜", "冥思","忧郁","极寒","恐吓"
    };
    private  static int[] arrImages = new int[] {
        R.drawable.address_book, R.drawable.calendar, R.drawable.camera, R.drawable.clock,
        R.drawable.games_control,R.drawable.games_control,R.drawable.games_control,R.drawable.games_control
    };

    public static ArrayMap<Integer, Integer> getBOSS_FIVE_ActionItemMap() {
        ArrayMap<Integer, Integer> actionMap = new ArrayMap<Integer, Integer>();
        actionMap.put(ACTION_BOSS1_XUJIN, 0);
        actionMap.put(ACTION_BOSS1_MIMANG, 1);
        actionMap.put(ACTION_BOSS1_KUANGNU, 2);
        actionMap.put(ACTION_BOSS1_HUANXI, 3);
        actionMap.put(ACTION_BOSS1_MINGSI, 4);
        actionMap.put(ACTION_BOSS1_YOUYU, 5);
        actionMap.put(ACTION_BOSS1_JIHAN, 6);
        actionMap.put(ACTION_BOSS1_KONGHE, 7);
        return actionMap;
    }

    public static List<GridItem> getBOSS_FIVE_ActionItemListBegin() {
        ArrayMap<Integer, Integer> map = getBOSS_FIVE_ActionItemMap();
        List<Integer> actionList = getBOSS_FIVE_ActionListBegin();
        List<GridItem> resulktList = new ArrayList<>();
        for (Integer intpos : actionList) {
            int postion = map.get(intpos);
            GridItem mGridItem = new GridItem(intpos, arrText[postion], arrImages[postion]);
            resulktList.add(mGridItem);
        }
        return resulktList;
    }

    public static List<GridItem> getBOSSFIVE_ActionItemList40After() {
        ArrayMap<Integer, Integer> map = getBOSS_FIVE_ActionItemMap();
        List<Integer> actionList = getBOSS_FIVE_ActionListAfter40();
        List<GridItem> resulktList = new ArrayList<>();
        for (Integer intpos : actionList) {
            int postion = map.get(intpos);
            GridItem mGridItem = new GridItem(intpos, arrText[postion], arrImages[postion]);
            resulktList.add(mGridItem);
        }
        return resulktList;
    }

    public static List<Integer> getBOSS_FIVE_ActionListBegin() {
        List<Integer> actionList = new ArrayList<>();
        actionList.add(ACTION_BOSS1_XUJIN);   //须禁
        actionList.add(ACTION_BOSS1_MIMANG);   //迷茫
        actionList.add(ACTION_BOSS1_KUANGNU);   //狂怒
        actionList.add(ACTION_BOSS1_HUANXI);   //欢喜
        actionList.add(ACTION_BOSS1_XUJIN);   //须禁
        actionList.add(ACTION_BOSS1_MIMANG);   //迷茫
        actionList.add(ACTION_BOSS1_MINGSI);   //冥思
        actionList.add(ACTION_BOSS1_YOUYU);   //忧郁
        actionList.add(ACTION_BOSS1_MIMANG);   //迷茫
        actionList.add(ACTION_BOSS1_JIHAN);   //极寒
        actionList.add(ACTION_BOSS1_YOUYU);   //忧郁
        actionList.add(ACTION_BOSS1_XUJIN);   //须禁

        actionList.add(ACTION_BOSS1_YOUYU);   //忧郁
        actionList.add(ACTION_BOSS1_XUJIN);   //须禁
        actionList.add(ACTION_BOSS1_KONGHE);   //恐吓
        actionList.add(ACTION_BOSS1_MIMANG);   //迷茫
        actionList.add(ACTION_BOSS1_KUANGNU);   //狂怒


        return actionList;
    }

    public  static  List<Integer> getBOSS_FIVE_ActionListAfter40() {
        List<Integer> actionList = new ArrayList<>();
        actionList.add(ACTION_BOSS1_XUJIN);   //须禁
        actionList.add(ACTION_BOSS1_MIMANG);   //迷茫
        actionList.add(ACTION_BOSS1_KUANGNU);   //狂怒
        actionList.add(ACTION_BOSS1_HUANXI);   //欢喜
        actionList.add(ACTION_BOSS1_XUJIN);   //须禁
        actionList.add(ACTION_BOSS1_MIMANG);   //迷茫
        actionList.add(ACTION_BOSS1_MINGSI);   //冥思
        actionList.add(ACTION_BOSS1_YOUYU);   //忧郁
        actionList.add(ACTION_BOSS1_MIMANG);   //迷茫
        actionList.add(ACTION_BOSS1_JIHAN);   //极寒
        actionList.add(ACTION_BOSS1_YOUYU);   //忧郁
        actionList.add(ACTION_BOSS1_XUJIN);   //须禁

        actionList.add(ACTION_BOSS1_YOUYU);   //忧郁
        actionList.add(ACTION_BOSS1_XUJIN);   //须禁
        actionList.add(ACTION_BOSS1_KONGHE);   //恐吓
        actionList.add(ACTION_BOSS1_MIMANG);   //迷茫
        actionList.add(ACTION_BOSS1_KUANGNU);   //狂怒
        return actionList;
    }
}
