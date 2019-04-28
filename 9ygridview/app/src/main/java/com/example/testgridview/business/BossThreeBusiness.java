package com.example.testgridview.business;

import com.example.testgridview.model.GridItem;
import java.util.List;

/**
 * Created by jings on 2019/3/17.
 */

public class BossThreeBusiness {

    public static String updateCheckedItemList(int selectedType, List<GridItem> itemList,
        int previousClickType) {
        String checkResult = "";
        for (int i = 0; i < itemList.size(); i++) {
            //for(GridItem item:itemList){
            GridItem item = itemList.get(i);

            //只在textview 中精确显示
            if (item.getItemType() == previousClickType) {
                int slectedIndex = checkIsNextTwoIsSellectType(i, itemList, selectedType);
                if (slectedIndex > 0) {
                    checkResult += "solution num" + slectedIndex;
                    checkResult += "\n";
                    checkResult += getNexTwoString(slectedIndex, itemList);
                }
            }
            //list view 上的 还是 全部标识
            if(item.getItemType() == selectedType){
                item.setSelected(true);
            }
            else{
                item.setSelected(false);
            }
        }
        return checkResult;
    }


    public static String updateCheckedItemList(int selectedType,List<GridItem> itemList ){
        String checkResult = "";
        for(int i=0;i< itemList.size();i++){
        //for(GridItem item:itemList){
            GridItem item = itemList.get(i);
            if(item.getItemType() == selectedType){
                item.setSelected(true);
                checkResult += "solution num" + i;
                checkResult += "\n";
                checkResult += getNexTwoString(i, itemList);
            }
            else{
                item.setSelected(false);
            }
        }
        return checkResult;

    }

    public static int checkIsNextTwoIsSellectType(int positon,List<GridItem> itemList,int selectedType){
        int index = -1;
        if(positon < itemList.size()-2){
            if( itemList.get(positon+1).getItemType() == selectedType){
                index = positon+1;
            }
            if( itemList.get(positon+2).getItemType() == selectedType){
                index = positon+2;
            }
        }
        else if(positon == itemList.size()-2){
            if( itemList.get(positon+1).getItemType() == selectedType){
                index = positon+1;
            }
            if( itemList.get(0).getItemType() == selectedType){
                index = 0;
            }
        }
        else if(positon == itemList.size()-1){
            if( itemList.get(0).getItemType() == selectedType){
                index = 0;
            }
            if( itemList.get(1).getItemType() == selectedType){
                index = 1;
            }
        }
        return index;
    }

    public static String getNexTwoString(int positon,List<GridItem> itemList){
        String checkResult = "";
        if(positon < itemList.size()-2){
            checkResult += itemList.get(positon+1).getItemName();
            checkResult += "\n";
            checkResult += itemList.get(positon+2).getItemName();
            checkResult += "\n";
        }
        else if(positon == itemList.size()-2){
            checkResult += itemList.get(positon+1).getItemName();
            checkResult += "\n";
            checkResult += itemList.get(0).getItemName();
            checkResult += "\n";
        }
        else if(positon == itemList.size()-1){
            checkResult += itemList.get(0).getItemName();
            checkResult += "\n";
            checkResult += itemList.get(1).getItemName();
            checkResult += "\n";
        }
        return checkResult;
    }
}
