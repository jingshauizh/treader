package com.example.testgridview.model;

/**
 * Created by jings on 2019/3/17.
 */

public class GridItem {
    private int itemType;
    private String itemName;
    private int imageId;
    private boolean isSelected;

    public GridItem(String itemName, int imageId) {
        this.itemName = itemName;
        this.imageId = imageId;
        this.isSelected = false;
    }

    public GridItem(int itemType, String itemName, int imageId) {
        this.itemType = itemType;
        this.itemName = itemName;
        this.imageId = imageId;
        this.isSelected = false;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
