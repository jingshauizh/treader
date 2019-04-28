package com.example.testgridview.constraint;

import android.support.v4.util.ArrayMap;
import com.example.testgridview.R;
import com.example.testgridview.model.GridItem;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jings on 2019/3/17.
 */

public class BossConstraintThree {
    public static String LOG_TAG = "action";


    public static int ACTION_BOSS1_JI = 3001;
    public static int ACTION_BOSS1_SHANG = ACTION_BOSS1_JI + 1;
    public static int ACTION_BOSS1_YIN = ACTION_BOSS1_SHANG + 1;
    public static int ACTION_BOSS1_SHI = ACTION_BOSS1_YIN + 1;
    public static int ACTION_BOSS1_SHE = ACTION_BOSS1_SHI + 1;

    /**
     * 数据资源：标题 ＋ 图片
     */
    private static String[] arrText = new String[] {
        "寂", "殇", "呤", "弑", "赦"
    };
    private static int[] arrImages = new int[] {
        R.drawable.address_book, R.drawable.calendar, R.drawable.camera, R.drawable.clock,
        R.drawable.games_control,
    };

    public static ArrayMap<Integer, Integer> getBOSS_THREE_ActionItemMap() {
        ArrayMap<Integer, Integer> actionMap = new ArrayMap<Integer, Integer>();
        actionMap.put(ACTION_BOSS1_JI, 0);
        actionMap.put(ACTION_BOSS1_SHANG, 1);
        actionMap.put(ACTION_BOSS1_YIN, 2);
        actionMap.put(ACTION_BOSS1_SHI, 3);
        actionMap.put(ACTION_BOSS1_SHE, 4);
        return actionMap;
    }

    public static List<GridItem> getBOSS_THREE_ActionItemListBegin() {
        ArrayMap<Integer, Integer> map = getBOSS_THREE_ActionItemMap();
        List<Integer> actionList = getBOSS_THREE_ActionListBegin();
        List<GridItem> resulktList = new ArrayList<>();
        for (Integer intpos : actionList) {
            int postion = map.get(intpos);
            GridItem mGridItem = new GridItem(intpos, arrText[postion], arrImages[postion]);
            resulktList.add(mGridItem);
        }
        return resulktList;
    }


    /***
     *
     *
     寂
     殇
     呤
     弑
     赦
     殇
     弑
     殇
     赦
     弑
     殇
     寂
     *
     * @return
     */
    public static List<Integer> getBOSS_THREE_ActionListBegin() {
        List<Integer> actionList = new ArrayList<>();
        actionList.add(ACTION_BOSS1_JI);
        actionList.add(ACTION_BOSS1_SHANG);
        actionList.add(ACTION_BOSS1_YIN);
        actionList.add(ACTION_BOSS1_SHI);
        actionList.add(ACTION_BOSS1_SHE);
        actionList.add(ACTION_BOSS1_SHANG);
        actionList.add(ACTION_BOSS1_SHI);
        actionList.add(ACTION_BOSS1_SHANG);
        actionList.add(ACTION_BOSS1_SHE);
        actionList.add(ACTION_BOSS1_SHI);
        actionList.add(ACTION_BOSS1_SHANG);
        actionList.add(ACTION_BOSS1_JI);
        return actionList;
    }
}
