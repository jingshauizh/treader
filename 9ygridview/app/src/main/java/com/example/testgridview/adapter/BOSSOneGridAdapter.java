package com.example.testgridview.adapter;

/**
 * Created by jings on 2019/3/17.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testgridview.R;
import com.example.testgridview.model.GridItem;
import java.util.List;

/**
 * Created by jihe on 16/8/23.
 */
public class BOSSOneGridAdapter extends BaseAdapter {
    private Context context;
    private GridView mGv;
    private List<GridItem> actionItems;
    private static int ROW_NUMBER = 3;

    public BOSSOneGridAdapter(Context context, GridView gv) {
        this.context = context;
        this.mGv = gv;
    }

    public BOSSOneGridAdapter(Context context, GridView gv, List<GridItem> pactionItems) {
        this.context = context;
        this.mGv = gv;
        actionItems = pactionItems;
    }

    @Override
    public int getCount() {
        if (null != actionItems) {
            return actionItems.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return actionItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder;
        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item, null);
            holder.iv = (ImageView) convertView.findViewById(R.id.image);
            //设置显示图片
            holder.iv.setBackgroundResource(actionItems.get(position).getImageId());
            holder.tv = (TextView) convertView.findViewById(R.id.text);
            //设置标题
            holder.tv.setText(actionItems.get(position).getItemName());
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        if (actionItems.get(position).isSelected()) {
            holder.tv.setBackgroundColor(context.getResources().getColor(R.color.item_selected));
        } else {
            holder.tv.setBackground(context.getResources().getDrawable(R.drawable.transparent));
        }

        ////高度计算
        //AbsListView.LayoutParams param =
        //    new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
        //        mGv.getHeight() / ROW_NUMBER);

        //convertView.setLayoutParams(param);
        return convertView;
    }

    class Holder {
        ImageView iv;
        TextView tv;
    }

    public List<GridItem> getActionItems() {
        return actionItems;
    }

    public void setActionItems(List<GridItem> actionItems) {
        this.actionItems = actionItems;
        this.notifyDataSetChanged();
    }
}